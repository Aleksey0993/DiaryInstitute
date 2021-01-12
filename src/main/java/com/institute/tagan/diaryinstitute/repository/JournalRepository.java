package com.institute.tagan.diaryinstitute.repository;

import com.institute.tagan.diaryinstitute.model.Journal;
import com.institute.tagan.diaryinstitute.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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

    @Transactional
 @Query("select j from Journal j where j.rbook=?1")
 List getAllJournalBynumRBook(String numRBook);

 @Modifying(clearAutomatically = true, flushAutomatically=true )
 @Transactional
 @Query("update Journal j set j.lab = ?1, j.test= ?2, j.courseWork= ?3 where j.id= ?4")
 public void setJournalById(Integer[] lab, Integer[] test, Integer[] courseWork, Long id);


 @Modifying(clearAutomatically = true, flushAutomatically=true )
 @Transactional
 @Query("delete from Journal j where j.primaryUser=?1 and j.subject=?2")
 public void deleteJournalByIdUserBySubject(User user, String subject);

 @Modifying(clearAutomatically = true, flushAutomatically=true )
 @Transactional
 @Query("delete from Journal j where j.rbook=?1 and j.primaryUser=?2 and j.subject=?3")
 public void deleteJournalByGroup(String RBook,User user,String subject);




}
