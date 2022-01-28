package cl.mobdev.challenge.controller;
import static org.junit.jupiter.api.Assertions.assertEquals;
import cl.mobdev.challenge.domain.Character;
import cl.mobdev.challenge.usecase.GetCharacterUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
@ExtendWith(MockitoExtension.class)
class HomeControllerTest {
@InjectMocks
private HomeController homeController; //la clase a testear
@Mock
private GetCharacterUseCase getCharacterUseCase; //dependecias
@BeforeEach
void setUp() {
homeController = new HomeController(getCharacterUseCase);//va a crear una nueva instancia antes de cada test
}
@Test
void should_return_status_200_when_use_useCase() {
int statusExpected = 200;
//GIVEN
Mockito.when(getCharacterUseCase.execute("1"))
.thenReturn(new Character());
//WHEN
String idMock = "1";
ResponseEntity<Character> response = homeController.getCharacter(idMock);
//THEN
assertEquals(statusExpected, response.getStatusCodeValue());
}
}