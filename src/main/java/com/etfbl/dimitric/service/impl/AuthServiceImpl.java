package com.etfbl.dimitric.service.impl;

import com.etfbl.dimitric.exceptions.UnauthorizedException;
import com.etfbl.dimitric.model.dto.LoginResponseDTO;
import com.etfbl.dimitric.model.dto.RefreshResponseDTO;
import com.etfbl.dimitric.model.dto.UserLoginResponseDTO;
import com.etfbl.dimitric.model.entity.User;
import com.etfbl.dimitric.model.redis.RefreshToken;
import com.etfbl.dimitric.service.AuthService;
import com.etfbl.dimitric.service.UserService;
import com.etfbl.dimitric.service.util.RedisService;
import com.etfbl.dimitric.util.Constants;
import io.jsonwebtoken.SignatureAlgorithm;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.jsonwebtoken.Jwts;

import java.util.Collections;
import java.util.Date;
import java.util.UUID;

@Service
public class AuthServiceImpl implements AuthService {

    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UserService userService;
    private ModelMapper modelMapper;
    private RedisService redisService;

    @Value("${authorization.access-token.expiration-time}")
    private Long accessTokenExpirationTime;

    @Value("${authorization.refresh-token.expiration-time}")
    private Long refreshTokenExpirationTime;

    @Value("${authorization.token.secret}")
    private String secretToken;

    public AuthServiceImpl(BCryptPasswordEncoder bCryptPasswordEncoder, UserService userService, ModelMapper modelMapper, RedisService redisService){
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.redisService = redisService;
    }

    @Override
    @Transactional
    public LoginResponseDTO login(String username, String password) {
        User user = userService.getByUsername(username);

        if(!bCryptPasswordEncoder.matches(password, user.getPassword())) {
            throw new UnauthorizedException();
        }

        String accessToken = generateAccessToken(user.getUsername(), user.getFirstName(), user.getLastName(), user.getId());
        String refreshToken = UUID.randomUUID().toString();

        UserLoginResponseDTO userDto = modelMapper.map(user, UserLoginResponseDTO.class);

        RefreshToken refreshTokenForRedis = new RefreshToken(refreshToken, new Date(System.currentTimeMillis() + refreshTokenExpirationTime), userDto);

        redisService.saveRefreshToken(accessToken, refreshTokenForRedis);

        LoginResponseDTO loginResponse = new LoginResponseDTO();
        loginResponse.setAccessToken(accessToken);
        loginResponse.setRefreshToken(refreshToken);
        loginResponse.setUser(userDto);

//        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password, Collections.singletonList(new SimpleGrantedAuthority(user.getUserGroup().getKey()))));

        return loginResponse;
    }

    @Override
    public RefreshResponseDTO refresh(String accessToken, String refreshToken) {
        RefreshToken refreshTokenFromRedis = redisService.findRefreshTokenByJwt(accessToken);

        if(refreshTokenFromRedis == null) {
            throw new UnauthorizedException();
        }

        if(!refreshTokenFromRedis.getRefreshToken().equals(refreshToken) || refreshTokenFromRedis.getExpiryDate().before(new Date())) {
            throw new UnauthorizedException();
        }

        redisService.deleteRefreshToken(accessToken);

        UserLoginResponseDTO user = refreshTokenFromRedis.getUser();
        String newAccessToken = generateAccessToken(user.getUsername(), user.getFirstName(), user.getLastName(), user.getId());
        String newRefreshToken = UUID.randomUUID().toString();
        RefreshToken refreshTokenForRedis = new RefreshToken(newRefreshToken, new Date(System.currentTimeMillis() + refreshTokenExpirationTime), user);

        redisService.saveRefreshToken(newAccessToken, refreshTokenForRedis);

        RefreshResponseDTO refreshResponse = new RefreshResponseDTO();
        refreshResponse.setAccessToken(newAccessToken);
        refreshResponse.setRefreshToken(newRefreshToken);

        return refreshResponse;
    }

    @Override
    public void logout(String accessToken) {

    }

    private String generateAccessToken(String username, String firstName, String lastName, Integer userId) {
        String accessToken = Jwts.builder()
                .setSubject(username)
                .setId(userId.toString())
                .claim(Constants.FIRST_NAME, firstName)
                .claim(Constants.LAST_NAME, lastName)
                .claim(Constants.USERNAME, username)
                .setExpiration(new Date(System.currentTimeMillis() + accessTokenExpirationTime))
                .signWith(SignatureAlgorithm.HS512, secretToken)
                .compact();

        return accessToken;
    }
}
