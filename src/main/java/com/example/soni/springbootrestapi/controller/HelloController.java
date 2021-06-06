package com.example.soni.springbootrestapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {

    @GetMapping
    @ResponseBody
    public ResponseEntity<String> hello(){
        ResponseEntity<String> responseEntity = new ResponseEntity<String>("I am sleeping", HttpStatus.BAD_GATEWAY);
        return responseEntity;
    }
}
