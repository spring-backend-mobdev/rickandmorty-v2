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

@ExtendWith(MockitoExtension.class)
class RickAndMortyGatewayTest {

    private String apiUrl = "http://some-url/";
    private ApiLocation apiLocation;
    private Location location;

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
        apiLocation = new ApiLocation();
        location = new Location();
    }

    @Test
    @MockitoSettings(strictness = Strictness.WARN)
    @DisplayName("Should call external api twice")
    void should_call_external_api_twice() {
        final int numberOfInvocationsOfRestTemplateExpected = 2;
        ApiOrigin apiOriginMock = new ApiOrigin();
        ApiCharacter characterMock = new ApiCharacter();
        Character expected = new Character();
        String urlLocationMock = "http//some-location-resttemplate";

        apiOriginMock.setUrl(urlLocationMock);
        characterMock.setOrigin(apiOriginMock);
        characterMock.setId(1);
        characterMock.setName("Rick Sanchez");
        apiLocation.setName("Earth");
        apiLocation.setUrl(urlLocationMock);
        expected.setOrigin(location);

        // GIVEN
        String idMock = "1";
        when(restTemplate
                .getForEntity(apiUrl + idMock, ApiCharacter.class))
                .thenReturn(new ResponseEntity(characterMock, HttpStatus.OK));

        when(restTemplate
                .getForEntity(urlLocationMock, ApiLocation.class))
                .thenReturn(new ResponseEntity(apiLocation, HttpStatus.OK));

        // WHEN
        Character character = rickAndMortyGateway.getApiCharacter(idMock);

        // THEN
        verify(restTemplate, times(numberOfInvocationsOfRestTemplateExpected))
                .getForEntity(anyString(), any());
    }

    @Test
    @MockitoSettings(strictness = Strictness.WARN)
    @DisplayName("Should call mapper once")
    void should_call_mapper_once() {
        final int numberOfInvocationsOfMapperExpected = 1;
        Character expected = new Character();
        ApiOrigin apiOriginMock = new ApiOrigin();
        ApiCharacter characterMock = new ApiCharacter();
        expected.setOrigin(location);

        String urlLocationMock = "http://some-location-mapper";
        apiOriginMock.setUrl(urlLocationMock);
        characterMock.setOrigin(apiOriginMock);
        characterMock.setId(5);
        characterMock.setName("Jerry Smith");
        characterMock.setGender("Male");
        apiLocation.setName("Earth");
        apiLocation.setUrl(urlLocationMock);

        // GIVEN
        String idMock = "5";
        when(restTemplate
                .getForEntity(apiUrl + idMock, ApiCharacter.class))
                .thenReturn(new ResponseEntity(characterMock, HttpStatus.OK));

        when(restTemplate
                .getForEntity(urlLocationMock, ApiLocation.class))
                .thenReturn(new ResponseEntity(apiLocation, HttpStatus.OK));

        // WHEN
        rickAndMortyGateway.getApiCharacter(idMock);

        // THEN
        verify(characterResponseMapper, times(numberOfInvocationsOfMapperExpected))
                .mapper(characterMock, apiLocation);
    }

    @Test
    @DisplayName("Should call external api once when character url location is empty")
    void should_call_external_api_once_when_character_url_location_is_empty() {
        int numberOfInvocationsOfRestTemplateExpected = 1;
        ApiCharacter apiCharacter = new ApiCharacter();
        String id = "1";
        Character characterMock = new Character();
        characterMock.setId(Integer.parseInt(id));
        characterMock.setName("Rick");
        Location locationOrigin = new Location();
        locationOrigin.setName("Mockito");
        locationOrigin.setUrl("Unknown");
        characterMock.setOrigin(locationOrigin);

        //GIVEN
        when(restTemplate.getForEntity(apiUrl + id, ApiCharacter.class))
                .thenReturn(new ResponseEntity(apiCharacter, HttpStatus.OK));

        when(characterResponseMapper.mapper(apiCharacter, null))
                .thenReturn(characterMock);

        //WHEN
        rickAndMortyGateway.getApiCharacter(id);

        //THEN
        verify(restTemplate, times(numberOfInvocationsOfRestTemplateExpected))
                .getForEntity(anyString(), any());
    }
}