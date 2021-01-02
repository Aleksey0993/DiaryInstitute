package com.institute.tagan.diaryinstitute.controller;

import com.institute.tagan.diaryinstitute.model.Department;
import com.institute.tagan.diaryinstitute.model.Faculty;
import com.institute.tagan.diaryinstitute.service.DepartmentService;
import com.institute.tagan.diaryinstitute.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@RequestMapping("/admin")
public class AdminController {

    // Внедрение сервиса при работе с сущностью факультет
    @Autowired
    private FacultyService service;
    // Внедрение сервиса при работе с сущностью кафедра
    @Autowired
    private DepartmentService serviceD;

    @GetMapping()
    public String  admin_main( Model model) {
        /*
         * Post post = new Post(); post.setId(1L); post.setName("Alex");
         * //model.addAttribute("id",id); //model.addAttribute("name",name);

         * postRepository.save(post);
         */

        return "admin";
    }

    ///////////////////////////////////////////////////////////////////////////////
    //// Работа со страницей факультеты
    @GetMapping("/faculties")
    public String faculty(Model model){
        model.addAttribute("faculties", service.getAllFaculties());

        return "faculty";
    }
    @GetMapping("/faculties/new")
    public String newFaculty(@ModelAttribute("faculty") Faculty faculty){
        return "newFaculty";
    }

    @PostMapping("/faculties")
    public String createFaculty(@ModelAttribute("faculty")  Faculty faculty,
                                BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "redirect:/faculties/new";
        }
        service.createFaculty(faculty);
        return "redirect:/admin/faculties";
    }
    @GetMapping("/faculties/{id}/edit")
    public String editFaculty(@PathVariable("id") Long id, Model model){
        Optional<Faculty> f = service.getFaculty(id);
        if(f.isPresent()) {

            model.addAttribute("faculty", f.get());
        }
        return "editFaculty";
    }
    @PatchMapping("/faculties/{id}")
    public String updateFaculty(@ModelAttribute("faculty") Faculty faculty, @PathVariable("id") Long id){
        service.editFaculty(faculty,id);

        return "redirect:/admin/faculties";
    }
    @DeleteMapping("/faculties/{id}")
    public String deleteFaculty(@PathVariable("id") Long id){
        service.deleteFaculty(id);
        return "redirect:/admin/faculties";
    }
    /////////////////////////////////////////////////////////
    /// Конец работы со страницей факультеты


    ////////// Начало работы со страницей факультеты
    @GetMapping("/departments")
    public String departments(Model model){
        model.addAttribute("departments", serviceD.getAllDepartments());

        return "department";
    }

    @GetMapping("/departments/new")
    public String newDepartment(@ModelAttribute("department") Department department, Model model){
        model.addAttribute("faculties", service.getAllFaculties());
        return "newDepartment";
    }

    @PostMapping("/departments")
    public String createDepartment(@ModelAttribute("department") Department department){

        serviceD.createDepartment(department);
        return "redirect:/admin/departments";
    }



    @GetMapping("/departments/{id}/edit")
    public String editDepartment(@PathVariable("id") Long id, Model model){
        model.addAttribute("faculties", service.getAllFaculties());
        Optional<Department> d = serviceD.getDepartment(id);
        if(d.isPresent()) {

            model.addAttribute("department", d.get());
        }
        return "editDepartment";
    }
    @PatchMapping("/departments/{id}") //
    public String updateDepartment(@ModelAttribute("department") Department department){
        serviceD.editDepartment(department);

        return "redirect:/admin/departments";
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartment(@PathVariable("id") Long id){
        serviceD.deleteDepartment(id);
        return "redirect:/admin/departments";
    }

}