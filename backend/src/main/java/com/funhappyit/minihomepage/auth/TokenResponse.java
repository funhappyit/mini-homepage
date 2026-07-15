package com.funhappyit.minihomepage.auth;

/**
 * JWT 토큰 응답
 *
 * @PackageName : com.funhappyit.minihomepage.auth
 * @FileName    : TokenResponse.java
 * @Author      : AMIESOFT-HYK
 * @Date        : 2026-07-14
 * @Description : 로그인/토큰 재발급 API의 공통 응답 바디 <br>
 */
public record TokenResponse(
        String accessToken,
        String refreshToken
) {
}
