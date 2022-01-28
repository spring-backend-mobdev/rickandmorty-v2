package cl.mobdev.challenge.controller;

import cl.mobdev.challenge.usecase.GetCharacterUseCase;
import cl.mobdev.challenge.domain.Character;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private final GetCharacterUseCase getCharacterUseCase;

    public HomeController(GetCharacterUseCase getCharacterUseCase) {
        this.getCharacterUseCase = getCharacterUseCase;
    }

    @GetMapping("character/{id}")
    public Character getExternalApi(@PathVariable String id){
        return getCharacterUseCase.execute(id);
    }
}
// Test
// 1.- Id no encontrado (fuera de rango) desde el 1 al 826 -> id_not_found (No aplica)
// 2.- Verificar staus 200 si l
// 3.-
// 4.-
// 5.-
// 6.-