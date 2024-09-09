package com.sartyro.pubberrestapi.repository;

import com.sartyro.pubberrestapi.model.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<Tag,Long> {
}
