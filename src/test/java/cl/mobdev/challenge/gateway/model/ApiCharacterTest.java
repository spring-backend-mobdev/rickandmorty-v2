package cl.mobdev.challenge.gateway.model;

import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class ApiCharacterTest {

    @Test
    void getName_id_number_1() {
        ApiCharacter apiCharacter = new ApiCharacter();
        apiCharacter.setName("Rick Sanchez");
        String expected = "Rick Sanchez";
        String real = apiCharacter.getName();
        assertEquals(expected, real);
    }

    @Test
    void getName() {
        ApiCharacter apiCharacter = new ApiCharacter();
        apiCharacter.setName("Rick Sánchez");
        String expected = "Rick Sánchez";
        String real = apiCharacter.getName();
        assertEquals(expected, real);

        apiCharacter.setName("Morty");
        String expected1 = "Morty";
        String real1 = apiCharacter.getName();
        assertEquals(expected1, real1);

        apiCharacter.setName("EMMANUEL");
        String expected2 = "emmanuel";
        String real2 = apiCharacter.getName().toLowerCase(Locale.ROOT);
        assertEquals(expected2, real2);
    }


    @Test
    void id_not_found() {

    }

    @Test
    void name2() {

    }

    @Test
    void name3() {

    }

    @Test
    void name4() {

    }

    @Test
    void name6() {

    }

    @Test
    void name5() {

    }
}