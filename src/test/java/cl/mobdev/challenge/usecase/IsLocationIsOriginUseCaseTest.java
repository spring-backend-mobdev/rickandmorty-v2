package cl.mobdev.challenge.usecase;

import cl.mobdev.challenge.gateway.model.ApiCharacter;
import cl.mobdev.challenge.gateway.model.ApiLocation;
import cl.mobdev.challenge.gateway.model.ApiOrigin;
import cl.mobdev.challenge.usecase.exception.LocationException;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class IsLocationIsOriginUseCaseTest {

    private IsLocationIsOriginUseCase isLocationIsOriginUseCase;
    private ApiCharacter character;
    private ApiLocation location;
    private ApiOrigin  origin;

    @BeforeEach
    void setUp() {
        this.isLocationIsOriginUseCase = new IsLocationIsOriginUseCase();
        character = new ApiCharacter();
        location = new ApiLocation();
        origin = new ApiOrigin();
    }

    @Test
    @DisplayName("Should return true if location equals origin")
    void should_return_true_if_location_equals_origin() {
        boolean expected = true;
        //GIVEN
        location.setName("Earth");
        origin.setName("Earth");
        character.setLocation(location);
        character.setOrigin(origin);
        //WHEN
        boolean actual = isLocationIsOriginUseCase.execute(character);
        //THEN
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should_return_false_if_location_different_origin")
    void should_return_false_if_location_different_origin() {
        boolean expected = false;
        //GIVEN
        location.setName("Saturn");
        origin.setName("Venus");
        character.setLocation(location);
        character.setOrigin(origin);
        //WHEN
        boolean actual = isLocationIsOriginUseCase.execute(character);
        //THEN
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Should throw exception if origin unknown")
    void should_throw_exception_if_origin_unknown() {
        String expected = "The origin of the character is unknown.";
        LocationException locationException =
                new LocationException("The origin of the character is unknown.");
        //GIVEN
        origin.setName("unknown");
        location.setName("Venus");
        character.setOrigin(origin);
        character.setLocation(location);
        //WHEN
        LocationException thrown = assertThrows(LocationException.class,
                () -> this.isLocationIsOriginUseCase.execute(character));
        //THEN
        assertEquals(expected, thrown.getMessage());
    }

    @Test
    @DisplayName("Should throw exception if location unknown")
    void should_throw_exception_if_location_unknown() {
        String expected = "The location of the character is unknown.";
        LocationException locationException =
                new LocationException("The location of the character is unknown.");
        //GIVEN
        origin.setName("Moon");
        location.setName("unknown");
        character.setOrigin(origin);
        character.setLocation(location);
        //WHEN
        LocationException thrown = assertThrows(LocationException.class,
                () -> this.isLocationIsOriginUseCase.execute(character));
        //THEN
        assertEquals(expected, thrown.getMessage());
    }

    @Test
    @DisplayName("Should throw exception if location and origin unknown")
    void should_throw_exception_if_location_and_origin_unknown() {
        String expected = "The location and origin of the character is unknown.";
        LocationException locationException =
                new LocationException("The location and origin of the character is unknown.");
        //GIVEN
        origin.setName("unknown");
        location.setName("unknown");
        character.setOrigin(origin);
        character.setLocation(location);
        //WHEN
        LocationException thrown = assertThrows(LocationException.class,
                () -> this.isLocationIsOriginUseCase.execute(character));
        //THEN
        assertEquals(expected, thrown.getMessage());
    }

    @Test
    @DisplayName("should_throw_exception_if_location_null")
    void should_throw_exception_if_location_null() {
        String expected = "Location or Origin is Null";

        //GIVEN
        origin.setName("unknown");
        character.setOrigin(origin);
        character.setLocation(null);

        //WHEN
        LocationException thrown = assertThrows(LocationException.class,
                () -> this.isLocationIsOriginUseCase.execute(character));

        //THEN
        assertEquals(expected, thrown.getMessage());
    }

    @Test
    @DisplayName("should_throw_exception_if_origin_null")
    void should_throw_exception_if_origin_null() {
        String expected = "Location or Origin is Null";

        //GIVEN
        location.setName("Earth");
        character.setLocation(location);
        character.setOrigin(null);

        //WHEN
        LocationException thrown = assertThrows(LocationException.class,
                () -> this.isLocationIsOriginUseCase.execute(character));

        //THEN
        assertEquals(expected, thrown.getMessage());
    }
}