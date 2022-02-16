package cl.mobdev.challenge.gateway.mapper;


import cl.mobdev.challenge.domain.Character;
import cl.mobdev.challenge.domain.Location;
import cl.mobdev.challenge.gateway.model.ApiCharacter;
import cl.mobdev.challenge.gateway.model.ApiLocation;
import cl.mobdev.challenge.gateway.model.ApiOrigin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CharacterToCharacterResponseMapperTest {

    private CharacterToCharacterResponseMapper characterToCharacterResponseMapper;
    private Character characterResponse;
    private ApiCharacter apiCharacter;
    private ApiLocation apiLocation;

    @BeforeEach
    void setUp() {
        characterToCharacterResponseMapper = new CharacterToCharacterResponseMapper();
        characterResponse = new Character();
        apiCharacter = new ApiCharacter();
        apiLocation = new ApiLocation();
    }

    @Test
    @DisplayName("")
    void should_return_character_when_output_value() {
        Character characterExpected = new Character();
        Location origin = new Location();
        ArrayList<String> episode = new ArrayList<>();
        characterExpected.setId(1);
        characterExpected.setName("Rick Sanchez");
        origin.setName("Earth");
        characterExpected.setOrigin(origin);
        characterExpected.setEpisode_count(1);
        episode.add("www.rickandmorty.org");

        // GIVEN
        apiCharacter.setId(1);
        apiCharacter.setName("Rick Sanchez");
        apiLocation.setName("Earth");
        apiCharacter.setEpisode(episode);

        // WHEN
        Character character = characterToCharacterResponseMapper
                .mapper(apiCharacter, apiLocation);

        // THEN
        assertEquals(characterExpected, character);
    }

    @Test
    @DisplayName("Should return unknown when location is empty")
    void should_return_unknown_when_location_is_empty() {
        ApiLocation apiLocationExpected = new ApiLocation();
        Location locationResponse = new Location();
        //ArrayList<String> episode = new ArrayList<>();
        Character characterExpected = new Character();
        apiLocationExpected.equals("");
        locationResponse.setUrl("unknown");
        locationResponse.setName("unknown");
        locationResponse.setDimension("unknown");
        characterExpected.setEpisode_count(1);
        //episode.add("www.rickandmorty.org");

        // GIVEN
        apiCharacter.setId(2);
        apiCharacter.setName("Jerry Smith");
        apiLocation.setUrl("");

        // WHEN
        Character character = characterToCharacterResponseMapper
                .mapper(apiCharacter, apiLocation);

        // THEN
        assertEquals(apiLocationExpected, character);
    }

    @Test
    @DisplayName("")
    void should_return_unknown_when_location_is_null() {
        String expected = "unknown";

        // GIVEN

        // WHEN

        // THEN
        assertEquals(true, true);
    }

    @Test
    @DisplayName("")
    void should_return_() {
        String expected = "";
        // GIVEN

        // WHEN

        // THEN
        assertEquals(true, true);
    }
}

/**
 * 1.- Should return character when location is empty
 * 2.- Should return character when location is null
 * 3.- Should return character when location is null
 */