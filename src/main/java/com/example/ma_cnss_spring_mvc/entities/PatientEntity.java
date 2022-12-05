package com.example.ma_cnss_spring_mvc.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "patient", schema = "ma-cnss-spring", catalog = "")
public class PatientEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "mat")
    private int mat;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "password")
    private String password;
    @OneToMany(mappedBy = "patientByPatientId")
    private Collection<DossierEntity> dossiersById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMat() {
        return mat;
    }

    public void setMat(int mat) {
        this.mat = mat;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<DossierEntity> getDossiersById() {
        return dossiersById;
    }

    public void setDossiersById(Collection<DossierEntity> dossiersById) {
        this.dossiersById = dossiersById;
    }
}
