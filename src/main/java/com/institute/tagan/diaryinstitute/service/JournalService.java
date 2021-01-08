package com.institute.tagan.diaryinstitute.service;

import com.institute.tagan.diaryinstitute.model.Constructor;
import com.institute.tagan.diaryinstitute.model.Journal;
import com.institute.tagan.diaryinstitute.model.User;

import java.util.List;


public interface JournalService {
    void createJournal(Journal journal);
    Journal getJournal(Long id);
    void deleteJournal(Long id);
   List getAllJournal(User user);
}

