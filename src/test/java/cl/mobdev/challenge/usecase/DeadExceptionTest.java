package cl.mobdev.challenge.usecase;

import cl.mobdev.challenge.usecase.exception.DeadException;
import org.junit.jupiter.api.*;
import cl.mobdev.challenge.domain.Character;
import static org.junit.jupiter.api.Assertions.*;

class DeadExceptionTest {

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
    void test_message_DeadException() {

        Character character = new Character();
        character.setStatus("Dead");
        Exception exception = assertThrows(DeadException.class, () -> {
            character.setStatus("Dead");
        });
        String actual = exception.getMessage();
        String expected = "El Personaje está muerto !!!!";

        assertEquals(actual, expected);

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