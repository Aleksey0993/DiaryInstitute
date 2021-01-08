package com.institute.tagan.diaryinstitute.controller;

import com.institute.tagan.diaryinstitute.model.*;
import com.institute.tagan.diaryinstitute.repository.StudentRepository;
import com.institute.tagan.diaryinstitute.service.ConstructorService;
import com.institute.tagan.diaryinstitute.service.GroupService;
import com.institute.tagan.diaryinstitute.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
   @Autowired
    private ConstructorService constructorService;
   @Autowired
   private GroupService groupService;
   @Autowired
   private StudentRepository studentRepository;
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
      model.addAttribute("constructor", constructorService.getConstructor(id));

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
        List<Student> students = (List)studentRepository.getAllStudentByGroup(group);
       for(Student student:students) {

    journalService.createJournal(new Journal(constructor.getSubject(),constructor.getLab(),
                                             constructor.getTest(),constructor.getCourseWork(),
                                             student.getRbook(),activeUser));

       }
        return "redirect:/teacher";
    }
 /*   @PatchMapping("/departments/{id}") //
    public String updateDepartment(@ModelAttribute("department") Department department){
        serviceD.editDepartment(department);

        return "redirect:/admin/departments";
    }
 */
    @DeleteMapping("/{id}")
    public String deleteJournal(@PathVariable("id") Long id) {
        constructorService.deleteConstructor(id);
        return "redirect:/teacher";
    }
}
