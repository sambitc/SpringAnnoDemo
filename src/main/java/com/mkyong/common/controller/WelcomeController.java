package com.mkyong.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/welcome.htm")
public class WelcomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String initForm(ModelMap model) {
        return ("multipageForms/WelcomePage");
    }
}