package com.example.ma_cnss_spring_mvc.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "radio", schema = "ma-cnss-spring", catalog = "")
public class RadioEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "percentage")
    private int percentage;
//    @ManyToMany(mappedBy = "radios")
//    private List<RadioEntity> radios;


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

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

//    public List<RadioEntity> getRadios() {
//        return radios;
//    }
//
//    public void setRadios(List<RadioEntity> radios) {
//        this.radios = radios;
//    }

}
