package com.funhappyit.minihomepage.diary;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * 다이어리 작성/수정 요청
 *
 * @PackageName : com.funhappyit.minihomepage.diary
 * @FileName    : DiaryRequest.java
 * @Author      : AMIESOFT-HYK
 * @Date        : 2026-07-16
 * @Description : POST/PUT /api/v1/diary 요청 바디 - 관리자 인증 필요 <br>
 */
public record DiaryRequest(
        @NotBlank @Size(max = 100) String title,
        @NotBlank String content
) {
}
