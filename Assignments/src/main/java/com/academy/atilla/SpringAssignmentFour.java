package com.academy.atilla;

import com.academy.atilla.dto.PersonalInformation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringAssignmentFour {

    @GetMapping("/personalInfo")
    public PersonalInformation getPersonalInfo()
    {
        return new PersonalInformation(1, "Atilla", 24);
    }
}
