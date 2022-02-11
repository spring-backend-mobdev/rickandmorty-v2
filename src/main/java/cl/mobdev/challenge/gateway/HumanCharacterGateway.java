package cl.mobdev.challenge.gateway;

import cl.mobdev.challenge.domain.Character;

public class HumanCharacterGateway {

    private Character character = new Character();

    public Character findCharacter(String id){
        return character;

    }
}
