package org.piotr.eventmanager.controller;

import org.piotr.eventmanager.form.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping
    public ModelAndView loginPage(){
        ModelAndView mnv = new ModelAndView("login");
        mnv.addObject("form", new LoginForm());
        return mnv;
    }
}