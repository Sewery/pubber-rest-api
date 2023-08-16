package com.sartyro.pubberrestapi.repository;

import com.sartyro.pubberrestapi.model.Drink;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkRepository extends CrudRepository<Drink,Long> {
}
