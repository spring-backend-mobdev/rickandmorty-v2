package cl.mobdev.challenge.usecase;


import cl.mobdev.challenge.domain.Character;
import cl.mobdev.challenge.domain.Location;
import org.springframework.stereotype.Component;

@Component
public class IsCharactersEarthlingUseCase {

    public boolean check(Character character) {
        boolean request = true;
        Location origin = character.getOrigin();
        if (null != origin && "Earth".equals(origin.getName())) {
            return request;
    }
        return false;
    }
}