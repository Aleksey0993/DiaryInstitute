package com.institute.tagan.diaryinstitute.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
 @GetMapping("/test")
    public String testpage(){
     return "test";
 }
}
