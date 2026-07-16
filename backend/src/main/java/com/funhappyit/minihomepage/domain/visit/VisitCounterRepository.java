package com.funhappyit.minihomepage.domain.visit;

import java.time.LocalDate;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * 방문자수 레포지토리
 *
 * @PackageName : com.funhappyit.minihomepage.domain.visit
 * @FileName    : VisitCounterRepository.java
 * @Author      : AMIESOFT-HYK
 * @Date        : 2026-07-16
 * @Description : VisitCounter 엔티티 조회/저장용 레포지토리 <br>
 */
public interface VisitCounterRepository extends JpaRepository<VisitCounter, LocalDate> {

    @Query("select coalesce(sum(v.count), 0) from VisitCounter v")
    long sumTotalCount();
}
