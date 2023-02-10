package com.example.blog.test;

import org.springframework.web.bind.annotation.*;

// 사용자가 요청 -> 응답(Data)
@RestController
public class HttpControllerTest {

    @GetMapping("/http/get")
    public String getTest(){
        return "get 요청";
    }
    @PostMapping("/http/post")
    public String postTest(){
        return "post 요청";
    }
    @PutMapping("/http/put")
    public String putTest(){
        return "put요청";
    }
    @DeleteMapping("/http/delete")
    public String deleteTest(){
        return "delete 요청";
    }

}
