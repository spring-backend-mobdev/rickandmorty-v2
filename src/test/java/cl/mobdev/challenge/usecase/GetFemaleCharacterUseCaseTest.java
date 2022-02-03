package cl.mobdev.challenge.usecase;

import cl.mobdev.challenge.domain.Character;
import cl.mobdev.challenge.domain.Location;
import cl.mobdev.challenge.gateway.HumanCharacterGateway;
import cl.mobdev.challenge.usecase.exception.GenderException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GetFemaleCharacterUseCaseTest {

    @InjectMocks
    private GetFemaleCharacterUseCase useCase;

    @Mock
    private HumanCharacterGateway humanGateway;
    
    @BeforeEach
    void setUp() {
        this.useCase = new GetFemaleCharacterUseCase(humanGateway);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void should_return_true_when_character_when_gender_is_female() {
        boolean expected = true;
        Character character = new Character();

        //GIVEN
        String testId = "3";
        Character characterMock = new Character();
        characterMock.setId(3);
        characterMock.setName("Summer Smith");
        characterMock.getGender("Female");

        character.setGender("Female");

        Mockito
                .when(humanGateway.findCharacter(testId))
                .thenReturn(characterMock);


        //WHEN
        characterMock = this.useCase.execute("3");

        //THEN
        assertEquals(expected, character);
    }

    @Test
    void should_throw_exception_when_gender_isNot_female() {
        String expected = "male";

        //GIVEN
        String testId = "1";
        Character caharacterMock = new Character();
        caharacterMock.setId(1);
        caharacterMock.setName("Rick Sanchez");
        caharacterMock.getGender("male");

        Mockito
                .when(humanGateway.findCharacter(testId))
                .thenReturn(caharacterMock);
        //WHEN
        GenderException real = assertThrows(GenderException.class,
                () -> this.useCase.execute("1"));

        //THEN
        assertEquals(expected, real);
    }


    @Test
    void should_throw_exception_when_gender_is_null() {


        //GIVEN


        //WHEN


        //THEN
        
        
    }
}