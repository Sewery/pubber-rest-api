package com.sartyro.pubberrestapi.integration.repository;

import com.sartyro.pubberrestapi.controller.editdto.DrinkEditDto;
import com.sartyro.pubberrestapi.controller.editdto.DrinkStylesEditDto;
import com.sartyro.pubberrestapi.model.Drink;
import com.sartyro.pubberrestapi.model.DrinkStyles;
import com.sartyro.pubberrestapi.repository.DrinkRepository;
import com.sartyro.pubberrestapi.repository.DrinkStylesRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Transactional
@DataJpaTest(properties = {
        "spring.jpa.show-sql=true",
        "spring.jpa.properties.hibernate.format_sql=false",
        "spring.jpa.generate-ddl=true",
        "spring.jpa.defer-datasource-initialization=true",
        "spring.sql.init.data-locations=classpath:data.sql"
})
class DrinkRepositoryTest {
    private static final Logger log = LoggerFactory.getLogger(DrinkRepositoryTest.class);
    @Autowired
    private DrinkRepository drinkRepository;
    @Autowired
    private EntityManager entityManager;

    private Statistics statistics;

    @BeforeEach
    public void setUp() {
      /*  List<DrinkStyles> startDrinkStyles = List.of(
                new DrinkStyles(1L,"IPA",null),
                new DrinkStyles(2L,"Pszeniczne",null),
                new DrinkStyles(3L,"APA",null)
        );
        List<Drink> startDrinks = List.of(
                new Drink(1L,"Amber","Beer","A crisp and refreshing lag",null,List.of(startDrinkStyles.get(0), startDrinkStyles.get(2))),
                new Drink(2L,"Tyskie","Beer","A crisp and refreshing lag",null,List.of(startDrinkStyles.get(1))),
                new Drink(3L,"Harnaś","Beer","A crisp and refreshing lag",null,null));
        drinkStylesRepository.save(startDrinkStyles.get(0));
        drinkStylesRepository.save(startDrinkStyles.get(1));
        drinkStylesRepository.save(startDrinkStyles.get(2));
        startDrinks.get(0).setDrinkStyles(startDrinkStyles);
        startDrinks.get(1).setDrinkStyles(List.of(startDrinkStyles.get(0)));
        startDrinks.get(2).setDrinkStyles(List.of());
        drinkRepository.save(startDrinks.get(0));
        drinkRepository.save(startDrinks.get(1));
        drinkRepository.save(startDrinks.get(2));*/

        Session session = entityManager.unwrap(Session.class);
        SessionFactory sessionFactory = session.getSessionFactory();
        statistics = sessionFactory.getStatistics();
        statistics.setStatisticsEnabled(true);
        statistics.clear();
    }
    /**
     * Unresolvable problem in relation Many to Many
     */
    @Test
    @Disabled
    void isNPlusOneProblemDetectionWhenFindAllDrinks() {
        //Given
        statistics.clear();
        log.info("Clearing");
        List<Drink> drinks = drinkRepository.findAll();
        //When
        for (Drink drink : drinks) {
            drink.getDrinkStyles().size();  // Assuming Drink has a collection of Ingredients
        }

        long queryCount = statistics.getPrepareStatementCount();

        // Expecting only 1 query to load drinks and their ingredients
        assertEquals(1, queryCount, "N+1 problem detected: Too many queries executed.");
    }
}