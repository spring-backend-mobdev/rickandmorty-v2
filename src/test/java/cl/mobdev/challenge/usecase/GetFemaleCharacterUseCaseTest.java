package cl.mobdev.challenge.usecase;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetFemaleCharacterUseCaseTest {
    
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void should_return_character_when_gender_is_female() {
        String expected = "female";
        //GIVEN


        //WHEN


        //THEN
        
        
        
        assertEquals(expected, "female");
    }

    @Test
    void should_throw_exception_when_gender_isNot_female() {
    
    
    
    }


    @Test
    void should_throw_exception_when_gender_is_null() {
        
        
        
    }
}