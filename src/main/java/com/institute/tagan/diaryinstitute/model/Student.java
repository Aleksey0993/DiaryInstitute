package com.institute.tagan.diaryinstitute.model;

import javax.persistence.*;

@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
     @Column(name="surname")
    private String surname;
    @Column(name="name")
    private String name;
    @Column(name="patronymic")
    private String patronymic;
    @Column(name="rbook")
    private String rbook;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group primaryGroup;

    public Student(String surname, String name, String patronymic, String rbook, Group primaryGroup) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.rbook = rbook;
        this.primaryGroup = primaryGroup;
    }
   public Student(){

   }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getRbook() {
        return rbook;
    }

    public void setRbook(String rbook) {
        this.rbook = rbook;
    }

    public Group getPrimaryGroup() {
        return primaryGroup;
    }

    public void setPrimaryGroup(Group primaryGroup) {
        this.primaryGroup = primaryGroup;
    }


}
