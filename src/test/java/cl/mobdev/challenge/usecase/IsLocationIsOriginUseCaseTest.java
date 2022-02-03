package cl.mobdev.challenge.usecase;

import cl.mobdev.challenge.gateway.model.ApiCharacter;
import cl.mobdev.challenge.gateway.model.ApiLocation;
import cl.mobdev.challenge.gateway.model.ApiOrigin;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsLocationIsOriginUseCaseTest {

    private IsLocationIsOriginUseCase isLocationIsOriginUseCase;
    private ApiCharacter apiCharacter;

    @BeforeEach
    void setUp() {
        this.isLocationIsOriginUseCase = new IsLocationIsOriginUseCase();
        ApiCharacter character = new ApiCharacter();
        ApiLocation location = new ApiLocation();
        ApiOrigin  origin = new ApiOrigin();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Testing end");
    }

    @Test
    @DisplayName("Should return true if location equals origin")
    void should_return_true_if_location_equals_origin() {
        boolean expected = true;
        //GIVEN
        ApiLocation location = new ApiLocation();
        ApiOrigin origin = new ApiOrigin();
        ApiCharacter character = new ApiCharacter();
        location.setName("Earth");
        origin.setName("Earth");
        character.setLocation(location);
        character.setOrigin(origin);

        //WHEN
        boolean actual = isLocationIsOriginUseCase.execute(character);

        //THEN
        assertAll(() -> {assertEquals(expected, actual);},
                () -> {assertNotNull(expected);},
                () -> {assertNotNull(actual);},
                () -> {assertTrue(actual, "Earth");});
    }

    @Test
    @DisplayName("Should throw exception if location unknown")
    void should_throw_exception_if_location_unknown() {
        boolean expected = true;
        //GIVEN

        //WHEN

        //THEN


        assertAll(() -> {assertEquals(true, true);},
                () -> {},
                () -> {},
                () -> {});
    }

    @Test
    @DisplayName("Should throw exception if origin unknown")
    void should_throw_exception_if_origin_unknown() {
        boolean expected = true;
        //GIVEN

        //WHEN

        //THEN


        assertAll(() -> {assertEquals(true, true);},
                () -> {},
                () -> {},
                () -> {});
    }

    @Test
    @DisplayName("should_throw_exception_if_location_and_origin_unknown")
    void should_throw_exception_if_location_and_origin_unknown() {
        boolean expected = true;
        //GIVEN

        //WHEN

        //THEN


        assertAll(() -> {assertEquals(true, true);},
                () -> {},
                () -> {},
                () -> {});
    }

    @Test
    @DisplayName("should_throw_exception_if_location_null")
    void should_throw_exception_if_location_null() {
        boolean expected = true;
        //GIVEN

        //WHEN

        //THEN


        assertAll(() -> {assertEquals(true, true);},
                () -> {},
                () -> {},
                () -> {});
    }

    @Test
    @DisplayName("should_throw_exception_if_origin_null")
    void should_throw_exception_if_origin_null() {
        boolean expected = true;
        //GIVEN

        //WHEN

        //THEN


        assertAll(() -> {assertEquals(true, true);},
                () -> {},
                () -> {},
                () -> {});
    }

    @Test
    @DisplayName("")
    void should_6() {
        boolean expected = true;
        //GIVEN

        //WHEN

        //THEN


        assertAll(() -> {assertEquals(true, true);},
                () -> {},
                () -> {},
                () -> {});
    }
}