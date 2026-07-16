package com.funhappyit.minihomepage.diary;

import com.funhappyit.minihomepage.domain.diary.Diary;
import java.time.LocalDateTime;

/**
 * 다이어리 응답
 *
 * @PackageName : com.funhappyit.minihomepage.diary
 * @FileName    : DiaryResponse.java
 * @Author      : AMIESOFT-HYK
 * @Date        : 2026-07-16
 * @Description : 다이어리 목록/상세 조회 응답 <br>
 */
public record DiaryResponse(
        Long id,
        String title,
        String content,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static DiaryResponse from(Diary diary) {
        return new DiaryResponse(
                diary.getId(),
                diary.getTitle(),
                diary.getContent(),
                diary.getCreatedAt(),
                diary.getUpdatedAt()
        );
    }
}
