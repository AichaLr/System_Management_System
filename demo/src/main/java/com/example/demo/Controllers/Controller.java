package com.example.demo.Controllers;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping("api/test")
public class Controller {


    @GetMapping("/text")
    String hello(){
        return "hello world";
    }

}
