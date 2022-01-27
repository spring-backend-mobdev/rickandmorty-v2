package cl.mobdev.challenge.controller;

import cl.mobdev.challenge.gateway.mapper.CharacterToCharacterResponseMapper;
import cl.mobdev.challenge.usecase.GetCharacterUseCase;
import cl.mobdev.challenge.domain.Character;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

        private final CharacterToCharacterResponseMapper characterResponseMapper = new CharacterToCharacterResponseMapper();
        private final GetCharacterUseCase getCharacterUseCase;

    public ApiController(GetCharacterUseCase getCharacterUseCase) {
        this.getCharacterUseCase = getCharacterUseCase;
    }

    @GetMapping("character/{id}")
    public Character getExternalApi(@PathVariable String id){
        return getCharacterUseCase.execute(id);
    }


}
