package com.example.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 100)
    private String title;
    @Lob // 대용량 데이터
    private String content; // 섬머노트 라이브러리<html>태그가 섞여서 디자인됨.
    @ColumnDefault("0")
    private int count; // 조회수
    @ManyToOne // many = Board, user = one , user는 여러개의 게시글을 쓸수있다
    @JoinColumn(name="userid")
    private User user; //DB는 오브젝트를 저장할수 없다. FK, 자바는 오브젝트를 저장할수 있다.
    @CreationTimestamp
    private Timestamp createDate;
}