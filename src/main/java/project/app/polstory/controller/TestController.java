package project.app.polstory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

    @GetMapping({"","/"})
    public String home(ModelAndView mv){
        return "home";
    }

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return "OK";
    }

    @GetMapping("/adminOnly")
    @ResponseBody
    public String adminOnly(){
        return "Secret Page";
    }

}
