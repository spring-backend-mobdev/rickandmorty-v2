package cl.mobdev.challenge.gateway.mapper;

import cl.mobdev.challenge.domain.Location;
import cl.mobdev.challenge.domain.Character;
import cl.mobdev.challenge.gateway.model.ApiCharacter;
import cl.mobdev.challenge.gateway.model.ApiLocation;
import org.springframework.stereotype.Component;

@Component
public class CharacterToCharacterResponseMapper {

    public Character mapper(ApiCharacter apiCharacter, ApiLocation apiLocation){
        Character characterResponse = new Character();
        characterResponse.setId(apiCharacter.getId());
        characterResponse.setName(apiCharacter.getName());
        characterResponse.setStatus(apiCharacter.getStatus());
        characterResponse.setSpecies(apiCharacter.getSpecies());
        characterResponse.setType(apiCharacter.getType());
        characterResponse.setEpisode_count(apiCharacter.getEpisode().size());

        Location locationResponse = new Location();
        locationResponse.setUrl(apiLocation.getUrl());
        locationResponse.setName(apiLocation.getName());
        locationResponse.setDimension(apiLocation.getDimension());
        locationResponse.setResidents(apiLocation.getResidents());

        characterResponse.setOrigin(locationResponse);

        return characterResponse;
    }
}