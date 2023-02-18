package com.example.blog.test;

import com.example.blog.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private List<Employee> theEmployees;

    @PostConstruct
    private void loadData(){
        Employee emp1 = new Employee(1, "LesLIE", "Andrews", "leslie@naver.com");
        Employee emp2 = new Employee(2, "jongyoung", "LIM", "lim3873@naver.com");
        Employee emp3 = new Employee(3, "youngwoo", "Yoon", "wooyoung@naver.com");

        theEmployees = new ArrayList<>();

        theEmployees.add(emp1);
        theEmployees.add(emp2);
        theEmployees.add(emp3);

    }

    @GetMapping("/list")
    public String listEmployees(Model theModel){
        theModel.addAttribute("employees", theEmployees);

        return "list-employees";
    }
}
