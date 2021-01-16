package com.institute.tagan.diaryinstitute.repository;

import com.institute.tagan.diaryinstitute.model.Department;
import com.institute.tagan.diaryinstitute.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    /*@Modifying(clearAutomatically = true, flushAutomatically=true )
    @Transactional
    @Query("update Department d set d.nameSh = ?1, d.nameL= ?2 where d.id= ?3")
    public void setDepartmentById( String nameSh, String nameL, Long id);
*/


    @Modifying(clearAutomatically = true, flushAutomatically=true )
    @Transactional
    @Query("update Department d set d.nameSh = ?1, d.nameL= ?2, d.primaryFaculty= ?3 where d.id= ?4")
    public void setDepartmentById(String nameSh, String nameL, Faculty faculty, Long id);


}
