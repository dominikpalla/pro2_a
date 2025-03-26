package cz.uhk.pro2_a.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DefaultController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "<h1>Test</h1>";
    }

}
