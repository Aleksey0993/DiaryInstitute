package com.institute.tagan.diaryinstitute.service;

import com.institute.tagan.diaryinstitute.model.Speciality;
import com.institute.tagan.diaryinstitute.repository.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SpecialityServiceImpl implements SpecialityService{
    @Autowired
    private SpecialityRepository specialityRepository;

    @Override
    public void createSpeciality(Speciality speciality) {
      specialityRepository.save(speciality);
    }

    @Override
    public Optional<Speciality> getSpeciality(Long id) {
        return specialityRepository.findById(id);
    }

    @Override
    public void deleteSpeciality(Long id) {
        specialityRepository.deleteById(id);
    }

    @Override
    public List getAllSpecialities() {
        return specialityRepository.findAll(Sort.by("id"));
    }

    @Override
    public void editSpeciality(Speciality speciality) {
       specialityRepository.save(speciality);
    }
}
