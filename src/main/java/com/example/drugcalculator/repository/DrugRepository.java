package com.example.drugcalculator.repository;

import com.example.drugcalculator.model.GivenDose;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DrugRepository extends CrudRepository<GivenDose, Long> {

}
