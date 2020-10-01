package com.academy.atilla;

import com.academy.atilla.dto.WorkExperience;
import com.academy.atilla.repository.WorkExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SpringAssignmentFive {
    private WorkExperienceRepository workExperienceRepository;

    @Autowired
    public SpringAssignmentFive(WorkExperienceRepository workExperienceRepository) {
        this.workExperienceRepository = workExperienceRepository;
    }

    @GetMapping("/work-experiences")
    public List<WorkExperience> getWorkExperiences() {
        List<WorkExperience> workExperiences = workExperienceRepository.findAll();
        return workExperiences;
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
    public void createFromJson(@RequestBody WorkExperience workExperience) {
        workExperienceRepository.save(workExperience);
    }

    @PostMapping(value = "/work-experience", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public void createFromForm(WorkExperience workExperience) {
        workExperienceRepository.save(workExperience);
    }
}
