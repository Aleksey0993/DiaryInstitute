package com.institute.tagan.diaryinstitute.service;

import com.institute.tagan.diaryinstitute.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List getAllRoles() {
        return roleRepository.findAll();
    }
}
