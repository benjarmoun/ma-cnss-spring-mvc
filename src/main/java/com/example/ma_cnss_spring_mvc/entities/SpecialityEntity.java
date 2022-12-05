package com.example.ma_cnss_spring_mvc.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "speciality", schema = "ma-cnss-spring", catalog = "")
public class SpecialityEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "repayment")
    private double repayment;
    @Basic
    @Column(name = "medication_refundable")
    private int medicationRefundable;
//    @OneToMany(mappedBy = "specialityBySpecialtyId")
//    private Collection<DossierSpecialtyEntity> dossierSpecialtiesById;

//    @ManyToMany(mappedBy = "specialities")
//    private List<SpecialityEntity> specialities;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getMedicationRefundable() {
        return medicationRefundable;
    }

    public void setMedicationRefundable(int medicationRefundable) {
        this.medicationRefundable = medicationRefundable;
    }

//    public List<SpecialityEntity> getSpecialities() {
//        return specialities;
//    }
//
//    public void setSpecialities(List<SpecialityEntity> specialities) {
//        this.specialities = specialities;
//    }

}
