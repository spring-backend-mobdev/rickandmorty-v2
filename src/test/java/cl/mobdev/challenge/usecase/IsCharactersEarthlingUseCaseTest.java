package cl.mobdev.challenge.usecase;

import cl.mobdev.challenge.domain.Character;
import cl.mobdev.challenge.domain.Location;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class IsCharactersEarthlingUseCaseTest {

    private IsCharactersEarthlingUseCase useCaseEarthling;
    private Character character = new Character();

    @BeforeEach
    void setUp() {
        System.out.println("1.- Starting of JUnit5 method test");
        this.useCaseEarthling = new IsCharactersEarthlingUseCase();
    }

    @AfterEach
    void tearDown() {
        System.out.println("End of JUnit5 method test");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("Starting Testing with JUnit 5");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("End of testing with JUnit5");
    }

    @Test
    @DisplayName("Should return true when character come from earth")
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
    @DisplayName("Should return false when character is not from earth")
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
    @DisplayName("Should return false when character locations is null")
    void should_return_false_when_character_locations_is_null() {
        boolean expected = false;
        //GIVEN
        Character character = new Character();
        Location origin = null;
        character.setOrigin(origin);

        //WHEN
        boolean response = this.useCaseEarthling.check(character);

        //THEN
        assertEquals(expected, response);
        //assertNull(origin);
    }

    @Test
    @DisplayName("Should return false when character origin is unknown")
    void should_return_false_when_character_origin_is_unknown() {
        boolean expected = false;

        //GIVEN
        Character character = new Character();
        Location origin = new Location();
        origin.setName("unknown");
        character.setOrigin(origin);

        //WHEN
        boolean response = this.useCaseEarthling.check(character);

        //THEN
        assertEquals(expected, response);
    }
}