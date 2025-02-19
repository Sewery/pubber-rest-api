package com.sartyro.pubberrestapi.integration.repository;

import com.sartyro.pubberrestapi.repository.PubRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class PubRepositoryTest {
    //TODO
    @Autowired
    private PubRepository repository;
    @Test
    void itShouldCheckIfFetchesAllPubs(){

    }
    @Test
    void itShouldCheckIfFetchesAllPubsOptimal(){

    }
}