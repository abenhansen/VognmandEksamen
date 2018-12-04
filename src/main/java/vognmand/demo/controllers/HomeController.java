package vognmand.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/login")
    public String login (){
        return "login";
    }

    @GetMapping("/")
    public String hovedSide () {
        return "hovedSide";
    }

    @GetMapping("/403")
    public String error () {
        return "403";
    }

}
