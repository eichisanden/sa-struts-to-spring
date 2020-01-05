package com.example.controller;

import com.example.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @RequestMapping(path = "/hello.s", method = RequestMethod.GET)
    public String hoge() {
        return testService.hello();
    }
}
