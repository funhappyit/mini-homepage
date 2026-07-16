package com.funhappyit.minihomepage.guestbook;

import com.funhappyit.minihomepage.domain.guestbook.Guestbook;
import java.time.LocalDateTime;

/**
 * 방명록 응답
 *
 * @PackageName : com.funhappyit.minihomepage.guestbook
 * @FileName    : GuestbookResponse.java
 * @Author      : AMIESOFT-HYK
 * @Date        : 2026-07-16
 * @Description : 방명록 목록 조회 응답 - 비밀번호 해시는 노출하지 않음 <br>
 */
public record GuestbookResponse(
        Long id,
        String nickname,
        String content,
        LocalDateTime createdAt
) {

    public static GuestbookResponse from(Guestbook guestbook) {
        return new GuestbookResponse(
                guestbook.getId(),
                guestbook.getNickname(),
                guestbook.getContent(),
                guestbook.getCreatedAt()
        );
    }
}
