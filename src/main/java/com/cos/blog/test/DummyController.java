package com.cos.blog.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.model.UserInfo;
import com.cos.blog.repository.UserInfoRepository;

@RestController
public class DummyController {
  
  @Autowired // 의존성 주입(DI) 
  private UserInfoRepository UserInfoRepository;
  
  // http://localhost:8000/blog/dummy/join (요청)
  // http 의 body 에 username, password, email 데이터를 가지고 (요청)
//  @PostMapping("/dummy/join")
//  public String join(String username, String password, String email) { // key=value (약속된 규칙)
//    System.out.println("username : " + username);
//    System.out.println("password : " + password);
//    System.out.println("email : " + email);
//    return "회원가입이 완료되었습니다.";
//  }
  @PostMapping("/dummy/join")
  public String join(UserInfo userInfo) { // key=value (약속된 규칙)
    System.out.println("id : " + userInfo.getId());
    System.out.println("username : " + userInfo.getUsername());
    System.out.println("password : " + userInfo.getPassword());
    System.out.println("email : " + userInfo.getEmail());
    System.out.println("role : " + userInfo.getRole());
    System.out.println("createDate : " + userInfo.getCreateDate());
    
    UserInfoRepository.save(userInfo);
    
    return "회원가입이 완료되었습니다.";
  }

}
