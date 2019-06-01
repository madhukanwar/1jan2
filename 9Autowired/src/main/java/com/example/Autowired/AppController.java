package com.example.Autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @Autowired
    public AppService appService;

    @RequestMapping("/")
    public void index(){
        appService.myService();
    }


}
