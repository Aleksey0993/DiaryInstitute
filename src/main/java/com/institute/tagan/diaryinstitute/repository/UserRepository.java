package com.institute.tagan.diaryinstitute.repository;

import com.institute.tagan.diaryinstitute.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    @Modifying(clearAutomatically = true, flushAutomatically=true )
    @Transactional
    @Query("update User u set u.password = ?1 where u.id= ?2")
    public void editPassword(String password, Long id);
}

