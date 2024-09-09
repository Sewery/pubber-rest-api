package com.sartyro.pubberrestapi.repository;

import com.sartyro.pubberrestapi.model.OpeningHours;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpeningHoursRepository extends CrudRepository<OpeningHours,Long> {
    @Query("SELECT p FROM OpeningHours p WHERE p.pub.id=?1")
    List<OpeningHours> findByIdPub(Long pubId);
}
