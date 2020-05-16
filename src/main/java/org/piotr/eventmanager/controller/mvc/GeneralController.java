package org.piotr.eventmanager.controller.mvc;


import org.piotr.eventmanager.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GeneralController {

    @Autowired
    EventService eventService;

    @GetMapping("/admin")
    public String adminPage() {
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
        return "adminpage";
    }

    @GetMapping("/waitinglist/{uuid}")
    public ModelAndView getWaitingList(@PathVariable String uuid) {
        ModelAndView mnv = new ModelAndView("waitinglist");
        mnv.addObject("waitingList", eventService.findEventByUuid(uuid).getWaitingList());
        return mnv;
    }

}
