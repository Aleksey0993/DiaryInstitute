package com.institute.tagan.diaryinstitute.service;
import com.institute.tagan.diaryinstitute.model.Department;
import com.institute.tagan.diaryinstitute.model.Speciality;

import java.util.List;
import java.util.Optional;

public interface SpecialityService {
    void createSpeciality(Speciality speciality);
    Optional<Speciality> getSpeciality(Long id);
    // void editFaculty(Faculty faculty, Long id);
    //  void deleteDepartment(Department );
    void deleteSpeciality(Long id);
    List getAllSpecialities();
    // long countFaculty();
    public void editSpecialityByID(Speciality speciality, Long id);
}