package com.institute.tagan.diaryinstitute.controller;

import com.institute.tagan.diaryinstitute.model.*;
import com.institute.tagan.diaryinstitute.repository.RoleRepository;
import com.institute.tagan.diaryinstitute.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;


@Controller
@RequestMapping("/admin")
public class AdminController {
    private final String UPLOAD_DIR = "./uploads/";
    // Внедрение сервиса при работе с сущностью факультет
    @Autowired
    private FacultyService service;
    // Внедрение сервиса при работе с сущностью кафедра
    @Autowired
    private DepartmentService serviceD;
    // Внедрение сервиса при работе с сущностью специальность
    @Autowired
    private SpecialityService serviceS;
    // Внедрение сервиса при работе с сущностью группа
    @Autowired
    private GroupService serviceG;
    // Внедрение сервиса при работе с сущностью студент
    @Autowired
    private StudentService serviceSt;

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
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


    ////////// Начало работы со страницей кафедры
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
    public String updateDepartment(@ModelAttribute("department") Department department,
                                   @PathVariable("id") Long id){
        serviceD.editDepartmentByID(department,id);


        return "redirect:/admin/departments";
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartment(@PathVariable("id") Long id){
        serviceD.deleteDepartment(id);
        return "redirect:/admin/departments";
    }
    /////////////////////////////////////////////////////////
    /// Конец работы со страницей кафедры



    ////////// Начало работы со страницей специальности
    @GetMapping("/specialities")
    public String specialities(Model model){
        model.addAttribute("specialities", serviceS.getAllSpecialities());

        return "speciality";
    }

    @GetMapping("/specialities/new")
    public String newSpeciality(@ModelAttribute("speciality") Speciality speciality, Model model){
        model.addAttribute("departments", serviceD.getAllDepartments());
        return "newSpeciality";
    }

    @PostMapping("/specialities")
    public String createSpeciality(@ModelAttribute("speciality") Speciality speciality){

        serviceS.createSpeciality(speciality);
        return "redirect:/admin/specialities";
    }

    @GetMapping("/specialities/{id}/edit")
    public String editSpeciality(@PathVariable("id") Long id, Model model){
        model.addAttribute("departments", serviceD.getAllDepartments());
        Optional<Speciality> s = serviceS.getSpeciality(id);
        if(s.isPresent()) {

            model.addAttribute("speciality", s.get());
        }
        return "editSpeciality";
    }
    @PatchMapping("/specialities/{id}") //
    public String updateSpeciality(@ModelAttribute("speciality") Speciality speciality,
                                   @PathVariable("id") Long id){
        serviceS.editSpecialityByID(speciality,id);

        return "redirect:/admin/specialities";
    }

    @DeleteMapping("/specialities/{id}")
    public String deleteSpeciality(@PathVariable("id") Long id){
        serviceS.deleteSpeciality(id);
        return "redirect:/admin/specialities";
    }
    /////////////////////////////////////////////////////////
    /// Конец работы со страницей специальности


    ////////// Начало работы со страницей группы
    @GetMapping("/groups")
    public String groups(Model model){
        model.addAttribute("groups", serviceG.getAllGroups());

        return "group";
    }

    @GetMapping("/groups/new")
    public String newGroup(@ModelAttribute("group") Group group, Model model){
        model.addAttribute("specialities", serviceS.getAllSpecialities());
        return "newGroup";
    }

    @PostMapping("/groups")
    public String createGroup(@ModelAttribute("group") Group group){
        group.setNameFile("default_null");
        serviceG.createGroup(group);
        return "redirect:/admin/groups";
    }

    @GetMapping("/groups/{id}/edit")
    public String editGroup(@PathVariable("id") Long id, Model model){
        model.addAttribute("specialities", serviceS.getAllSpecialities());
        Optional<Group> g = serviceG.getGroup(id);
        if(g.isPresent()) {

            model.addAttribute("group", g.get());
        }
        return "editGroup";
    }
    @PatchMapping("/groups/{id}")
    public String updateGroup(@ModelAttribute("group") Group group,
                              @PathVariable("id") Long id){


        serviceG.editGroupByID(group,id);

        return "redirect:/admin/groups";
    }

    @PatchMapping("/groups/timetable/{id}") //
    public String updateGroupTimetable( @PathVariable("id") Long id,@ModelAttribute("group") Group group,
                              @RequestParam(value = "file", required = false) MultipartFile file,
                              RedirectAttributes attributes){

            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            group.setNameFile(fileName);

            // save the file on the local file system
            try {
                Path path = Paths.get(UPLOAD_DIR + fileName);
                Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }


        serviceG.editGroupFileByID(group,id);

        return "redirect:/admin/groups";
    }

    @DeleteMapping("/groups/{id}")
    public String deleteGroup(@PathVariable("id") Long id){
        String fileName="";
        Optional<Group> g = serviceG.getGroup(id);
        if(g.isPresent()) {

             fileName = g.get().getNameFile();

        }


        new File(UPLOAD_DIR+fileName).delete();

        serviceG.deleteGroup(id);
        return "redirect:/admin/groups";
    }
    /////////////////////////////////////////////////////////
    /// Конец работы со страницей группы


    ////////// Начало работы со страницей студенты
    @GetMapping("/students")
    public String students(Model model){
        model.addAttribute("students", serviceSt.getAllStudents());

        return "student";
    }

    @GetMapping("/students/new")
    public String newStudent(@ModelAttribute("student") Student student, Model model){
        model.addAttribute("groups", serviceG.getAllGroups());
        return "newStudent";
    }

    @PostMapping("/students")
    public String createStudent(@ModelAttribute("student") Student student){

        serviceSt.createStudent(student);
        return "redirect:/admin/students";
    }

    @GetMapping("/students/{id}/edit")
    public String editStudents(@PathVariable("id") Long id, Model model){
        model.addAttribute("groups", serviceG.getAllGroups());
        Optional<Student> st = serviceSt.getStudent(id);
        if(st.isPresent()) {

            model.addAttribute("student", st.get());
        }
        return "editStudent";
    }
    @PatchMapping("/students/{id}") //
    public String updateStudent(@ModelAttribute("student") Student student){
        serviceSt.editStudent(student);

        return "redirect:/admin/students";
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable("id") Long id){
        serviceSt.deleteStudent(id);
        return "redirect:/admin/students";
    }
    /////////////////////////////////////////////////////////
    /// Конец работы со страницей студенты

    ////////// Начало работы со страницей пользователи
    @GetMapping("/users")
    public String users(Model model){
        model.addAttribute("users", userService.allUsers());

        return "user";
    }

    @GetMapping("/users/new")
    public String newUser(@ModelAttribute("user") User user, Model model){
        model.addAttribute("roles", roleService.getAllRoles());
        return "newUser";
    }

    @PostMapping("/users")
    public String createUser(@ModelAttribute("user") User user,
                             BindingResult bindingResult, Model model){


        if (bindingResult.hasErrors()) {
            return "newUser";
        }
        if (!user.getPassword().equals(user.getPasswordConfirm())){
            model.addAttribute("roles", roleService.getAllRoles());
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "newUser";
        }
        if (!userService.saveUser(user)){
            model.addAttribute("roles", roleService.getAllRoles());
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "newUser";
        }


        return "redirect:/admin/users";
    }

    @GetMapping("/users/{id}/edit")
    public String editUser(@PathVariable("id") Long id, Model model){
       model.addAttribute("id", id);

        return "editUser";
    }
    @PatchMapping("/users/{id}") //
    public String updateUser( Model model,
                             @PathVariable("id") Long id,
                             @RequestParam("password") String password,
                             @RequestParam("passwordConfirm") String passwordConfirm){

        if(!password.equals(passwordConfirm)){
            model.addAttribute("id", id);
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "editUser";
        }

        userService.editPasswordById(password,id);


        return "redirect:/admin/users";
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return "redirect:/admin/users";
    }
    /////////////////////////////////////////////////////////
    /// Конец работы со страницей пользователи

}