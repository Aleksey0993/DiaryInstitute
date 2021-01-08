package com.institute.tagan.diaryinstitute.repository;

import com.institute.tagan.diaryinstitute.model.Group;
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
}
