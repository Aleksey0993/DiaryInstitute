package com.institute.tagan.diaryinstitute.repository;

import com.institute.tagan.diaryinstitute.model.Journal;
import com.institute.tagan.diaryinstitute.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface JournalRepository extends JpaRepository<Journal,Long> {
   @Transactional
    @Query("select j from Journal j where j.primaryUser=?1")
    List getAllJournalByUser(User user);

    @Transactional
    @Query("select j from Journal j where j.subject=?1 and j.primaryUser=?2")
    List getAllJournalBySubject(String nameSubject,User user);




}
