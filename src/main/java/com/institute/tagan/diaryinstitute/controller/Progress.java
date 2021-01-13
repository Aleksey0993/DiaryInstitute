package com.institute.tagan.diaryinstitute.controller;


import org.hibernate.annotations.Type;
import org.springframework.stereotype.Component;

@Component
public class Progress {
    private Long id;
    private String rbook;
    private String ngroup;
    private String fullname;

    private Integer[] lab;
    private Integer[] test;
    private Integer[] coursework;

    public Progress() {
    }

    public Progress(Long id, String rbook, String ngroup, String fullname, Integer[] lab, Integer[] test, Integer[] coursework) {
        this.id = id;
        this.rbook = rbook;
        this.ngroup = ngroup;
        this.fullname = fullname;
        this.lab = lab;
        this.test = test;
        this.coursework = coursework;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRbook() {
        return rbook;
    }

    public void setRbook(String rbook) {
        this.rbook = rbook;
    }

    public String getNgroup() {
        return ngroup;
    }

    public void setNgroup(String ngroup) {
        this.ngroup = ngroup;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Integer[] getLab() {
        return lab;
    }

    public void setLab(Integer[] lab) {
        this.lab = lab;
    }

    public Integer[] getTest() {
        return test;
    }

    public void setTest(Integer[] test) {
        this.test = test;
    }

    public Integer[] getCoursework() {
        return coursework;
    }

    public void setCoursework(Integer[] coursework) {
        this.coursework = coursework;
    }


}
