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

    @Override
    public List getJournalBySubject(String nameSubject, long us) {
        return journalRepository.getAllJournalBySubject(nameSubject,us);
    }

    @Override
    public void updateResultStudentById(Integer[] lab, Integer[] test, Integer[] coursework, Long id) {
        journalRepository.setJournalById(lab,test,coursework,id);
    }

    @Override
    public List getAllJournalByRBook(String numRBook) {
        return journalRepository.getAllJournalBynumRBook(numRBook);
    }

    @Override
    public void deleteJournalByUserBySubject(User user, String subject) {
        journalRepository.deleteJournalByIdUserBySubject(user,subject);
    }

    @Override
    public void deleteJournalByGroup(String RBook, User user,String subject) {
        journalRepository.deleteJournalByGroup(RBook,user,subject);
    }

}

