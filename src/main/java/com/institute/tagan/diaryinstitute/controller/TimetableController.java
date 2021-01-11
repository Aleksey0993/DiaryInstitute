package com.institute.tagan.diaryinstitute.controller;

import com.institute.tagan.diaryinstitute.model.Group;
import com.institute.tagan.diaryinstitute.service.GroupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


@Controller
@RequestMapping("/timetable")
public class TimetableController {
    private final String UPLOAD_DIR = "./uploads/";
    @Autowired
    private GroupService groupService;

    @GetMapping()
    public String timetable() {

        return "timetable";
    }


    @GetMapping("/download")
    public ResponseEntity<?> downloadFile1(@RequestParam("numGroup") String numGroup, Model model) throws IOException {
        String filename = groupService.findFile(numGroup);
        System.out.println(filename);
        if(filename==null || filename.equals("default_null")){
            model.addAttribute("empty_file","Расписание не найдено");
            return ResponseEntity.ok().body("Расписание не найдено");

        }

        File file = new File(UPLOAD_DIR+filename);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));



        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment;filename=" + file.getName())
                .contentType(MediaType.APPLICATION_PDF).contentLength(file.length())
                .body(resource);
    }







}