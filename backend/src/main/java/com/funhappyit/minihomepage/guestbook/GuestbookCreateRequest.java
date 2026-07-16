package com.funhappyit.minihomepage.guestbook;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * 방명록 작성 요청
 *
 * @PackageName : com.funhappyit.minihomepage.guestbook
 * @FileName    : GuestbookCreateRequest.java
 * @Author      : AMIESOFT-HYK
 * @Date        : 2026-07-16
 * @Description : POST /api/v1/guestbook 요청 바디 <br>
 */
public record GuestbookCreateRequest(
        @NotBlank @Size(max = 30) String nickname,
        @NotBlank @Size(max = 100) String password,
        @NotBlank @Size(max = 500) String content
) {
}
