package com.example.blog.model;

import com.example.blog.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyControllerTest {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/dummy/join")
    public String join(User user){
        System.out.println("id : "+user.getId());
        System.out.println("username : " + user.getUsername());
        System.out.println("password : " + user.getPassword());
        System.out.println("email : " + user.getEmail());
        System.out.println("role : "+user.getRole());
        System.out.println("createDate : "+user.getCreateDate());

        userRepository.save(user);

        return "회원가입이 완료되었습니다.";
    }
}
