package cl.mobdev.challenge.usecase;

import cl.mobdev.challenge.domain.Character;
import cl.mobdev.challenge.gateway.HumanCharacterGateway;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class IsHumanCharacterUseCaseTest {

    @InjectMocks
    private IsHumanCharacterUseCase isHumanCharacterUseCase;

    @Mock
    private HumanCharacterGateway humanCharacterGateway;

    @BeforeEach
    void setUp() {
        this.isHumanCharacterUseCase = new IsHumanCharacterUseCase(humanCharacterGateway);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Should return true if character is human")
    void should_return_true_if_character_is_human() {
        boolean expected = true;
        //GIVEN
        String  testId = "1";
        Character characterMock = new Character();
        characterMock.setId(1);
        characterMock.setName("Rick Sanchez");
        characterMock.setSpecies("Human");

        when(humanCharacterGateway
                .findCharacter(testId))
                .thenReturn(characterMock);

        //WHEN
        boolean real = isHumanCharacterUseCase.execute(testId);
        //THEN
        assertEquals(expected, real);
    }

    @Test
    @DisplayName("Should return false if character is Not human")
    void should_return_false_if_character_isNot_human() {
        boolean expected = false;
        //GIVEN
        String  testId = "1";
        Character characterMock = new Character();
        characterMock.setId(1);
        characterMock.setName("Rick Sanchez");
        characterMock.setSpecies("Robot");

        when(humanCharacterGateway
                .findCharacter(testId))
                .thenReturn(characterMock);
        //WHEN
        boolean real = isHumanCharacterUseCase.execute(testId);
        //THEN
        assertEquals(expected, real);
    }

    @Test
    @DisplayName("Should return false if character is null")
    void should_return_false_if_character_is_null() {
        boolean expected = false;
        //GIVEN
        String  testId = "12";
        //Character characterMock = null;
        when(humanCharacterGateway
                .findCharacter(testId))
                .thenReturn(null);
        //WHEN
        boolean real = isHumanCharacterUseCase.execute(testId);
        //THEN
        assertEquals(expected, real);
    }
}









