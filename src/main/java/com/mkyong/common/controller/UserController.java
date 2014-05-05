package com.mkyong.common.controller;

import com.mkyong.common.model.User;
import com.mkyong.common.validator.UserValidator;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.util.WebUtils;

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

        return "multipageForms/Page1Form";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processPage(HttpServletRequest request,
            @RequestParam("_page") final int currentPage,
            final @ModelAttribute("user") User user,
            BindingResult result,
            final HttpServletResponse response, Model model) {


        Map pageForms = new HashMap();
        pageForms.put(0, "multipageForms/Page1Form");
        pageForms.put(1, "multipageForms/Page2Form");
        pageForms.put(2, "multipageForms/Page3Form");

        if (request.getParameter("_cancel") != null) {
            // Return to current page view, since user clicked cancel 
            return (String) pageForms.get(0);

        } else if (request.getParameter("_finish") != null) {
            new UserValidator().validate(user, result);

            if (result.hasErrors()) {
                return (String) pageForms.get(currentPage);
            } else {
                model.addAttribute("user1", user);
                return "multipageForms/ResultForm";
            }
        } else {
            // User clicked Next or Previous(_target) 

            // Extract target page 
            int targetPage = WebUtils.getTargetPage(request, "_target", currentPage);
            // If targetPage is lesser than current page, user clicked 'Previous' 
            if (targetPage < currentPage) {
                return (String) pageForms.get(targetPage);
            }

            switch (currentPage) {
                case 0:
                    new UserValidator().
                            validatePage1Form(user, result);
                    break;
                case 1:
                    new UserValidator().
                            validatePage2Form(user, result);
                    break;
                case 2:
                    new UserValidator().
                            validatePage3Form(user, result);
                    break;
            }
            if (!result.hasErrors()) {
                // No errors, return target page 
                return (String) pageForms.get(targetPage);
            } else {
                // Errors, return current page 
                return (String) pageForms.get(currentPage);
            }


//            // User clicked 'Next', return target page 
//            return (String) pageForms.get(targetPage);
        }
    }
}
