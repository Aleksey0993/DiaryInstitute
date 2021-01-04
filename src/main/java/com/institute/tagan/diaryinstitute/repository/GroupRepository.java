package com.institute.tagan.diaryinstitute.repository;

import com.institute.tagan.diaryinstitute.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group,Long> {
}
