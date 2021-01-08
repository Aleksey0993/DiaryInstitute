package com.institute.tagan.diaryinstitute.service;

import com.institute.tagan.diaryinstitute.model.Constructor;
import com.institute.tagan.diaryinstitute.model.User;

import java.util.List;

public interface ConstructorService {
    void createConstructor(Constructor constructor);
    Constructor getConstructor(Long id);
     void deleteConstructor(Long id);
    List getAllConstructor(User user);

  //  List getAllByUser(User user);
}
