package cl.mobdev.challenge.gateway.model;

import org.junit.jupiter.api.*;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class ApiCharacterTest {

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }

    @BeforeAll
    static void beforeAll() {

    }

    @AfterAll
    static void afterAll() {

    }

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

        // GIVEN

        // WHEN

        // THEN

    }

    @Test
    void name2() {

        // GIVEN

        // WHEN

        // THEN

    }

    @Test
    void name3() {

        // GIVEN

        // WHEN

        // THEN

    }

    @Test
    void name4() {

        // GIVEN

        // WHEN

        // THEN

    }

    @Test
    void name6() {

        // GIVEN

        // WHEN

        // THEN

    }

    @Test
    void name5() {

        // GIVEN

        // WHEN

        // THEN

    }
}