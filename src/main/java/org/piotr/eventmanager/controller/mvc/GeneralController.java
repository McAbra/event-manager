package org.piotr.eventmanager.controller.mvc;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeneralController {

    @GetMapping("/admin")
    public String adminPage() {
        return "adminpage";
    }
}
