package com.crushoncode.web.authentication.controller;

import org.keycloak.KeycloakSecurityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Controller
public class TaskController {
    private final HttpServletRequest request;

    @Autowired
    public TaskController(HttpServletRequest request) {
        this.request = request;
    }

    @GetMapping(value = "/tasks")
    public String getTasks(Model model) {

        List tasks = Arrays.asList("TASK_1","TASK_2", "TASK_3");
        model.addAttribute("tasks", tasks);
        model.addAttribute("name", getKeycloakSecurityContext().getIdToken().getGivenName());
        return "tasks";
    }

    private KeycloakSecurityContext getKeycloakSecurityContext() {
        return (KeycloakSecurityContext) request.getAttribute(KeycloakSecurityContext.class.getName());

    }

}
