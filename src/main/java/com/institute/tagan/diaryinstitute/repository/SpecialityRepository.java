package com.institute.tagan.diaryinstitute.repository;

import com.institute.tagan.diaryinstitute.model.Department;
import com.institute.tagan.diaryinstitute.model.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality,Long> {
    @Modifying(clearAutomatically = true, flushAutomatically=true )
    @Transactional
    @Query("update Speciality s set s.nameSh = ?1, s.nameL= ?2, s.primaryDepartment= ?3 where s.id= ?4")
    public void setSpecialityById(String nameSh, String nameL, Department department, Long id);
}
