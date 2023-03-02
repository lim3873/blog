package com.example.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

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
    @ManyToOne(fetch = FetchType.EAGER) // many = Board, user = one , user는 여러개의 게시글을 쓸수있다
    @JoinColumn(name="userid")
    private User user; //DB는 오브젝트를 저장할수 없다. FK, 자바는 오브젝트를 저장할수 있다.

    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY) // mappedBy 연관관계의 주인이 아니다(FK)가 아니다 DB에 칼럼을 만들지말아라
    private List<Reply> reply; // LAZY 필요할때 정보를 땡겨온다

    @CreationTimestamp
    private Timestamp createDate;
}