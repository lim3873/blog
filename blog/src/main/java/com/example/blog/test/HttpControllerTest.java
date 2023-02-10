package com.example.blog.test;

import org.springframework.web.bind.annotation.*;

// 사용자가 요청 -> 응답(Data)
// 인터넷 요청은 get요청밖에 할수 없다
@RestController
public class HttpControllerTest {

    private static final String TAG = "HttpControllerTest:";

    @GetMapping("/http/lombok")
    public String lombokTest(){
        Member m = Member.builder().username("ssar").password("1234").email("ssar@nate.com").build();
        System.out.println(TAG+"getter : " + m.getUsername());
        m.setUsername("cos");
        System.out.println(TAG+"Setter : " + m.getUsername());
        return "lombok test 완료";

    }    @GetMapping("/http/get")
    public String getTest(Member m){
        return "get 요청 :" + m.getId()+","+m.getUsername()+","+m.getPassword()+","+m.getEmail();
    }
    @PostMapping("/http/post")
    public String postTest(@RequestBody Member m){
        return "get 요청 :" + m.getId()+","+m.getUsername()+","+m.getPassword()+","+m.getEmail();
    }
    @PutMapping("/http/put")
    public String putTest(@RequestBody Member m){
        return "get 요청 :" + m.getId()+","+m.getUsername()+","+m.getPassword()+","+m.getEmail();
    }
    @DeleteMapping("/http/delete")
    public String deleteTest(){
        return "delete 요청";
    }

}
