package com.example.drugcalculator.model;

import javax.persistence.*;

@Entity
public class Drug {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    private Long id;

    @Column(name = "drug")
    private String drug;

    @Column(name = "datee")
    private String datee;

    public Drug() {
    }

    /*public String getName() {
        return drug;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDrug() {
        return drug;
    }

    public void setDrug(String drug) {
        this.drug = drug;
    }

    public String getDate() {
        return datee;
    }

    public void setDate(String datee) {
        this.datee = datee;
    }
}
