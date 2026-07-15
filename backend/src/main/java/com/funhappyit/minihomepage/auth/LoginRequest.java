package com.funhappyit.minihomepage.auth;

import jakarta.validation.constraints.NotBlank;

/**
 * 관리자 로그인 요청
 *
 * @PackageName : com.funhappyit.minihomepage.auth
 * @FileName    : LoginRequest.java
 * @Author      : AMIESOFT-HYK
 * @Date        : 2026-07-14
 * @Description : POST /api/v1/auth/login 요청 바디 <br>
 */
public record LoginRequest(
        @NotBlank String username,
        @NotBlank String password
) {
}
