package com.funhappyit.minihomepage.guestbook;

import com.funhappyit.minihomepage.domain.guestbook.Guestbook;
import com.funhappyit.minihomepage.domain.guestbook.GuestbookRepository;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 * 방명록 작성/조회/삭제 처리
 *
 * @PackageName : com.funhappyit.minihomepage.guestbook
 * @FileName    : GuestbookService.java
 * @Author      : AMIESOFT-HYK
 * @Date        : 2026-07-16
 * @Description : 로그인 없이 닉네임/비밀번호로 방명록을 작성/삭제 - 삭제 시 비밀번호 일치 여부만 검증 <br>
 */
@Service
public class GuestbookService {

    private final GuestbookRepository guestbookRepository;
    private final PasswordEncoder passwordEncoder;

    public GuestbookService(GuestbookRepository guestbookRepository, PasswordEncoder passwordEncoder) {
        this.guestbookRepository = guestbookRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<GuestbookResponse> findAll() {
        return guestbookRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt")).stream()
                .map(GuestbookResponse::from)
                .toList();
    }

    public GuestbookResponse create(GuestbookCreateRequest request) {
        Guestbook guestbook = new Guestbook(
                request.nickname(),
                passwordEncoder.encode(request.password()),
                request.content()
        );
        return GuestbookResponse.from(guestbookRepository.save(guestbook));
    }

    public void delete(Long id, GuestbookDeleteRequest request) {
        Guestbook guestbook = guestbookRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 방명록 글입니다."));

        if (!passwordEncoder.matches(request.password(), guestbook.getPasswordHash())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 올바르지 않습니다.");
        }

        guestbookRepository.delete(guestbook);
    }
}
