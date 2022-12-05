package com.example.ma_cnss_spring_mvc.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "medication", schema = "ma-cnss-spring", catalog = "")
public class MedicationEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "bar_code")
    private String barCode;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "repayment")
    private double repayment;

//    @ManyToMany(mappedBy = "medications")
//    private List<MedicationEntity> medications;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRepayment() {
        return repayment;
    }

    public void setRepayment(double repayment) {
        this.repayment = repayment;
    }

//    public List<MedicationEntity> getMedications() {
//        return medications;
//    }
//
//    public void setMedications(List<MedicationEntity> medications) {
//        this.medications = medications;
//    }

}
