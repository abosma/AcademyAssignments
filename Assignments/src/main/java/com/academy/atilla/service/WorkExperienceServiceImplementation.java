package com.academy.atilla.service;

import com.academy.atilla.dto.WorkExperience;
import com.academy.atilla.repository.WorkExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkExperienceServiceImplementation implements WorkExperienceService {
    private final WorkExperienceRepository workExperienceRepository;

    @Autowired
    public WorkExperienceServiceImplementation(WorkExperienceRepository workExperienceRepository) {
        this.workExperienceRepository = workExperienceRepository;
    }

    @Override
    public WorkExperience find(long id) {
        return workExperienceRepository.getOne(id);
    }

    @Override
    public List<WorkExperience> findAll() {
        return workExperienceRepository.findAll();
    }

    @Override
    public void delete(WorkExperience workExperience) {
        workExperienceRepository.delete(workExperience);
    }

    @Override
    public void save(WorkExperience workExperience) {
        workExperienceRepository.save(workExperience);
    }
}
