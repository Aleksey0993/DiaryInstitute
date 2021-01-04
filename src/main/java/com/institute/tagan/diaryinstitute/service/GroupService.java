package com.institute.tagan.diaryinstitute.service;

import com.institute.tagan.diaryinstitute.model.Faculty;
import com.institute.tagan.diaryinstitute.model.Group;
import com.institute.tagan.diaryinstitute.model.Speciality;

import java.util.List;
import java.util.Optional;

public interface GroupService {
    void createGroup(Group group);
    Optional<Group> getGroup(Long id);
   void deleteGroup(Long id);
    List getAllGroups();
    void editGroup(Group group);
}
