package com.institute.tagan.diaryinstitute.service;


import com.institute.tagan.diaryinstitute.model.Faculty;
import com.institute.tagan.diaryinstitute.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyServiceImpl implements FacultyService{
    @Autowired
    private FacultyRepository facultyRepository;
    @Override
    public void createFaculty(Faculty faculty) {
        facultyRepository.save(faculty);

    }

    @Override
    public Optional<Faculty> getFaculty(Long id) {
        return facultyRepository.findById(id);
    }

    @Override
    public void editFaculty(Faculty faculty, Long id) {
        facultyRepository.setFacultyById(faculty.getNameSh(), faculty.getNameL(),id);


    }

    @Override
    public void deleteFaculty(Faculty faculty) {
        facultyRepository.delete(faculty);
    }

    @Override
    public void deleteFaculty(Long id) {
        facultyRepository.deleteById(id);
    }

    @Override
    public List<Faculty> getAllFaculties() {
        return (List<Faculty>) facultyRepository.findAll(Sort.by("id"));
    }

    @Override
    public long countFaculty() {
        return facultyRepository.count();
    }
}
