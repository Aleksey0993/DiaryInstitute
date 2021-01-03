package com.institute.tagan.diaryinstitute.model;


import javax.persistence.*;


import java.util.Collection;

@Entity
@Table(name="faculty")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="namesh")

    private String nameSh;
    @Column(name="namel")
    private String nameL;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "faculty_id")
    private Collection<Department> departments;
    public Faculty(){}

    public Faculty(String nameSh, String nameL){
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


}
