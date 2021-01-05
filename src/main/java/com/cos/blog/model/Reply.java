package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder // 빌더 패턴!!!
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "reply")
@Table(name = "reply")
public class Reply {
  
  @Id // Primary key
  @GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
  private int id; // 시퀸스, auto_increment
  
  @Column(name = "content", nullable = false, length = 200)
  private String content;
  
  @ManyToOne
  @JoinColumn(name = "board_id")
  private Board board;
  
  @ManyToOne
  @JoinColumn(name = "user_id")
  private UserInfo userInfo;
  
  @CreationTimestamp
  private Timestamp createDate;
}
