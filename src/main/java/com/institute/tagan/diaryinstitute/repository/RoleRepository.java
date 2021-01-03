package com.institute.tagan.diaryinstitute.repository;


import com.institute.tagan.diaryinstitute.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}

