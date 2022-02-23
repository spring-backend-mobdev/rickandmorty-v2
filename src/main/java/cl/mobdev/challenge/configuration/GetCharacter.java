package cl.mobdev.challenge.configuration;

import cl.mobdev.challenge.domain.Character;
import org.springframework.stereotype.Service;

@Service
public interface GetCharacter {

    Character execute(String id);
}
