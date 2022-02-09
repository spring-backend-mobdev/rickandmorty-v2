package cl.mobdev.challenge.usecase;

import cl.mobdev.challenge.domain.Character;
import cl.mobdev.challenge.gateway.HumanCharacterGateway;
import cl.mobdev.challenge.usecase.exception.GenderException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GetFemaleCharacterUseCaseTest {

    private Character characterMock;
    private Character characterExpected;

    @InjectMocks
    private GetFemaleCharacterUseCase useCase;

    @Mock
    private HumanCharacterGateway humanGateway;

    @BeforeEach
    void setUp() {
        characterMock = new Character();
        characterExpected = new Character();
        this.useCase = new GetFemaleCharacterUseCase(humanGateway);
    }

    @AfterEach
    void tearDown() {
        System.out.println("End Testing.");
    }

    @Test
    void should_return_character_when_gender_is_female() {
        characterExpected.setGender("Female");
        //GIVEN
        String testId = "3";
        characterMock.setId(3);
        characterMock.setName("Summer Smith");
        characterMock.setGender("Female");

        when(humanGateway
                .findCharacter(testId))
                .thenReturn(characterMock);

        //WHEN
        Character character = this.useCase.execute("3");

        //THEN
        assertEquals(characterExpected.getGender(), character.getGender());
    }

    @Test
    void should_throw_exception_when_gender_isNot_female() {
        String expected = "Not Female";

        //GIVEN
        String testId = "1";
        characterMock.setId(1);
        characterMock.setName("Rick Sanchez");
        characterMock.setGender("male");

        when(humanGateway
                .findCharacter(testId))
                .thenReturn(characterMock);

        //WHEN
        GenderException real = assertThrows(GenderException.class,
                () -> this.useCase.execute("1"));

        //THEN
        assertEquals(expected, real.getMessage());
    }


    @Test
    @DisplayName("should_throw_exception_when_gender_is_null")
    void should_throw_exception_when_gender_is_null() {
        String expected = "Gender is null";

        //GIVEN
        String testId = "2";
        characterMock.setId(2);
        characterMock.setName("Morty");
        characterMock.setGender(null);

        when(humanGateway
                .findCharacter(testId))
                .thenReturn(characterMock);

        //WHEN
        GenderException real = assertThrows(
                GenderException.class, () -> this.useCase.execute("2")
        );

        //THEN
        assertEquals(expected, real.getMessage());
        
    }
}