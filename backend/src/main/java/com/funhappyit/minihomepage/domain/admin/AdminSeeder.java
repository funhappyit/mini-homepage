package com.funhappyit.minihomepage.domain.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * 관리자 계정 자동 시딩
 *
 * @PackageName : com.funhappyit.minihomepage.domain.admin
 * @FileName    : AdminSeeder.java
 * @Author      : AMIESOFT-HYK
 * @Date        : 2026-07-14
 * @Description : 회원가입 API가 없으므로 앱 기동 시 환경변수 기반으로 관리자 계정을 1회 생성 <br>
 */
@Component
public class AdminSeeder implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(AdminSeeder.class);

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    private final String seedUsername;
    private final String seedPassword;

    public AdminSeeder(AdminRepository adminRepository,
                        PasswordEncoder passwordEncoder,
                        @Value("${app.admin.seed-username}") String seedUsername,
                        @Value("${app.admin.seed-password}") String seedPassword) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
        this.seedUsername = seedUsername;
        this.seedPassword = seedPassword;
    }

    @Override
    public void run(String... args) {
        if (seedPassword == null || seedPassword.isBlank()) {
            log.warn("ADMIN_SEED_PASSWORD가 설정되지 않아 관리자 계정 시딩을 건너뜁니다.");
            return;
        }

        if (adminRepository.existsByUsername(seedUsername)) {
            return;
        }

        adminRepository.save(new Admin(seedUsername, passwordEncoder.encode(seedPassword)));
        log.info("관리자 계정 '{}'을(를) 시딩했습니다.", seedUsername);
    }
}
