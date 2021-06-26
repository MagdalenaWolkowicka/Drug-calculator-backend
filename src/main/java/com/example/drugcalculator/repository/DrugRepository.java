package com.example.drugcalculator.repository;

import com.example.drugcalculator.model.Drug;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DrugRepository extends CrudRepository<Drug, Long> {

}
