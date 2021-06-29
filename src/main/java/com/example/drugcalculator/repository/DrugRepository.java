package com.example.drugcalculator.repository;

import com.example.drugcalculator.model.GivenDose;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DrugRepository extends CrudRepository<GivenDose, Long> {

    @Query("select t from GivenDose t")
    List<GivenDose>getAllDrugs();
    @Query(value = "insert into GivenDose (dateOfAdministration, drug) values (:dateOfAdministration, :drug)", nativeQuery = true)
    GivenDose addDrug(@Param("dateOfAdministration") String dateOfAdministration, @Param("drug") String drug);
    @Query("Delete from GivenDose where id = :id")
    void delete(@Param("id") long id);
    @Query("Update GivenDose set drug = :drug, dateOfAdministration = :dateOfAdministration where id = :id")
    GivenDose update(@Param("id") GivenDose givenDose);

}
