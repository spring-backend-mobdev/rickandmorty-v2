package cl.mobdev.challenge.controller;

import cl.mobdev.challenge.domain.Character;
import cl.mobdev.challenge.usecase.GetCharacterUnknownUseCase;
import cl.mobdev.challenge.usecase.GetCharacterUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(HomeController.class)
@ExtendWith(MockitoExtension.class)
class HomeControllerTest {

    @InjectMocks
    private HomeController homeController;

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private GetCharacterUseCase getCharacterUseCase;  // dependecies of Controller

    @Mock
    private GetCharacterUnknownUseCase getCharacterUnknownUseCase;

    @BeforeEach
    void setUp() {
       //homeController = new HomeController(getCharacterUnknownUseCase.execute()); // va a crear una nueva instancia antes de cada test
    }

    @Test
    @DisplayName("")
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
    @DisplayName("Return Controller")
    void return_controller() {


        // GIVEN


        // THEN


        // WHEN




    }
}