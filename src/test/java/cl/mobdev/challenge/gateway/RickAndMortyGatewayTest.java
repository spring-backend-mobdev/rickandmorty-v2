package cl.mobdev.challenge.gateway;

import cl.mobdev.challenge.gateway.mapper.CharacterToCharacterResponseMapper;
import cl.mobdev.challenge.gateway.model.ApiCharacter;
import cl.mobdev.challenge.domain.Character;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RickAndMortyGatewayTest {

    @InjectMocks
    private RickAndMortyGateway rickAndMortyGateway;

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private CharacterToCharacterResponseMapper characterResponseMapper;


    @BeforeEach
    void setUp(){
        ReflectionTestUtils.setField(rickAndMortyGateway, "apiUrl", "https://rickandmortyapi.com/api/character/");
        this.rickAndMortyGateway = new RickAndMortyGateway(restTemplate, "apiUrl", characterResponseMapper);
    }

    @Test
    void name() {
        ApiCharacter apiCharacter = new ApiCharacter();
        apiCharacter.setId(1);

        // GIVEN
        String idMock = "1";
        Mockito
                .when(restTemplate.getForEntity("apiUrl" + idMock, ApiCharacter.class))
                .thenReturn(new ResponseEntity(apiCharacter, HttpStatus.OK));

        // WHEN
        Character character = rickAndMortyGateway.getApiCharacter(idMock);

        // THEN
        assertEquals(apiCharacter, character);

    }

    @Test
    void verify_UrlOrigin_the_ApiCharacter_is_empty() {

        // GIVEN

        // WHEN

        // THEN

    }

    @Test
    void verify_UrlOrigin_the_ApiCharacter_has_data() {

        // GIVEN

        // WHEN

        // THEN

    }

    @Test
    void compare_to_apiRM_is_equals_apiApplicationProperties() {

        String characterUrl;

        // GIVEN

        // WHEN

        // THEN

    }


    @Test
    void name2() {

        // GIVEN

        // WHEN

        // THEN

    }

    @Test
    void name3() {

        // GIVEN

        // WHEN

        // THEN

    }

    @Test
    void name4() {

        // GIVEN

        // WHEN

        // THEN

    }

    @Test
    void name6() {

        // GIVEN

        // WHEN

        // THEN

    }

    @Test
    void name5() {

        // GIVEN

        // WHEN

        // THEN

    }
}

// Test
// 1.- Comparar que la api llamada en application.properties es la misma que la api R&M
// 2.- If - Si la URL de Origin de apiCharacter es vacía.
// 3.- If - Si la URL de Origin de apiCharacter está con datos.
// 4.-