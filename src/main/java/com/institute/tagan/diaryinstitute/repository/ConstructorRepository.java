package com.institute.tagan.diaryinstitute.repository;

import com.institute.tagan.diaryinstitute.model.Constructor;
import com.institute.tagan.diaryinstitute.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ConstructorRepository extends JpaRepository<Constructor,Long> {
    @Transactional
    @Query("select c from Constructor c where c.primaryUser=?1")
   List getAllConstructorByUser(User user);



}
