
package com.institute.tagan.diaryinstitute.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name="journal")
public class Journal {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="subject")
    private String subject;
    @Column(name="lab")
    @Type(type = "com.institute.tagan.diaryinstitute.config.IntArrayUserType")
    private Integer[] lab;
    @Column(name="test")
    @Type(type = "com.institute.tagan.diaryinstitute.config.IntArrayUserType")
    private Integer[] test;
    @Column(name="coursework")
    @Type(type = "com.institute.tagan.diaryinstitute.config.IntArrayUserType")
    private Integer[] courseWork;
    @Column(name="rbook")
    private String rbook;
    @ManyToOne
    @JoinColumn(name = "us_id")
    private User primaryUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer[] getCourseWork() {
        return courseWork;
    }

    public void setCourseWork(Integer[] courseWork) {
        this.courseWork = courseWork;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getRbook() {
        return rbook;
    }

    public void setRbook(String rbook) {
        this.rbook = rbook;
    }

    public User getPrimaryUser() {
        return primaryUser;
    }

    public void setPrimaryUser(User primaryUser) {
        this.primaryUser = primaryUser;
    }

    public Journal(String subject, int lab, int test, int courseWork, String rbook, User primaryUser) {
        this.subject = subject;
        if(lab==0){
         this.lab=null;
        }
        else {
            this.lab= new Integer[lab];
          for(int i=0;i<lab;i++){
            this.lab[i]=0;
          }

        }
        if(test==0){
            this.test=null;
        }
        else{
            this.test= new Integer[test];
            for(int i=0;i<test;i++){
                this.test[i]=0;
            }
        }
       if(courseWork==0){

           this.courseWork=null;
       }
       else {
           this.courseWork= new Integer[courseWork];
           for (int i = 0; i < courseWork; i++) {
               this.courseWork[i] = 0;

           }
       }
        this.rbook = rbook;
        this.primaryUser = primaryUser;
    }

    public Journal() {
    }
}

