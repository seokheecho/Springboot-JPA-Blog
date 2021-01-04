package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 사용자가 요청 -> 응담(HTML)
// @Controller 

// 사용자가 요청 -> 응답(Data)
@RestController
public class HttpControllerTest {
  
  private static final String TAG = "HttpControllerTest : ";
  
  @GetMapping("/http/lombok")
  public String lombokTest() {
//    Member m = new Member(1, "hee", "1234", "hee@nate.com");
    Member m = Member.builder().username("hee").password("1234").email("hee").build();
//    System.out.println(TAG + "getter : " + m.getId());
//    m.setId(5000);
//    System.out.println(TAG + "setter : " + m.getId());
    System.out.println(TAG + "getter : " + m.getUsername());
    m.setUsername("cos");
    System.out.println(TAG + "setter : " + m.getUsername());
    return "lombok test 완료";
  }
  
  // 인터넷 브라우저 요청은 무조건 get요청 밖에 할 수 없다.
  // http://localhost:8080/http/get (select)
//  @GetMapping("/http/get")
//  public String getTest(@RequestParam int id, @RequestParam String username) {
//    return "get 요청 : " + id + ", " + username;
//  }
  @GetMapping("/http/get")
  public String getTest(Member m) { // id=1&username=hee&password=1234&email=hee@nate.com // MessageConverter (스프링부트)
    return "get 요청 : " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
  }
  // http://localhost:8080/http/post (insert)
//  @PostMapping("/http/post")
//  public String postTest(Member m) {
//    return "post 요청 : " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
//  }
//  @PostMapping("/http/post") // text/plain, application/json
//  public String postTest(@RequestBody String text) { 
//    return "post 요청 : " + text;
//  }
  @PostMapping("/http/post") // text/plain, application/json
  public String postTest(@RequestBody Member m) { // MessageConverter (스프링부트)
    return "post 요청 : " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
  }
  // http://localhost:8080/http/put (update)
  @PutMapping("/http/put")
  public String putTest(@RequestBody Member m) {
    return "put 요청 : " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
  }
  // http://localhost:8080/http/delete (delete)
  @DeleteMapping("/http/delete")
  public String deleteTest() {
    return "delete 요청 : ";
  }
}
