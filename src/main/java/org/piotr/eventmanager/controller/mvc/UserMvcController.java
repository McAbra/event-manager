package org.piotr.eventmanager.controller.mvc;

import lombok.AllArgsConstructor;
import org.piotr.eventmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserMvcController {

    @Autowired
    private UserService userService;

//    @GetMapping("/details/{name}")
//    public ModelAndView getUserDetails(@PathVariable String name) {
//
//    }


}
