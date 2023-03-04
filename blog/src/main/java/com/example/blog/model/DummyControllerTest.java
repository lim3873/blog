package com.example.blog.model;

import com.example.blog.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.Supplier;

//html 파일이 아니라 data를 리턴해주는 controller = RestController
@RestController
public class DummyControllerTest {

    @Autowired
    private UserRepository userRepository;

    //http://localhost:8000/blog/dummy/user
    @GetMapping("/dummy/users")
    public List<User> list() {
        return userRepository.findAll();
    }

    @GetMapping("/dummy/user")
    public List<User> pageList(@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<User> pagingUser = userRepository.findAll(pageable);

        List<User> users = pagingUser.getContent();

        return users;
    }

    @GetMapping("/dummy/user/{id}")  //{id} 주소를 파라미터로 전달받을수 있음
    public User detail(@PathVariable int id) {
        // user/{id}를 검색할시 DB 에서 값이 없을때 user가 null인 것을 가정
        // return null 호출시 프로그램에서 Exceptional Error 발생(예외처리 해)_
        // Optional로 User 객체를 감싸서 가져올테니 null이 아닌지 판단해서 return

//        람다식
//        User user = userRepository.findById(id).orElseThrow(() -> {
//        return new IllegalArgumentException("해당 유저는 없습니다 id:"+id);

        User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
            @Override
            public IllegalArgumentException get() {
                return new IllegalArgumentException("해당 유저는 없습니다 id:" + id);
            }
        });
        //요청 : 웹브라우저
        //User 객체 = 자바 오브젝트
        //변환 (웹브라우저가 이해할수 있는 데이터 -> json (Gson 라이브라러리))
        //스프링부트 = MessageConverter라는 애가 응답시에 자동 작동
        //만약에 자바 오브젝트를 리턴하게 되면 MessegaConverter가 Jackson 라이브러리를 호출해서
        //user 오브젝트를 json으로 변환해서 브라우저에게 던져줍니다.
        return user;
    }

    @PostMapping("/dummy/join")
    public String join(User user) {
        System.out.println("id : " + user.getId());
        System.out.println("username : " + user.getUsername());
        System.out.println("password : " + user.getPassword());
        System.out.println("email : " + user.getEmail());
        System.out.println("role : " + user.getRole());
        System.out.println("createDate : " + user.getCreateDate());

        user.setRole(RoleType.USER);
        userRepository.save(user);

        return "회원가입이 완료되었습니다.";
    }
}
