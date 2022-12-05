package com.example.ma_cnss_spring_mvc.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "analysis", schema = "ma-cnss-spring", catalog = "")
public class AnalysisEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "percentage")
    private double percentage;

//    @ManyToMany (mappedBy = "analyses")
//    private List<AnalysisEntity> analyses;


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

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

//    public List<AnalysisEntity> getAnalyses() {
//        return analyses;
//    }
//
//    public void setAnalyses(List<AnalysisEntity> analyses) {
//        this.analyses = analyses;
//    }

}
