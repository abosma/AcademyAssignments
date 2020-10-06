package com.academy.atilla.service;

import com.academy.atilla.dto.WorkExperience;

import java.util.List;

public interface WorkExperienceService {
    WorkExperience find(long id);

    List<WorkExperience> findAll();

    void delete(WorkExperience workExperience);

    void save(WorkExperience workExperience);
}
