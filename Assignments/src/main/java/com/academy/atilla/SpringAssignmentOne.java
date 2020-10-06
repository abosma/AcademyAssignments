package com.academy.atilla;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringAssignmentOne {

    @RequestMapping
    public String helloWorld() {
        return("Hello World");
    }
}
