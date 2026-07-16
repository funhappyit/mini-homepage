package com.funhappyit.minihomepage.domain.diary;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 다이어리 레포지토리
 *
 * @PackageName : com.funhappyit.minihomepage.domain.diary
 * @FileName    : DiaryRepository.java
 * @Author      : AMIESOFT-HYK
 * @Date        : 2026-07-16
 * @Description : Diary 엔티티 조회/저장용 레포지토리 <br>
 */
public interface DiaryRepository extends JpaRepository<Diary, Long> {

    List<Diary> findAll(Sort sort);
}
