package com.funhappyit.minihomepage.domain.visit;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

/**
 * 일자별 방문자수 엔티티
 *
 * @PackageName : com.funhappyit.minihomepage.domain.visit
 * @FileName    : VisitCounter.java
 * @Author      : AMIESOFT-HYK
 * @Date        : 2026-07-16
 * @Description : 날짜별 방문 횟수 - TOTAL은 전체 합산으로 계산 <br>
 */
@Entity
@Table(name = "visit_counter")
public class VisitCounter {

    @Id
    @Column(name = "visit_date", nullable = false)
    private LocalDate visitDate;

    @Column(nullable = false)
    private long count;

    protected VisitCounter() {
    }

    public VisitCounter(LocalDate visitDate, long count) {
        this.visitDate = visitDate;
        this.count = count;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public long getCount() {
        return count;
    }

    public void increment() {
        this.count += 1;
    }
}
