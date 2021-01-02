package com.institute.tagan.diaryinstitute.service;


import com.institute.tagan.diaryinstitute.model.Department;
import com.institute.tagan.diaryinstitute.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    public void createDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public Optional<Department> getDepartment(Long id) {
        return departmentRepository.findById(id);
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public List getAllDepartments() {
        return departmentRepository.findAll(Sort.by("id"));
    }

    @Override
    public void editDepartment(Department department) {
        departmentRepository.save(department);
    }
}
