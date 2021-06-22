package com.etfbl.dimitric.repository.redis;

import com.etfbl.dimitric.model.redis.RefreshToken;

import java.util.Map;

public interface RefreshTokenRepository {

    void save(String accessToken, RefreshToken refreshToken);
    Map<String,RefreshToken> findAll();
    RefreshToken findByJwt(String accessToken);
    void update(String accessToken, RefreshToken refreshToken);
    void delete(String accessToken);
}
