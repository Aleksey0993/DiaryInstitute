package com.institute.tagan.diaryinstitute.controller;

import com.institute.tagan.diaryinstitute.model.*;
import com.institute.tagan.diaryinstitute.repository.StudentRepository;
import com.institute.tagan.diaryinstitute.service.ConstructorService;
import com.institute.tagan.diaryinstitute.service.GroupService;
import com.institute.tagan.diaryinstitute.service.JournalService;
import com.institute.tagan.diaryinstitute.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
   @Autowired
    private ConstructorService constructorService;
   @Autowired
   private GroupService groupService;
   @Autowired
   private StudentService studentService;
  @Autowired
  private JournalService journalService;

    @GetMapping()
    public String teacher(Model model, @AuthenticationPrincipal User activeUser){
        model.addAttribute("currentTeacher",activeUser);

        model.addAttribute("constructors", constructorService.getAllConstructor(activeUser));
        return "teacher";
    }


    @GetMapping("/new")
    public String newJournal(@ModelAttribute("constructor") Constructor constructor,
                             Model model, @AuthenticationPrincipal User activeUser){
        model.addAttribute("currentTeacher", activeUser);
        return "newConstructor";
    }

    @PostMapping()
    public String createJournal(@ModelAttribute("constructor") Constructor constructor){

        constructorService.createConstructor(constructor);
        return "redirect:/teacher";
    }

    @GetMapping("/{id}/journal")
    public String editDepartment(@PathVariable("id") Long id, Model model,
                                 @AuthenticationPrincipal User activeUser){
      Constructor constructor = constructorService.getConstructor(id);

      List<Journal> journals = journalService.getJournalBySubject(constructor.getSubject(),activeUser);
       if(journals.isEmpty()){
           model.addAttribute("constructor", constructor);

           model.addAttribute("progress",null);
           return "table_journal";
       }
        List<Progress> progress = new ArrayList<Progress>();


      for(Journal journal : journals){
          System.out.println("Номер зачетной книги");
          System.out.println(journal.getRbook());
          Group group = studentService.getGroup(journal.getRbook());
          System.out.println(group);

          progress.add(new Progress(journal.getId(),journal.getRbook(),group.getNameSh(),
                               parseFullName(studentService.getFullName(journal.getRbook())),
                                 journal.getLab(),journal.getTest(),journal.getCourseWork()));



        }
        model.addAttribute("constructor", constructor);
        model.addAttribute("journals",journals);
        model.addAttribute("progress",progress);
   /*   Constructor constructor = constructorService.getConstructor(id);
      if(constructor.getLab()!=0) {
          model.addAttribute("labs", constructor.getLab());
      }
     if(constructor.getTest()!=0){
         model.addAttribute("tests",constructor.getTest());
     }

      model.addAttribute("journals",journalService.getAllJournal(activeUser));*/

        return "table_journal";
    }


    @PostMapping("{id}/journal/add")
    public String addGroup(@PathVariable("id") Long id,
                           @RequestParam("numGroup") String numGroup,
                           @AuthenticationPrincipal User activeUser){
        Constructor constructor = constructorService.getConstructor(id);
        Group group = groupService.getGroupByName(numGroup);
        List<Student> students = (List)studentService.getStudentsByGroup(group);
       for(Student student:students) {

    journalService.createJournal(new Journal(constructor.getSubject(),constructor.getLab(),
                                             constructor.getTest(),constructor.getCourseWork(),
                                             student.getRbook(),activeUser));

       }

        return "redirect:/teacher/"+id+"/journal";
    }


    @PostMapping("{id}/journal/delete")
    public String deleteGroup(@PathVariable("id") Long id,
                           @RequestParam("numGroup") String numGroup,
                           @AuthenticationPrincipal User activeUser){
        Constructor constructor = constructorService.getConstructor(id);

        Group group = groupService.getGroupByName(numGroup);
        List<Student> students = studentService.getStudentsByGroup(group);
        for(Student student :students){

            journalService.deleteJournalByGroup(student.getRbook(),
                                                constructor.getPrimaryUser(),
                                                constructor.getSubject());

        }


        return "redirect:/teacher/"+id+"/journal";
    }






    @DeleteMapping("/{id}")
    public String deleteJournal(@PathVariable("id") Long id) {
        Constructor constructor = constructorService.getConstructor(id);

        journalService.deleteJournalByUserBySubject(constructor.getPrimaryUser(),
                                                    constructor.getSubject());

        constructorService.deleteConstructor(id);
        return "redirect:/teacher";
    }

    private String parseFullName(String str){
        char[] newstr = str.toCharArray();
        for(int i=0;i<newstr.length;i++){
           if(newstr[i]==',')
               newstr[i]=' ';
        }
        return new String(newstr);
    }
}
