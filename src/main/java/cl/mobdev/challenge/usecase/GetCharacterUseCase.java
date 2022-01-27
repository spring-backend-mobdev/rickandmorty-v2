package cl.mobdev.challenge.usecase;

import cl.mobdev.challenge.domain.Character;
import cl.mobdev.challenge.gateway.RickAndMortyGateway;
import org.springframework.stereotype.Component;

@Component
public class GetCharacterUseCase {

    private final RickAndMortyGateway rickAndMortyGateway;

    public GetCharacterUseCase(RickAndMortyGateway rickAndMortyGateway) {
        this.rickAndMortyGateway = rickAndMortyGateway;
    }

    public Character execute(String id){
        Character character = rickAndMortyGateway.getApiCharacter(id);
        if ("Dead".equals(character.getStatus())){
            throw new DeadException("El Personaje está muerto !!!!");
        }
        return rickAndMortyGateway.getApiCharacter(id);
    }
}
// Test
// 1.- Debe devolver un Character cuando el Status es Alive
// 2.- Debe devolver un DeadException cuando el Status es Dead
// 3.- Debe devolver un UnknownException cuando el Status es Unknown
// 4.-
// 5.-
// 6.-
