package cl.mobdev.challenge.usecase;

import cl.mobdev.challenge.gateway.model.ApiCharacter;
import cl.mobdev.challenge.usecase.exception.LocationException;

//Tendra un metodo que dado un Character,
//retorna un true si donde vive es el mismo lugar de su origen
//y false en otro caso.
//Lanzara un LocationException si su origen es desconocido
//Lanzara un LocationException si su locacion es desconocido
//Lanzara un LocationException si su origen y location es desconocido

public class IsLocationIsOriginUseCase {
    public boolean execute(ApiCharacter apiCharacter) {
        String location;
        String origin;

        if (null == apiCharacter.getLocation() || null == apiCharacter.getOrigin()) {
            throw new LocationException("Location or Origin is Null");
        }

        location = apiCharacter.getLocation().getName();
        origin = apiCharacter.getOrigin().getName();

       if (location.equals(origin) && !"unknown".equals(origin) && !"unknown".equals(location)) {
            return true;
        } else if ("unknown".equals(origin) && "unknown".equals(location)) {
            throw new LocationException("The location and origin of the character is unknown.");
        } else if ("unknown".equals(origin)) {
            throw new LocationException("The origin of the character is unknown.");
        } else if ("unknown".equals(location)) {
            throw new LocationException("The location of the character is unknown.");
        }

       return false;
    }
}