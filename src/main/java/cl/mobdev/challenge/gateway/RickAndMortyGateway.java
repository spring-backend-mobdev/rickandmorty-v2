package cl.mobdev.challenge.gateway;

import cl.mobdev.challenge.gateway.mapper.CharacterToCharacterResponseMapper;
import cl.mobdev.challenge.gateway.model.ApiCharacter;
import cl.mobdev.challenge.gateway.model.ApiLocation;
import cl.mobdev.challenge.domain.Character;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RickAndMortyGateway {

    private final RestTemplate restTemplate;
    private final String apiUrl;
    private final CharacterToCharacterResponseMapper characterResponseMapper;

    public RickAndMortyGateway(RestTemplate restTemplate,
                               @Value("${apiUrl}") String apiUrl,
                               CharacterToCharacterResponseMapper characterResponseMapper) {
        this.restTemplate = restTemplate;
        this.apiUrl = apiUrl;
        this.characterResponseMapper = characterResponseMapper;
    }

    public Character getApiCharacter(String id) {
        Character character;
        ResponseEntity<ApiCharacter> apiCharacter = restTemplate
                .getForEntity(apiUrl + id, ApiCharacter.class);

        ResponseEntity<ApiLocation> apiLocation = getApiLocation(apiCharacter.getBody());
        character = characterResponseMapper
                .mapper(apiCharacter.getBody(), apiLocation.getBody());
        return character;
    }


    private ResponseEntity<ApiLocation> getApiLocation(ApiCharacter apiCharacter) {
        if (null != apiCharacter.getOrigin() && !"".equals(apiCharacter.getOrigin())) {
            return restTemplate.getForEntity(apiCharacter.getOrigin().getUrl(), ApiLocation.class);
        }
        return null;
    }
}