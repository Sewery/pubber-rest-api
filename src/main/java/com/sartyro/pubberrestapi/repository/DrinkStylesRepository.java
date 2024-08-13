package com.sartyro.pubberrestapi.repository;

import com.sartyro.pubberrestapi.model.DrinkStyles;
import com.sartyro.pubberrestapi.model.OpeningHours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkStylesRepository extends JpaRepository<DrinkStyles,Long> {
}
