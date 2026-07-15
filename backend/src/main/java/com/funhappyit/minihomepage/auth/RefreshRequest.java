package com.funhappyit.minihomepage.auth;

import jakarta.validation.constraints.NotBlank;

/**
 * Access Token 재발급 요청
 *
 * @PackageName : com.funhappyit.minihomepage.auth
 * @FileName    : RefreshRequest.java
 * @Author      : AMIESOFT-HYK
 * @Date        : 2026-07-14
 * @Description : POST /api/v1/auth/refresh 요청 바디 <br>
 */
public record RefreshRequest(
        @NotBlank String refreshToken
) {
}
