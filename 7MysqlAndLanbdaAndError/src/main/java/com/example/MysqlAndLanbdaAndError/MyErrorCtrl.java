package com.example.MysqlAndLanbdaAndError;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyErrorCtrl implements ErrorController {

    @RequestMapping("/error")
    public String myError(){
        return "errorctrl";
    }


    @Override
    public String getErrorPath() {
        return "/error";
    }
}
