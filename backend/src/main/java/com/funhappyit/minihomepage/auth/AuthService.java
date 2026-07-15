package com.funhappyit.minihomepage.auth;

import com.funhappyit.minihomepage.domain.admin.Admin;
import com.funhappyit.minihomepage.domain.admin.AdminRepository;
import com.funhappyit.minihomepage.security.JwtTokenProvider;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 * 관리자 로그인 및 토큰 재발급 처리
 *
 * @PackageName : com.funhappyit.minihomepage.auth
 * @FileName    : AuthService.java
 * @Author      : AMIESOFT-HYK
 * @Date        : 2026-07-14
 * @Description : 회원가입 없는 단일 관리자 로그인 - 아이디/비밀번호 검증 후 JWT 발급 <br>
 */
@Service
public class AuthService {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthService(AdminRepository adminRepository,
                        PasswordEncoder passwordEncoder,
                        JwtTokenProvider jwtTokenProvider) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public TokenResponse login(String username, String password) {
        Admin admin = adminRepository.findByUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "아이디 또는 비밀번호가 올바르지 않습니다."));

        if (!passwordEncoder.matches(password, admin.getPasswordHash())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "아이디 또는 비밀번호가 올바르지 않습니다.");
        }

        return issueTokens(admin.getUsername());
    }

    public TokenResponse refresh(String refreshToken) {
        if (!jwtTokenProvider.validateToken(refreshToken) || !jwtTokenProvider.isRefreshToken(refreshToken)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "유효하지 않은 refresh token 입니다.");
        }

        String username = jwtTokenProvider.getUsername(refreshToken);
        if (!adminRepository.existsByUsername(username)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "존재하지 않는 관리자입니다.");
        }

        return issueTokens(username);
    }

    private TokenResponse issueTokens(String username) {
        return new TokenResponse(
                jwtTokenProvider.generateAccessToken(username),
                jwtTokenProvider.generateRefreshToken(username)
        );
    }
}
