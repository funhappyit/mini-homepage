package com.funhappyit.minihomepage.diary;

import jakarta.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 다이어리 API
 *
 * @PackageName : com.funhappyit.minihomepage.diary
 * @FileName    : DiaryController.java
 * @Author      : AMIESOFT-HYK
 * @Date        : 2026-07-16
 * @Description : 조회(GET)는 공개, 작성/수정/삭제는 SecurityConfig에서 인증 필요로 강제 <br>
 */
@RestController
@RequestMapping("/api/v1/diary")
public class DiaryController {

    private final DiaryService diaryService;

    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @GetMapping
    public List<DiaryResponse> findAll() {
        return diaryService.findAll();
    }

    @GetMapping("/{id}")
    public DiaryResponse findById(@PathVariable Long id) {
        return diaryService.findById(id);
    }

    @PostMapping
    public DiaryResponse create(@Valid @RequestBody DiaryRequest request) {
        return diaryService.create(request);
    }

    @PutMapping("/{id}")
    public DiaryResponse update(@PathVariable Long id, @Valid @RequestBody DiaryRequest request) {
        return diaryService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        diaryService.delete(id);
    }
}
