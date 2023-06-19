package study.study.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HellowController {

    @GetMapping("hellow")
    public String hello(Model model){
        model.addAttribute("data", "hellow");
        return "hellow";
    }
}
