package com.institute.tagan.diaryinstitute.service;

import com.institute.tagan.diaryinstitute.model.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    void createDepartment(Department department);
    Optional<Department> getDepartment(Long id);
    // void editFaculty(Faculty faculty, Long id);
    //  void deleteDepartment(Department );
    void deleteDepartment(Long id);
    List getAllDepartments();
    // long countFaculty();
    void editDepartment(Department department);
}

