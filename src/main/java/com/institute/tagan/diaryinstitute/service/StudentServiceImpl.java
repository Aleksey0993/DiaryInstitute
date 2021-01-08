package com.institute.tagan.diaryinstitute.service;

import com.institute.tagan.diaryinstitute.model.Group;
import com.institute.tagan.diaryinstitute.model.Student;
import com.institute.tagan.diaryinstitute.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Optional<Student> getStudent(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void deleteStudent(Long id) {
      studentRepository.deleteById(id);
    }

    @Override
    public List getAllStudents() {
        return studentRepository.findAll(Sort.by("id"));
    }

    @Override
    public List getStudentsByGroup(Group group) {
        return studentRepository.getAllStudentByGroup(group);
    }

    @Override
    public void editStudent(Student student) {
       studentRepository.save(student);
    }
}
