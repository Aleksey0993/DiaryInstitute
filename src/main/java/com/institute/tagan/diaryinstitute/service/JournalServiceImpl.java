package com.institute.tagan.diaryinstitute.service;

import com.institute.tagan.diaryinstitute.model.Constructor;
import com.institute.tagan.diaryinstitute.model.Journal;
import com.institute.tagan.diaryinstitute.model.User;
import com.institute.tagan.diaryinstitute.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class JournalServiceImpl implements JournalService{
    @Autowired
    private JournalRepository journalRepository;
    @Override
    public void createJournal(Journal journal) {
        journalRepository.save(journal);
    }

    @Override
    public Journal getJournal(Long id) {
        Optional<Journal> journal = journalRepository.findById(id);
        return journal.orElse(new Journal());
    }

    @Override
    public void deleteJournal(Long id) {
       journalRepository.deleteById(id);
    }


 @Override
    public List getAllJournal(User user) {
        return journalRepository.getAllJournalByUser(user);
    }

}

