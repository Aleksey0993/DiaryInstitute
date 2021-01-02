package com.institute.tagan.diaryinstitute.repository;

import com.institute.tagan.diaryinstitute.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty,Long> {
    @Modifying(clearAutomatically = true, flushAutomatically=true )
    @Transactional
    @Query("update Faculty f set f.nameSh = ?1, f.nameL= ?2 where f.id= ?3")
    public void setFacultyById( String nameSh, String nameL, Long id);
}

