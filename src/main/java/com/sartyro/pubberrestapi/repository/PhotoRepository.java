package com.sartyro.pubberrestapi.repository;

import com.sartyro.pubberrestapi.model.Photo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends CrudRepository<Photo,Long> {
}
