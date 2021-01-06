package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
//ORM -> Java(다른언어) Object -> 테이블로 매핑해주는 기술
@Entity(name = "user_info") // User 클래스가 PostgreSQL 에 테이블이 생성이 된다.
@Table(name = "user_info")
public class UserInfo { // **의문 : postgreSQL 은 User 로 테이블 생성이 안되나???;;
  
  @Id // Primary key
  @GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
//  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_info_id_seq")
  private int id; // 시퀸스, auto_increment
  
  @Column(name = "username", nullable = false, length = 30)
  private String username; // 아이디
  
  @Column(name = "password", nullable = false, length = 100) // 12345 => 해쉬(비밀번호 암호화)
  private String password;
  
  @Column(name = "email", nullable = false, length = 30)
  private String email;
  
  @ColumnDefault("'user'")
  private String role; // Enum 을 쓰는게 좋다. (domain(범위) 설정을 할 수 있다.) // admin, user, manager 
  
  @CreationTimestamp // 시간이 자동 입력
  private Timestamp createDate;

}
