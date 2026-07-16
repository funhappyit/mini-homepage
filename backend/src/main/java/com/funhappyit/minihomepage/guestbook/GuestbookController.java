package com.funhappyit.minihomepage.guestbook;

import jakarta.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 방명록 API
 *
 * @PackageName : com.funhappyit.minihomepage.guestbook
 * @FileName    : GuestbookController.java
 * @Author      : AMIESOFT-HYK
 * @Date        : 2026-07-16
 * @Description : 로그인 없이 누구나 조회/작성 가능, 삭제는 작성 시 비밀번호 검증 필요 <br>
 */
@RestController
@RequestMapping("/api/v1/guestbook")
public class GuestbookController {

    private final GuestbookService guestbookService;

    public GuestbookController(GuestbookService guestbookService) {
        this.guestbookService = guestbookService;
    }

    @GetMapping
    public List<GuestbookResponse> findAll() {
        return guestbookService.findAll();
    }

    @PostMapping
    public GuestbookResponse create(@Valid @RequestBody GuestbookCreateRequest request) {
        return guestbookService.create(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id, @Valid @RequestBody GuestbookDeleteRequest request) {
        guestbookService.delete(id, request);
    }
}
