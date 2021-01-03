package com.institute.tagan.diaryinstitute.repository;

import com.institute.tagan.diaryinstitute.model.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality,Long> {
}
