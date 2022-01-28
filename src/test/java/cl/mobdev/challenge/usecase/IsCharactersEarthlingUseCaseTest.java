package cl.mobdev.challenge.usecase;

import cl.mobdev.challenge.domain.Character;
import cl.mobdev.challenge.domain.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsCharactersEarthlingUseCaseTest {

    private IsCharactersEarthlingUseCase useCase;

    @BeforeEach
    void setUp() {
        this.useCase = new IsCharactersEarthlingUseCase();
    }

    @Test
    void should_return_true_when_character_come_from_earth() {

        boolean expected = true;

        //GIVEN
        Character character = new Character();
        Location origin = new Location();
        origin.setName("Earth");
        character.setOrigin(origin);

        //WHEN
        boolean response = this.useCase.check(character);

        //THEN
        assertEquals(expected, response);
    }


    @Test
    void namw2() {


        //GIVEN


        //WHEN


        //THEN

        assertEquals(true, true);
    }


    @Test
    void namw3() {


        //GIVEN


        //WHEN


        //THEN

        assertEquals(true, true);
    }


    @Test
    void namw4() {


        //GIVEN


        //WHEN


        //THEN

        assertEquals(true, true);
    }


}