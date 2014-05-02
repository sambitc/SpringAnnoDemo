package com.mkyong.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

@Controller
@RequestMapping("/welcome.htm")
public class WelcomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String initForm(ModelMap model) {
        
        System.out.println("-------------hai");
        return ("multipageForms/WelcomePage");
    }
}