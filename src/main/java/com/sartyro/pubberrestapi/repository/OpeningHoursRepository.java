package com.sartyro.pubberrestapi.repository;

import com.sartyro.pubberrestapi.model.OpeningHours;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpeningHoursRepository extends CrudRepository<OpeningHours,Long> {
}
