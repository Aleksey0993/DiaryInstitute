package com.institute.tagan.diaryinstitute.service;

import com.institute.tagan.diaryinstitute.model.Faculty;

import java.util.List;
import java.util.Optional;

public interface FacultyService {
    void createFaculty(Faculty faculty);
    Optional<Faculty> getFaculty(Long id);
    void editFaculty(Faculty faculty, Long id);
    void deleteFaculty(Faculty faculty);
    void deleteFaculty(Long id);
    List getAllFaculties();
    long countFaculty();
}
