package com.sartyro.pubberrestapi.integration.repository;

import com.sartyro.pubberrestapi.repository.PubRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class PubRepositoryTest {
    @Autowired
    private PubRepository repository;
    @Test
    void itShouldCheckIfFetchesAllPubs(){

    }
    @Test
    void itShouldCheckIfFetchesAllPubsOptimal(){

    }
   /* @ParameterizedTest
    @ValueSource(longs = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void givenLazyListBasedUser_WhenFetchingOneUser_ThenIssueTwoRequest(Long id) {
        repository.getUserByIdWithPredicate(id, user -> !user.getPosts().isEmpty());
        assertSelectCount(2);
    }
    public static void assertSelectCount(long expectedSelectCount) {
        QueryCount queryCount = QueryCountHolder.getGrandTotal();
        long recordedSelectCount = queryCount.getSelect();
        if (expectedSelectCount != recordedSelectCount) {
            throw new SQLSelectCountMismatchException(expectedSelectCount, recordedSelectCount);
        }
    }*/
}