package cl.mobdev.challenge.controller;

import cl.mobdev.challenge.domain.Character;
import cl.mobdev.challenge.usecase.GetCharacterUnknownUseCase;
import cl.mobdev.challenge.usecase.GetCharacterUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class HomeControllerTest {

    @InjectMocks
    private HomeController homeController;  // La clase a testear

    @Mock
    private GetCharacterUseCase getCharacterUseCase;  // dependecies

    @Mock
    private GetCharacterUnknownUseCase getCharacterUnknownUseCase;

    @BeforeEach
    void setUp() {
       //  homeController = new HomeController(getCharacterUseCase); // va a crear una nueva instancia antes de cada test
    }

    @Test
    void should_return_status_200_when_use_useCase() {
        int statusExpect = 200;

        //GIVEN
        Mockito.when(getCharacterUseCase.execute("1"))
                .thenReturn(new Character());

        //WHEN
        String idMock = "1";
        Character response = homeController.getExternalApi(idMock);

        //THEN
        assertNotEquals(statusExpect, response.getStatusCodeValue(getCharacterUnknownUseCase));

    }

    @Test
    void id_not_found() {

    }

    @Test
    void name3() {

    }

    @Test
    void name4() {

    }

    @Test
    void name6() {

    }

    @Test
    void name5() {

    }

}