package com.funhappyit.minihomepage.diary;

import com.funhappyit.minihomepage.domain.diary.Diary;
import com.funhappyit.minihomepage.domain.diary.DiaryRepository;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 * 다이어리 조회/작성/수정/삭제 처리
 *
 * @PackageName : com.funhappyit.minihomepage.diary
 * @FileName    : DiaryService.java
 * @Author      : AMIESOFT-HYK
 * @Date        : 2026-07-16
 * @Description : 조회는 누구나, 작성/수정/삭제는 관리자만 (컨트롤러 레벨에서 인증 처리) <br>
 */
@Service
public class DiaryService {

    private final DiaryRepository diaryRepository;

    public DiaryService(DiaryRepository diaryRepository) {
        this.diaryRepository = diaryRepository;
    }

    public List<DiaryResponse> findAll() {
        return diaryRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt")).stream()
                .map(DiaryResponse::from)
                .toList();
    }

    public DiaryResponse findById(Long id) {
        return DiaryResponse.from(getOrThrow(id));
    }

    public DiaryResponse create(DiaryRequest request) {
        Diary diary = new Diary(request.title(), request.content());
        return DiaryResponse.from(diaryRepository.save(diary));
    }

    public DiaryResponse update(Long id, DiaryRequest request) {
        Diary diary = getOrThrow(id);
        diary.update(request.title(), request.content());
        return DiaryResponse.from(diary);
    }

    public void delete(Long id) {
        diaryRepository.delete(getOrThrow(id));
    }

    private Diary getOrThrow(Long id) {
        return diaryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 다이어리 글입니다."));
    }
}
