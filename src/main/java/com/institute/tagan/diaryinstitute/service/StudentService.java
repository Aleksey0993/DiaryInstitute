package com.institute.tagan.diaryinstitute.service;

import com.institute.tagan.diaryinstitute.model.Group;
import com.institute.tagan.diaryinstitute.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    void createStudent(Student student);
    Optional<Student> getStudent(Long id);
    void deleteStudent(Long id);
    List getAllStudents();
    void editStudent(Student student);
}
