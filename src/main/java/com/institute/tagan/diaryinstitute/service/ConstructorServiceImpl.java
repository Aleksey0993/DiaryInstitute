package com.institute.tagan.diaryinstitute.service;

import com.institute.tagan.diaryinstitute.model.Constructor;
import com.institute.tagan.diaryinstitute.model.User;
import com.institute.tagan.diaryinstitute.repository.ConstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConstructorServiceImpl implements ConstructorService {
   @Autowired
   private ConstructorRepository constructorRepository;
    @Override
    public void createConstructor(Constructor constructor) {
        constructorRepository.save(constructor);
    }

    @Override
    public Constructor getConstructor(Long id) {
        Optional<Constructor> constr = constructorRepository.findById(id);
        return constr.orElse(new Constructor());
    }

    @Override
    public void deleteConstructor(Long id) {
        constructorRepository.deleteById(id);
    }

    @Override
    public List getAllConstructor(User user) {

        return  constructorRepository.getAllConstructorByUser(user);
    }

  //  @Override
  //  public List getAllByUser(User user){
  //      return constructorRepository.getAllConstructorByUser(user);
  //  }


}
