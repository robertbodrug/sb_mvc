package com.goit.sb_mvc.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class TestController {
    @RequestMapping("/test")
    public ModelAndView getTest(){
        return new ModelAndView("test");
}
}
