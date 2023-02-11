package com.example.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TempControllerTest {

    @GetMapping("/temp/home")
    public String tempHome(){
        System.out.println("temphome()");
        return "/home.html";
    }

    @GetMapping("/temp/img")
    public String tempimg(){
        return "/image.html";
    }
}
