package cl.mobdev.challenge.usecase;

//Tendra un metodo que dado un id,
//usara un gateway que trae un character
//y retorna el Character si es "female"
//o lanza una GenderException() en otro caso
//con un mensaje que dice "El character no es mujer"


import cl.mobdev.challenge.domain.Character;
import cl.mobdev.challenge.gateway.RickAndMortyGateway;
import cl.mobdev.challenge.usecase.exception.GenderException;

public class GetFemaleCharacterUseCase {

    private final RickAndMortyGateway rickAndMortyGateway;

    public GetFemaleCharacterUseCase(RickAndMortyGateway rickAndMortyGateway) {
        this.rickAndMortyGateway = rickAndMortyGateway;
    }


    public Character execute(String id) {
        Character character = rickAndMortyGateway.getApiCharacter(id);
        if (!"female".equals(character.getGender())) {
            throw new GenderException("El character no es mujer");
        }
        return rickAndMortyGateway.getApiCharacter(id);
    }
}