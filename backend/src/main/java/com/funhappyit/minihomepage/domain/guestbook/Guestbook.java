package com.funhappyit.minihomepage.domain.guestbook;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

/**
 * 방명록 엔티티
 *
 * @PackageName : com.funhappyit.minihomepage.domain.guestbook
 * @FileName    : Guestbook.java
 * @Author      : AMIESOFT-HYK
 * @Date        : 2026-07-16
 * @Description : 로그인 없이 닉네임/비밀번호로 작성하는 방명록 글 <br>
 */
@Entity
@Table(name = "guestbook")
public class Guestbook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String nickname;

    @Column(name = "password_hash", nullable = false, length = 100)
    private String passwordHash;

    @Column(nullable = false, length = 500)
    private String content;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    protected Guestbook() {
    }

    public Guestbook(String nickname, String passwordHash, String content) {
        this.nickname = nickname;
        this.passwordHash = passwordHash;
        this.content = content;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
