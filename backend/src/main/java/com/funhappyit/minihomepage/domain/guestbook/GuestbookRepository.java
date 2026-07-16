package com.funhappyit.minihomepage.domain.guestbook;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * 방명록 레포지토리
 *
 * @PackageName : com.funhappyit.minihomepage.domain.guestbook
 * @FileName    : GuestbookRepository.java
 * @Author      : AMIESOFT-HYK
 * @Date        : 2026-07-16
 * @Description : Guestbook 엔티티 조회/저장용 레포지토리 <br>
 */
public interface GuestbookRepository extends JpaRepository<Guestbook, Long> {

    List<Guestbook> findAll(Sort sort);
}
