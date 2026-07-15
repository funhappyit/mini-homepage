package com.funhappyit.minihomepage.security;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * JWT 설정값 바인딩
 *
 * @PackageName : com.funhappyit.minihomepage.security
 * @FileName    : JwtProperties.java
 * @Author      : AMIESOFT-HYK
 * @Date        : 2026-07-14
 * @Description : application.yml의 app.jwt.* 값을 바인딩 <br>
 */
@ConfigurationProperties(prefix = "app.jwt")
public class JwtProperties {

    private String secret;
    private long accessTokenExpirationMs;
    private long refreshTokenExpirationMs;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public long getAccessTokenExpirationMs() {
        return accessTokenExpirationMs;
    }

    public void setAccessTokenExpirationMs(long accessTokenExpirationMs) {
        this.accessTokenExpirationMs = accessTokenExpirationMs;
    }

    public long getRefreshTokenExpirationMs() {
        return refreshTokenExpirationMs;
    }

    public void setRefreshTokenExpirationMs(long refreshTokenExpirationMs) {
        this.refreshTokenExpirationMs = refreshTokenExpirationMs;
    }
}
