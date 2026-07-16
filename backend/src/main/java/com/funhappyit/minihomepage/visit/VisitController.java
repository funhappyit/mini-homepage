package com.funhappyit.minihomepage.visit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 방문자수 API
 *
 * @PackageName : com.funhappyit.minihomepage.visit
 * @FileName    : VisitController.java
 * @Author      : AMIESOFT-HYK
 * @Date        : 2026-07-16
 * @Description : 로그인 없이 누구나 조회/증가 가능 <br>
 */
@RestController
@RequestMapping("/api/v1/visits")
public class VisitController {

    private final VisitService visitService;

    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @GetMapping
    public VisitResponse getStats() {
        return visitService.getStats();
    }

    @PostMapping("/increment")
    public VisitResponse increment() {
        visitService.increment();
        return visitService.getStats();
    }
}
