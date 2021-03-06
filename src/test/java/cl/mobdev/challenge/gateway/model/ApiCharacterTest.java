package cl.mobdev.challenge.gateway.model;

import org.junit.jupiter.api.*;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class ApiCharacterTest {

    private ApiCharacter apiCharacter;

    @BeforeEach
    void setUp() {
        apiCharacter = new ApiCharacter();
    }

    @Test
    void getName_id_number_1() {
        apiCharacter.setName("Rick Sanchez");
        String expected = "Rick Sanchez";
        String real = apiCharacter.getName();
        assertEquals(expected, real);
    }

    @Test
    void getName() {
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

        // GIVEN

        // WHEN

        // THEN

    }
}