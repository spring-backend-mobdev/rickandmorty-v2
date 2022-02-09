package cl.mobdev.challenge.gateway;
import cl.mobdev.challenge.domain.Location;
import cl.mobdev.challenge.gateway.mapper.CharacterToCharacterResponseMapper;
import cl.mobdev.challenge.gateway.model.ApiCharacter;
import cl.mobdev.challenge.domain.Character;
import cl.mobdev.challenge.gateway.model.ApiLocation;
import cl.mobdev.challenge.gateway.model.ApiOrigin;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RickAndMortyGatewayTest {

    private String apiUrl = "http://some-url";
    private ApiCharacter apiCharacter;
    private ApiLocation apiLocation;

    @InjectMocks
    private RickAndMortyGateway rickAndMortyGateway;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private CharacterToCharacterResponseMapper characterResponseMapper;


    @BeforeEach
    void setUp(){
        this.rickAndMortyGateway = new RickAndMortyGateway(restTemplate,
                apiUrl,
                characterResponseMapper);

        apiCharacter = new ApiCharacter();
        apiLocation = new ApiLocation();
    }

    @Test
    @MockitoSettings(strictness = Strictness.WARN)
    void should_return_character_when_call_external_api() {

        Character expected = new Character();
        Location location = new Location();
        expected.setOrigin(location);

        ApiCharacter apiCharacter = new ApiCharacter();
        ApiLocation apiLocation = new ApiLocation();
        ApiOrigin apiOrigin = new ApiOrigin();

        String urlLocationMock = "http//some-location";
        apiOrigin.setUrl(urlLocationMock);
        apiCharacter.setOrigin(apiOrigin);

        apiCharacter.setId(1);
        apiCharacter.setName("Rick Sanchez");
        apiLocation.setName("Earth");
        apiLocation.setUrl(urlLocationMock);

        // GIVEN
        String idMock = "1";

        when(restTemplate
                .getForEntity(apiUrl + idMock, ApiCharacter.class))
                .thenReturn(new ResponseEntity(apiCharacter, HttpStatus.OK));

        when(restTemplate
                .getForEntity(urlLocationMock, ApiLocation.class))
                .thenReturn(new ResponseEntity(apiLocation, HttpStatus.OK));

        when(characterResponseMapper.mapper(apiCharacter, apiLocation))
                .thenReturn(expected);

        // WHEN
        Character character = rickAndMortyGateway.getApiCharacter(idMock);

        // THEN
        assertEquals(expected,  character);
    }

    @Test
    void should_return_mocked_object_when_call_get_Character() {
        Character character = new Character();
        character.setId(1);
        character.setName("Rick Sanchez");
        character.setGender("Male");

        when(restTemplate
                .getForEntity("http://localhost:9000/character/1", Character.class))
                .thenReturn(new ResponseEntity(character, HttpStatus.OK));

            //Character character1 = ;

            assertEquals(character, true);
    }

    @Test
    void name3() {

        // GIVEN

        // WHEN

        // THEN


    }

    @Test
    void should_return_() {

        // GIVEN

        // WHEN

        // THEN

    }
}

// Test
// 1.- Status 200
// 3.-
// 4.-