package cl.mobdev.challenge.usecase;
// Terminar este Actyidad.
// Tendrá un método que dado un id,
//usara un gateway que trae un character
//y retorna el Character si es "female"
//o lanza una GenderException() en otro caso
//con un mensaje que dice "El character no es mujer"

import cl.mobdev.challenge.domain.Character;
import cl.mobdev.challenge.gateway.HumanCharacterGateway;
import cl.mobdev.challenge.usecase.exception.GenderException;

public class GetFemaleCharacterUseCase {

    private HumanCharacterGateway humanCharacterGateway;

    public GetFemaleCharacterUseCase(HumanCharacterGateway humanCharacterGateway) {
        this.humanCharacterGateway = humanCharacterGateway;
    }

    public Character execute(String id) {
        Character character = humanCharacterGateway.findCharacter(id);

        if ( "Female".equals(character.getGender())){
            return character;
        } else if (null == character || null == character.getGender()) {
            throw new GenderException("Gender is null");
        }else if (!"Female".equals(character.getGender())) {
            throw  new GenderException("Not Female");
        }
        return character;
    }
}