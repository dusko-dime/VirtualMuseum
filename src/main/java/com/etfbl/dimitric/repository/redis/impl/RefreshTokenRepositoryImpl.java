package com.etfbl.dimitric.repository.redis.impl;

import com.etfbl.dimitric.model.redis.RefreshToken;
import com.etfbl.dimitric.repository.redis.RefreshTokenRepository;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class RefreshTokenRepositoryImpl implements RefreshTokenRepository {

    private RedisTemplate<String, RefreshToken> redisTemplate;
    private HashOperations hashOperations;

    public RefreshTokenRepositoryImpl(RedisTemplate<String, RefreshToken> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(String accessToken, RefreshToken refreshToken) {
        hashOperations.put("REFRESH_TOKEN", accessToken, refreshToken);
    }

    @Override
    public Map<String, RefreshToken> findAll() {
        return hashOperations.entries("REFRESH_TOKEN");
    }

    @Override
    public RefreshToken findByJwt(String accessToken) {
        return (RefreshToken)hashOperations.get("REFRESH_TOKEN", accessToken);
    }

    @Override
    public void update(String accessToken, RefreshToken refreshToken) {
        save(accessToken, refreshToken);
    }

    @Override
    public void delete(String accessToken) {
        hashOperations.delete("REFRESH_TOKEN", accessToken);
    }
}