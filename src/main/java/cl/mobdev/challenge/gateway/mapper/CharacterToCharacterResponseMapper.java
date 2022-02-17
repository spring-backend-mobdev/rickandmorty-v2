package cl.mobdev.challenge.gateway.mapper;

import cl.mobdev.challenge.domain.Location;
import cl.mobdev.challenge.domain.Character;
import cl.mobdev.challenge.gateway.model.ApiCharacter;
import cl.mobdev.challenge.gateway.model.ApiLocation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CharacterToCharacterResponseMapper {

    public Character mapper(ApiCharacter apiCharacter, ApiLocation apiLocation){
        Character characterResponse = new Character();
        characterResponse.setId(apiCharacter.getId());
        characterResponse.setName(apiCharacter.getName());
        characterResponse.setStatus(apiCharacter.getStatus());
        characterResponse.setGender(apiCharacter.getGender());
        characterResponse.setSpecies(apiCharacter.getSpecies());
        characterResponse.setType(apiCharacter.getType());
        characterResponse.setEpisode_count(apiCharacter.getEpisode().size());

        characterResponse.setOrigin(convertLocationToNull(apiLocation));
        return characterResponse;
    }

    private Location convertLocationToNull(ApiLocation apiLocation) {
        Location locationResponse = new Location();

        if (null == apiLocation || "".equals(apiLocation.getUrl())) {
            locationResponse.setUrl("unknown");
            locationResponse.setName("unknown");
            locationResponse.setDimension("unknown");
            locationResponse.setResidents(new ArrayList<String>());
            return locationResponse;
        }

        locationResponse.setUrl(apiLocation.getUrl());
        locationResponse.setName(apiLocation.getName());
        locationResponse.setDimension(apiLocation.getDimension());
        locationResponse.setResidents(apiLocation.getResidents());
        return locationResponse;
    }
}