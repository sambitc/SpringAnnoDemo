package com.mkyong.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;
import com.mkyong.common.model.User;
import com.mkyong.common.validator.UserValidator;
import com.mkyong.customer.model.Customer;
import com.mkyong.customer.validator.CustomerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/user.htm")
@SessionAttributes("user")
public class UserController {
    
    UserValidator userValidator;

    @Autowired
    public UserController(UserValidator userValidator) {
        this.userValidator = userValidator;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String initialForm(ModelMap model) {
        //command object
        model.addAttribute("user", new User());

        return "multipageForms/page1Form";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String processSubmit(
            @ModelAttribute("user") User user,
            BindingResult result, SessionStatus status) {
        return "multipageForms/page1Form";

    }
    
    
    
    
    
    
    
    
//    public UserController() {
//        setCommandName("userForm");
//    }
//
//    @Override
//    protected Object formBackingObject(HttpServletRequest request)
//            throws Exception {
//
//        return new User();
//    }
//
//    @Override
//    protected ModelAndView processFinish(HttpServletRequest request,
//            HttpServletResponse response, Object command, BindException errors)
//            throws Exception {
//
//        //Get the data from command object
//        User user = (User) command;
//        System.out.println(user);
//
//        //where is the finish page?
//        return new ModelAndView("multipageForms/ResultForm", "user1", user);
//    }
//
//    @Override
//    protected ModelAndView processCancel(HttpServletRequest request,
//            HttpServletResponse response, Object command, BindException errors)
//            throws Exception {
//
//        //where is the cancel page?
//        return new ModelAndView("multipageForms/WelcomePage");
//    }
//
//    @Override
//    protected void validatePage(Object command, Errors errors, int page) {
//
//        UserValidator validator = (UserValidator) getValidator();
//
//        //page is 0-indexed
//        switch (page) {
//            case 0: //if page 1 , go validate with validatePage1Form
//                validator.validatePage1Form(command, errors);
//                break;
//            case 1: //if page 2 , go validate with validatePage2Form
//                validator.validatePage2Form(command, errors);
//                break;
//            case 2: //if page 3 , go validate with validatePage3Form
//                validator.validatePage3Form(command, errors);
//                break;
//        }
//    }
}