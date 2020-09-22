package com.academy.atilla;

import com.academy.atilla.dto.WorkExperience;
import com.academy.atilla.repository.WorkExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;

@RestController
public class SpringAssignmentFive {

    @Autowired
    private WorkExperienceRepository workExperienceRepository;

    @GetMapping("/work-experiences")
    public List<WorkExperience> getWorkExperiences() {
        return workExperienceRepository.findAll();
    }

    @GetMapping("/work-experiences/add-test")
    public String testCreate() {
        WorkExperience workExperience = new WorkExperience();
        workExperience.setName("Jantje Beton");

        workExperienceRepository.save(workExperience);

        return "Created a workexperience object";
    }

    @PostMapping("/work-experience")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody WorkExperience workExperience) {
        workExperienceRepository.save(workExperience);
    }
}
