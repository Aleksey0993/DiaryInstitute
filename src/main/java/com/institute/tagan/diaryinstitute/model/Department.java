package com.institute.tagan.diaryinstitute.model;


import javax.persistence.*;

@Entity
@Table(name="department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="namesh")
    private String nameSh;
    @Column(name="namel")
    private String nameL;
    @ManyToOne(optional = false)
    @JoinColumn(name = "facultyid")
    private Faculty primaryFaculty;



    public Department(){}

    public Department(String nameSh, String nameL){
        this.nameSh=nameSh;
        this.nameL=nameL;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameSh() {
        return nameSh;
    }

    public void setNameSh(String nameSh) {
        this.nameSh = nameSh;
    }

    public String getNameL() {
        return nameL;
    }

    public void setNameL(String nameL) {
        this.nameL = nameL;
    }

    public Faculty getPrimaryFaculty() {
        return primaryFaculty;
    }

    public void setPrimaryFaculty(Faculty primaryFaculty) {
        this.primaryFaculty = primaryFaculty;
    }


}
