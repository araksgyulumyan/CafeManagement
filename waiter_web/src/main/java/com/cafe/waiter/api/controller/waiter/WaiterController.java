package com.cafe.waiter.api.controller.waiter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;

/**
 * Created by araksgyulumyan
 * Date - 7/23/18
 * Time - 5:42 PM
 */

@Controller
@RolesAllowed("ROLE_WAITER")
@RequestMapping(value = "/waiter")
public class WaiterController {

    @GetMapping("/dashboard")
    public ModelAndView dashboard() {
        return new ModelAndView("dashboard");
    }
}
