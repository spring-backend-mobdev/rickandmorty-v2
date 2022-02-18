package cl.mobdev.challenge.controller;

import cl.mobdev.challenge.configuration.GetCharacter;
import cl.mobdev.challenge.domain.Character;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private final GetCharacter getCharacter;

    public HomeController(GetCharacter getCharacter) {
        this.getCharacter = getCharacter;
    }

    @GetMapping("character/{id}")
    public Character getExternalApi(@PathVariable String id) {
        return getCharacter.execute(id);
    }
}