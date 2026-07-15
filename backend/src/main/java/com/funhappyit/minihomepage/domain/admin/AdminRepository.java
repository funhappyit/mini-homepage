package com.funhappyit.minihomepage.domain.admin;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 관리자 계정 레포지토리
 *
 * @PackageName : com.funhappyit.minihomepage.domain.admin
 * @FileName    : AdminRepository.java
 * @Author      : AMIESOFT-HYK
 * @Date        : 2026-07-14
 * @Description : Admin 엔티티 조회용 레포지토리 <br>
 */
public interface AdminRepository extends JpaRepository<Admin, Long> {

    Optional<Admin> findByUsername(String username);

    boolean existsByUsername(String username);
}
