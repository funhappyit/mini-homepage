package com.funhappyit.minihomepage.visit;

import com.funhappyit.minihomepage.domain.visit.VisitCounter;
import com.funhappyit.minihomepage.domain.visit.VisitCounterRepository;
import java.time.LocalDate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 방문자수 조회/증가 처리
 *
 * @PackageName : com.funhappyit.minihomepage.visit
 * @FileName    : VisitService.java
 * @Author      : AMIESOFT-HYK
 * @Date        : 2026-07-16
 * @Description : 오늘 날짜 로우를 증가시키고, TOTAL은 전체 합산으로 계산 <br>
 */
@Service
public class VisitService {

    private final VisitCounterRepository visitCounterRepository;

    public VisitService(VisitCounterRepository visitCounterRepository) {
        this.visitCounterRepository = visitCounterRepository;
    }

    @Transactional
    public void increment() {
        LocalDate today = LocalDate.now();
        VisitCounter counter = visitCounterRepository.findById(today)
                .orElseGet(() -> new VisitCounter(today, 0));
        counter.increment();
        visitCounterRepository.save(counter);
    }

    public VisitResponse getStats() {
        long today = visitCounterRepository.findById(LocalDate.now())
                .map(VisitCounter::getCount)
                .orElse(0L);
        long total = visitCounterRepository.sumTotalCount();
        return new VisitResponse(today, total);
    }
}
