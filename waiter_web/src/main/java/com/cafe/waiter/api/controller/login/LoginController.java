package com.cafe.waiter.api.controller.login;

import com.cafe.waiter.api.model.login.LoginModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 5:42 PM
 */

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public ModelAndView getAdminLoginView() {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("loginModel", new LoginModel());
        return modelAndView;
    }
}
