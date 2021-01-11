package com.institute.tagan.diaryinstitute.controller;

import com.institute.tagan.diaryinstitute.model.Journal;
import com.institute.tagan.diaryinstitute.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AcademicPerfomanceController {
    @Autowired
    private JournalService journalService;
    @GetMapping("/progress")
    public String progress(){

        return "progress";
    }
    @GetMapping("/progress/result")
    public String result(@RequestParam("numRBook")String numRBook, Model model){
        List<Journal> journals = journalService.getAllJournalByRBook(numRBook);
        model.addAttribute("journals",journals);


        return "progress";
    }

}
