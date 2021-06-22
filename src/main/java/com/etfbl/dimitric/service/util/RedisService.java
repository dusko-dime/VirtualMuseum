package com.etfbl.dimitric.service.util;

import com.etfbl.dimitric.model.redis.RefreshToken;

import java.util.Map;

public interface RedisService {
    void saveRefreshToken(String jwt, RefreshToken refreshToken);
    Map<String,RefreshToken> findAllRefreshToken();
    RefreshToken findRefreshTokenByJwt(String jwt);
    void updateRefreshToken(String jwt, RefreshToken refreshToken);
    void deleteRefreshToken(String jwt);
}
