package cl.mobdev.challenge.usecase;

import org.junit.jupiter.api.Test;
import cl.mobdev.challenge.domain.Character;
import static org.junit.jupiter.api.Assertions.*;

class DeadExceptionTest {

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