package cl.mobdev.challenge.usecase;

import cl.mobdev.challenge.configuration.GetCharacter;
import cl.mobdev.challenge.domain.Character;
import cl.mobdev.challenge.gateway.RickAndMortyGateway;
import cl.mobdev.challenge.usecase.exception.DeadException;
import org.springframework.stereotype.Component;

@Component
public class GetCharacterUseCase implements GetCharacter {

    private final RickAndMortyGateway rickAndMortyGateway;

    public GetCharacterUseCase(RickAndMortyGateway rickAndMortyGateway) {
        this.rickAndMortyGateway = rickAndMortyGateway;
    }

    public Character execute(String id){
        Character character = rickAndMortyGateway.getApiCharacter(id);
        if ("Dead".equals(character.getStatus())){
            throw new DeadException("Character is dead!!!!");
        }
        return rickAndMortyGateway.getApiCharacter(id);
    }
}