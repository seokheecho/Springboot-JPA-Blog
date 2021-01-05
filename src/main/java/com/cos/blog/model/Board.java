package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

@Entity(name = "board")
@Table(name = "board")
public class Board {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
  private int id;
  
  @Column(name = "title", nullable = false, length = 100)
  private String title;
  
  @Lob // 대용량 데이터
  private String content; // 섬모노트 라이브러리 <html> 태그가 섞여서 디자인이 됨.
  
  @ColumnDefault("0")
  private int count; // 조회수
  
  @ManyToOne // Many = Many, User = One
  @JoinColumn(name = "user_id")
  private UserInfo userInfo; // DB는 오브젝트를 저장할 수 없다. FK, 자바는 오브젝트를 저장할 수 있다.
  
  @CreationTimestamp
  private Timestamp createDate;
  
  
}
