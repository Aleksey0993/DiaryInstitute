package com.institute.tagan.diaryinstitute.controller;

import com.institute.tagan.diaryinstitute.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;

@RestController
public class UpdateController {
    @Autowired
    private JournalService journalService;
    @PostMapping("/test")
    public ResponseEntity<?> getSearchResultViaAjax(@RequestBody Result result) {

        int index=0;
        Integer[] lab = new Integer[result.getCountlab()];
        Integer[] test = new Integer[result.getCounttest()];
        Integer[] coursework = new Integer[result.getCountcoursework()];
     System.out.println(lab.length);

     if(lab.length>0){
         for(int i=0;i<lab.length;i++){
             lab[i]=result.getResult()[i];
         }
     }


        if(test.length>0){
            index=0;
            for(int i=lab.length;i<test.length+lab.length;i++){
                test[index]=result.getResult()[i];
                 index++;
            }
        }


        if(coursework.length>0){
            index=0;
            for(int i=lab.length+test.length;i<coursework.length+lab.length+test.length;i++){
                coursework[index]=result.getResult()[i];
            }
        }


     if(lab.length==0){
         lab=null;
     }
     if(test.length==0){
         test=null;
     }
     if(coursework.length==0){
         coursework=null;
     }

     journalService.updateResultStudentById(lab,test,coursework,(long)result.getId());


        return ResponseEntity.ok("");

    }


}
