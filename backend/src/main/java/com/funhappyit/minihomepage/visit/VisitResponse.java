package com.funhappyit.minihomepage.visit;

/**
 * 방문자수 응답
 *
 * @PackageName : com.funhappyit.minihomepage.visit
 * @FileName    : VisitResponse.java
 * @Author      : AMIESOFT-HYK
 * @Date        : 2026-07-16
 * @Description : TODAY/TOTAL 방문자수 응답 <br>
 */
public record VisitResponse(
        long today,
        long total
) {
}
