package cl.mobdev.challenge.controller;

import cl.mobdev.challenge.configuration.GetCharacter;
import cl.mobdev.challenge.domain.Character;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HomeControllerTest {

    @InjectMocks
    private HomeController homeController;

    @Mock
    private GetCharacter getCharacter;

    @BeforeEach
    void setUp() {
        this.homeController = new HomeController(getCharacter);
    }

    @Test
    @DisplayName("")
    void should_verify_call_usecase() {
        int invokeUseCaseExpected = 1;
        Character characterMock = new Character();
        characterMock.setName("Rick");
        characterMock.setId(1);
        characterMock.setGender("Female");
        String idMock = "1";

        // GIVEN
        when(getCharacter.execute(idMock))
                .thenReturn(characterMock);

        // THEN
        homeController.getExternalApi(idMock);

        // WHEN
        verify(getCharacter, times(invokeUseCaseExpected))
                .execute(idMock);
    }
}