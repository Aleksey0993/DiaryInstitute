package com.institute.tagan.diaryinstitute.repository;

import com.institute.tagan.diaryinstitute.model.Group;
import com.institute.tagan.diaryinstitute.model.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface GroupRepository extends JpaRepository<Group,Long> {

    @Transactional
    @Query("select nameFile from Group g where g.nameSh= ?1")
    public String findFileName(String nameSh);
    @Transactional
    @Query("select g from Group g where g.nameSh= ?1")
    public Group getOneGroup(String nameGroup);

    @Modifying(clearAutomatically = true, flushAutomatically=true )
    @Transactional
    @Query("update Group g set g.nameSh = ?1, g.primarySpeciality = ?2 where g.id= ?3")
    public void setGroupById(String nameSh, Speciality speciality, Long id);

    @Modifying(clearAutomatically = true, flushAutomatically=true )
    @Transactional
    @Query("update Group g set g.nameFile = ?1 where g.id= ?2")
    public void setGroupFileById( String nameFile,  Long id);

}
