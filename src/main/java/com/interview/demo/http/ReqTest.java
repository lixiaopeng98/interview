package com.interview.demo.http;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class ReqTest {

    @PostMapping(value = "/test/test")
    public String test(HttpServletRequest request, HttpServletResponse response){
        System.out.println("test");
        return "test";
    }
}
