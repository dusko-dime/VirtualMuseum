package com.etfbl.dimitric.service.util.impl;

import com.etfbl.dimitric.model.redis.RefreshToken;
import com.etfbl.dimitric.repository.redis.RefreshTokenRepository;
import com.etfbl.dimitric.service.util.RedisService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RedisServiceImpl implements RedisService {

    private final RefreshTokenRepository refreshTokenRepository;

    public RedisServiceImpl(RefreshTokenRepository refreshTokenRepository) {
        this.refreshTokenRepository = refreshTokenRepository;
    }

    @Override
    public void saveRefreshToken(String jwt, RefreshToken refreshToken) {
        refreshTokenRepository.save(jwt, refreshToken);
    }

    @Override
    public Map<String, RefreshToken> findAllRefreshToken() {
        return refreshTokenRepository.findAll();
    }

    @Override
    public RefreshToken findRefreshTokenByJwt(String jwt) {
        return refreshTokenRepository.findByJwt(jwt);
    }

    @Override
    public void updateRefreshToken(String jwt, RefreshToken refreshToken) {
        refreshTokenRepository.update(jwt, refreshToken);
    }

    @Override
    public void deleteRefreshToken(String jwt) {
        refreshTokenRepository.delete(jwt);
    }
}