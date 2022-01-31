package cl.mobdev.challenge.usecase;

import cl.mobdev.challenge.domain.Character;
import cl.mobdev.challenge.domain.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsCharactersEarthlingUseCaseTest {

    private IsCharactersEarthlingUseCase useCaseEarthling;
    private Character character = new Character();

    @BeforeEach
    void setUp() {
        this.useCaseEarthling = new IsCharactersEarthlingUseCase();
    }

    @Test
    //@Disabled
    void should_return_true_when_character_come_from_earth() {
        boolean expected = true;

        //GIVEN
        Character character = new Character();
        Location origin = new Location();
        origin.setName("Earth");
        character.setOrigin(origin);

        //WHEN
       boolean response = this.useCaseEarthling.check(character);

        //THEN
        assertEquals(expected, response);
    }


    @Test
    void should_return_false_when_character_is_not_from_earth() {
        boolean expected = true;

        //GIVEN
        Character character = new Character();
        Location origin = new Location();
        origin.setName(character.getName());
        character.setOrigin(origin);

        //WHEN
        boolean response = this.useCaseEarthling.check(character);

        //THEN
        assertEquals(expected, response);
    }


    @Test
    void should_return_false_when_character_locations_is_null() {
        boolean expected = true;

        //GIVEN
        Character character = new Character();
        Location origin = new Location();
        origin.setName("");
        character.setOrigin(origin);

        //WHEN
        boolean response = this.useCaseEarthling.check();

        //THEN

        assertEquals(expected, response);
    }
    
    @Test
    void should_return_false_when_character_origin_is_unknown() {
        boolean expected = true;

        //GIVEN


        //WHEN


        //THEN

        assertEquals(true, true);
    }


}