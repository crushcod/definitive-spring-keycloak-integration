package com.crushoncode.web.authentication.controller;

import lombok.extern.slf4j.Slf4j;
import org.keycloak.KeycloakSecurityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/private")
public class MainController {
    private final HttpServletRequest request;

    @Autowired
    public MainController(HttpServletRequest request) {
        this.request = request;
    }

    @GetMapping(value = "/dashboard")
    public String dashboard( Model model) {

        List tasks = Arrays.asList("TASK_1","TASK_2", "TASK_3");
        model.addAttribute("tasks", tasks);
        model.addAttribute("name", getKeycloakSecurityContext().getIdToken().getGivenName());
        return "/dashboard/index";
    }

    @GetMapping(value = "/admin")
    public String admin( Model model) {

        List tasks = Arrays.asList("TASK_1","TASK_2", "TASK_3");
        model.addAttribute("tasks", tasks);
        model.addAttribute("name", getKeycloakSecurityContext().getIdToken().getGivenName());
        return "dashboard";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) throws Exception {
        request.logout();
        return "redirect:/index.html";
    }

    private KeycloakSecurityContext getKeycloakSecurityContext() {
        return (KeycloakSecurityContext) request.getAttribute(KeycloakSecurityContext.class.getName());

    }

}
