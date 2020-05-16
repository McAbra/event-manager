package org.piotr.eventmanager.controller.mvc;


import org.piotr.eventmanager.exception.UserExistsException;
import org.piotr.eventmanager.form.UserRegisterForm;
import org.piotr.eventmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class UserRegistrationController {

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public ModelAndView registrationForm() {
        ModelAndView mnv = new ModelAndView("register");
        mnv.addObject("user", new UserRegisterForm());
        return mnv;
    }

    @PostMapping("/registration")
    public ModelAndView registerNewUser(@Valid UserRegisterForm userRegisterForm, BindingResult result) {
        if (result.hasErrors()) {
            ModelAndView mnv = new ModelAndView("register");
            return mnv;
        } else {
            try {
                userService.createUser(userRegisterForm);
            } catch (UserExistsException e) {
                ModelAndView mnv = new ModelAndView("register");
                mnv.addObject("message", e.getMessage());
                return mnv;
            }
            return new ModelAndView("redirect:/login");
        }
    }

}
