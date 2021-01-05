package com.cos.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder // 빌더 패턴!!!
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "board")
@Table(name = "board")
public class Board {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
  private int id;
  
  @Column(name = "title", nullable = false, length = 100)
  private String title;
  
  @Lob // 대용량 데이터
  private String content; // 섬모노트 라이브러리 <html> 태그가 섞여서 디자인이 됨.
  
  @ColumnDefault("0")
  private int count; // 조회수
  
  @ManyToOne(fetch = FetchType.EAGER) // Many = Many, User = One
  @JoinColumn(name = "user_id")
  private UserInfo userInfo; // DB는 오브젝트를 저장할 수 없다. FK, 자바는 오브젝트를 저장할 수 있다.
  
  @OneToMany(mappedBy = "board", fetch = FetchType.EAGER) // mappedBy 연관관계의 주인이 아니다 (난 FK가 아니에요) DB에 컬럼을 만들지 마세요.
  private List<Reply> reply;
  
  @CreationTimestamp
  private Timestamp createDate;
  
  
}
