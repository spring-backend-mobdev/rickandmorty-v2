package cl.mobdev.challenge.usecase;

import cl.mobdev.challenge.gateway.RickAndMortyGateway;
import cl.mobdev.challenge.usecase.exception.DeadException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import cl.mobdev.challenge.domain.Character;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GetCharacterUseCaseTest {

    @InjectMocks
    private GetCharacterUseCase getCharacterUseCase;

    @Mock
    private RickAndMortyGateway rickAndMortyGateway;

    @BeforeEach
    void  setUp() {
        this.getCharacterUseCase = new GetCharacterUseCase(rickAndMortyGateway);
    }

    @Test
    void should_return_Character_when_status_is_Alive(){
        Character characterExpected = new Character();
        characterExpected.setStatus("Alive");

        //GIVEN
        Character characterMock = new Character();
        characterMock.setStatus("Alive");
        Mockito.when(rickAndMortyGateway.getApiCharacter("1"))
                .thenReturn(characterMock);

        //WHEN
        Character character = this.getCharacterUseCase.execute("1");

        //THEN
        assertEquals(characterExpected.getStatus(), character.getStatus());
    }

    @Test
    void should_throw_DeadException_when_character_status_is_Dead() {
        String exceptionMessageExpected = "Character is dead!!!!";

        //GIVEN
        Character characterMock = new Character();
        characterMock.setStatus("Dead");
        Mockito.when(rickAndMortyGateway.getApiCharacter("1"))
                .thenReturn(characterMock);
        //WHEN
        DeadException thrown = assertThrows(
                DeadException.class,
                () -> this.getCharacterUseCase.execute("1")
        );

        //THEN
        assertEquals(exceptionMessageExpected, thrown.getMessage());
    }

    @Test
    void should_return_Character_when_status_is_Unknown(){

        //GIVEN

        //WHEN

        //THEN
    }

    @Test
    void name() {

        // GIVEN

        //WHEN

        //THEN
    }

    @Test
    void name2() {

    }

    @Test
    void name3() {

        // GIVEN

        //WHEN

        //THEN
    }

    @Test
    void name4() {

        // GIVEN

        //WHEN

        //THEN
    }

    @Test
    void name6() {

        // GIVEN

        //WHEN

        //THEN
    }

    @Test
    void name5() {

        // GIVEN

        //WHEN

        //THEN
    }
}