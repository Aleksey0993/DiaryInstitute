
package com.institute.tagan.diaryinstitute.model;

import com.institute.tagan.diaryinstitute.config.IntArrayUserType;
import com.vladmihalcea.hibernate.type.array.IntArrayType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;

@Entity
@TypeDefs({
         @TypeDef(name="int-array", typeClass= IntArrayType.class)
})

@Table(name="journal")
public class Journal {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="subject")
    private String subject;


    @Type(type = "int-array")
    @Column(name="lab", columnDefinition = "integer[]")
    private Integer[] lab;
    @Type(type = "int-array")
    @Column(name="test",columnDefinition = "integer[]")
    private Integer[] test;
    @Type(type = "int-array")
    @Column(name="coursework",columnDefinition = "integer[]")
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

        else if(lab>0) {
            this.lab= new Integer[lab];
          for(int i=0;i<lab;i++){
            this.lab[i]=0;
          }

        }
        if(test==0){
            this.test=null;
        }
        else if(test>0){
            this.test= new Integer[test];
            for(int i=0;i<test;i++){
                this.test[i]=0;
            }
        }
       if(courseWork==0){

           this.courseWork=null;
       }
       else if(courseWork>0){
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

