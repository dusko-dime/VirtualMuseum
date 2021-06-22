package com.etfbl.dimitric.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "redis")
public class RedisConfigProperties {
    private String host;
    private Integer port;
    private String password;
}