package com.funhappyit.minihomepage.guestbook;

import jakarta.validation.constraints.NotBlank;

/**
 * 방명록 삭제 요청
 *
 * @PackageName : com.funhappyit.minihomepage.guestbook
 * @FileName    : GuestbookDeleteRequest.java
 * @Author      : AMIESOFT-HYK
 * @Date        : 2026-07-16
 * @Description : DELETE /api/v1/guestbook/{id} 요청 바디 - 작성 시 입력한 비밀번호 검증용 <br>
 */
public record GuestbookDeleteRequest(
        @NotBlank String password
) {
}
