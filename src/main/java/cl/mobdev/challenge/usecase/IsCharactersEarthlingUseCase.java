package cl.mobdev.challenge.usecase;


import cl.mobdev.challenge.domain.Character;
import org.springframework.stereotype.Component;

@Component
public class IsCharactersEarthlingUseCase {

    public boolean check(Character character) {
        boolean request = true;
        String nameOrigin = character.getOrigin().getName();
        if (null == nameOrigin || "Earth".equals(nameOrigin)) {
            request = true;
    }
        return true;
}
}