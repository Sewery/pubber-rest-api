package com.sartyro.pubberrestapi.integration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sartyro.pubberrestapi.model.Drink;
import com.sartyro.pubberrestapi.model.DrinkStyles;
import com.sartyro.pubberrestapi.model.Pub;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
@SpringBootTest(
        properties = {
                "spring.jpa.show-sql=true",
                "spring.jpa.properties.hibernate.format_sql=false",
                "spring.jpa.generate-ddl=true",
                "spring.jpa.defer-datasource-initialization=true",
                "spring.sql.init.data-locations=classpath:data.sql"
        }
)
@AutoConfigureMockMvc
class PubControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldGetAllPubs() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/pubs/*"))
                .andDo(print())
                .andExpect(status().is(HttpStatus.OK.value()))
                .andReturn();
        List<Pub> pubList= Arrays.stream(objectMapper.readValue(result.getResponse().getContentAsString(), Pub[].class)).toList();
        assertNotNull(pubList);
        assertEquals(5, pubList.size());
        Pub firstPub = pubList.get(0);
        assertEquals("The London Pub", firstPub.getName());
        assertEquals("123 London St, London, UK", firstPub.getAddress());
        assertNotNull(firstPub.getDrinks());
        assertEquals(2, firstPub.getDrinks().size());

        // Verify that the drinks list is correctly populated
        Drink fristDrink = firstPub.getDrinks().get(0);
//        assertEquals(1L, fristDrink.getId());
        assertEquals("Golden Lager", fristDrink.getName());
        assertEquals("A crisp and refreshing lager.", fristDrink.getDescription());
        assertNotNull(fristDrink.getDrinkStyles());

        DrinkStyles drinkStyles = fristDrink.getDrinkStyles().get(0);
//        assertEquals(1L, drinkStyles.getId());
        assertEquals("Lager", drinkStyles.getStyleName());
    }
}