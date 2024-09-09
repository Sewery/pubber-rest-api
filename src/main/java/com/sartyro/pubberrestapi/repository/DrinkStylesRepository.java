package com.sartyro.pubberrestapi.repository;

import com.sartyro.pubberrestapi.model.DrinkStyles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkStylesRepository extends JpaRepository<DrinkStyles,Long> {
}
