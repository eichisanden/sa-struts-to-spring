package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping(path = "/hello.s", method = RequestMethod.GET)
    public String hoge() {
        return "Hello World";
    }
}
