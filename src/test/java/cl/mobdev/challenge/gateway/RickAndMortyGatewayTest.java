package cl.mobdev.challenge.gateway;
import cl.mobdev.challenge.domain.Location;
import cl.mobdev.challenge.gateway.mapper.CharacterToCharacterResponseMapper;
import cl.mobdev.challenge.gateway.model.ApiCharacter;
import cl.mobdev.challenge.domain.Character;
import cl.mobdev.challenge.gateway.model.ApiLocation;
import cl.mobdev.challenge.gateway.model.ApiOrigin;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
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

    private String apiUrl = "http://some-url/";
    private ApiCharacter characterMock;
    private ApiLocation apiLocation;
    private Character expected;
    private ApiOrigin apiOriginMock;
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
        characterMock = new ApiCharacter();
        apiLocation = new ApiLocation();
        expected = new Character();
        apiOriginMock = new ApiOrigin();
        location = new Location();
    }

    @Test
    @MockitoSettings(strictness = Strictness.WARN)
    @DisplayName("Should return character when call external api")
    void should_call_external_api_twice() {
        final int numberOfInvocationsOfRestTemplateExpected = 2;
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
                .getForEntity(anyString(), any());   // anyString != eq("http//some-url/1")
    }

    @Test
    @MockitoSettings(strictness = Strictness.WARN)
    @DisplayName("Should return character when call mapper")
    void should_call_mapper_once() {
        expected.setOrigin(location);
        final int numberOfInvocationsOfMapperExpected = 1;

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
                .mapper(characterMock, apiLocation);               // Cuantas veces voy a llamar al mapper = 1 vez

    }

    @Test
    @MockitoSettings(strictness = Strictness.WARN)
    void should_return_origin_unknown_when_url_is_empty() {

        // Practice TDD
        String urlLocationMock = "";
        String expected = "unknown";
        characterMock.setOrigin(null);
        String idMock  = "";
        apiOriginMock.setUrl(urlLocationMock);
        apiOriginMock.setUrl("");

        //GIVEN
        when(restTemplate.getForEntity(characterMock + idMock, ApiCharacter.class))
                .thenReturn(new ResponseEntity(characterMock, HttpStatus.OK));

        // WHEN
        Character character = rickAndMortyGateway.getApiCharacter(idMock);

        // THEN
        assertEquals(expected, character.getOrigin().getName());

        ArgumentCaptor<ApiCharacter> argument = ArgumentCaptor.forClass(ApiCharacter.class);
    }
}