package com.example.drugcalculator.model;

import javax.persistence.*;

@Entity
public class GivenDose {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    private Long id;

    @Column(name = "drug")
    private String drug;

    @Column(name = "dateOfAdministration")
    private String dateOfAdministration;

    public GivenDose() {
    }


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

    public String getDateOfAdministration() {
        return dateOfAdministration;
    }

    public void setDateOfAdministration(String dateOfAdministration) {
        this.dateOfAdministration = dateOfAdministration;
    }
}
