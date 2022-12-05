package com.example.ma_cnss_spring_mvc.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "dossier", schema = "ma-cnss-spring", catalog = "")
public class DossierEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "patient_id")
    private int patientId;
    @Basic
    @Column(name = "status")
    private String status;
    @Basic
    @Column(name = "repayment")
    private double repayment;
    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private PatientEntity patientByPatientId;

//    @OneToMany(mappedBy = "dossierByDossierId")
//    private Collection<DossierAnalysisEntity> dossierAnalysesById;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "dossier_medication",
            joinColumns = {@JoinColumn(name = "dossier_id")},
            inverseJoinColumns = {@JoinColumn(name = "medication_id")}
    )
    private List<MedicationEntity> medications;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "dossier_analysis",
            joinColumns = {@JoinColumn(name = "dossier_id")},
            inverseJoinColumns = {@JoinColumn(name = "analysis_id")}
    )
    private List<AnalysisEntity> analyses;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "dossier_specialty",
            joinColumns = {@JoinColumn(name = "dossier_id")},
            inverseJoinColumns = {@JoinColumn(name = "specialty_id")}
    )
    private List<SpecialityEntity> specialities;


    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "dossier_radio",
            joinColumns = {@JoinColumn(name = "dossier_id")},
            inverseJoinColumns = {@JoinColumn(name = "radio_id")}
    )
    private List<RadioEntity> radios;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getRepayment() {
        return repayment;
    }

    public void setRepayment(double repayment) {
        this.repayment = repayment;
    }

    public List<MedicationEntity> getMedications() {
        return medications;
    }

    public void setMedications(List<MedicationEntity> medications) {
        this.medications = medications;
    }

    public List<AnalysisEntity> getAnalyses() {
        return analyses;
    }

    public void setAnalyses(List<AnalysisEntity> analyses) {
        this.analyses = analyses;
    }

    public List<SpecialityEntity> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(List<SpecialityEntity> specialities) {
        this.specialities = specialities;
    }

    public List<RadioEntity> getRadios() {
        return radios;
    }

    public void setRadios(List<RadioEntity> radios) {
        this.radios = radios;
    }

    public PatientEntity getPatientByPatientId() {
        return patientByPatientId;
    }

    public void setPatientByPatientId(PatientEntity patientByPatientId) {
        this.patientByPatientId = patientByPatientId;
    }

}
