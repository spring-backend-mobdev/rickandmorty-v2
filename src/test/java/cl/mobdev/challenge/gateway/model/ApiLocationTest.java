package cl.mobdev.challenge.gateway.model;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;

import static org.junit.jupiter.api.Assertions.*;

class ApiLocationTest {

    private ApiLocation apiLocation;

    @BeforeEach
    void setUp() {
        apiLocation = new ApiLocation();
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
    @Nested
    void id_not_found() {

        // GIVEN

        // WHEN

        // THEN
        assertEquals(true, true);
    }

    @Test
    void url_is_empty() {

        // GIVEN

        // WHEN

        // THEN
        assertEquals(true, true);
    }

    @Test
    void url_is_null() {

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