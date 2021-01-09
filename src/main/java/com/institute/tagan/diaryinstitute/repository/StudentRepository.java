package com.institute.tagan.diaryinstitute.repository;

import com.institute.tagan.diaryinstitute.model.Group;
import com.institute.tagan.diaryinstitute.model.Student;
import com.institute.tagan.diaryinstitute.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    @Transactional
    @Query("select st from Student st where st.primaryGroup=?1")
    List getAllStudentByGroup(Group group);

    @Transactional
    @Query("select st.primaryGroup from Student st where st.rbook=?1")
    Group getGroupByRBook(String rbook);

    @Transactional
    @Query("select st.surname, st.name, st.patronymic from Student st where st.rbook=?1")
    String getFullNameByRBook(String rbook);
}
