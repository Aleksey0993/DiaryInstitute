package com.institute.tagan.diaryinstitute.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name="constructor")
public class Constructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="subject")
    private String subject;
    @Column(name="lab")
    private int lab;
    @Column(name="test")
    private int test;
    @Column(name="coursework")
    private int courseWork;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User primaryUser;

    public Constructor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getLab() {
        return lab;
    }

    public void setLab(int lab) {
        this.lab = lab;
    }

    public int getTest() {
        return test;
    }

    public void setTest(int test) {
        this.test = test;
    }

    public int getCourseWork() {
        return courseWork;
    }

    public void setCourseWork(int courseWork) {
        this.courseWork = courseWork;
    }



    public User getPrimaryUser() {
        return primaryUser;
    }

    public void setPrimaryUser(User primaryUser) {
        this.primaryUser = primaryUser;
    }


}
