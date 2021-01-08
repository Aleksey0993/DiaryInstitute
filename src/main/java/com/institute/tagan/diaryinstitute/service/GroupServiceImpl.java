package com.institute.tagan.diaryinstitute.service;

import com.institute.tagan.diaryinstitute.model.Group;
import com.institute.tagan.diaryinstitute.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class GroupServiceImpl implements GroupService{

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public void createGroup(Group group) {
        groupRepository.save(group);
    }

    @Override
    public Optional<Group> getGroup(Long id) {
        return groupRepository.findById(id);
    }

    @Override
    public void deleteGroup(Long id) {
       groupRepository.deleteById(id);
    }

    @Override
    public List getAllGroups() {
        return groupRepository.findAll(Sort.by("id"));

    }

    @Override
    public void editGroup(Group group) {
         groupRepository.save(group);
    }

    @Override
    public String findFile(String name) {
        return groupRepository.findFileName(name);
    }

    @Override
    public Group getGroupByName(String nameGroup) {
        return groupRepository.getOneGroup(nameGroup);
    }
}
