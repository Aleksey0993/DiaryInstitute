package com.institute.tagan.diaryinstitute.model;

import javax.persistence.*;

@Entity
@Table(name="groupSt")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="namesh")
    private String nameSh;

    @Column(name="namefile")
    private String nameFile;
    @ManyToOne
    @JoinColumn(name = "speciality_id")
    private Speciality primarySpeciality;



    public Group(){}

    public Group(String nameSh,  String nameFile){
        this.nameSh=nameSh;
        this.nameFile=nameFile;
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

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public Speciality getPrimarySpeciality() {
        return primarySpeciality;
    }

    public void setPrimarySpeciality(Speciality primarySpeciality) {
        this.primarySpeciality = primarySpeciality;
    }



}