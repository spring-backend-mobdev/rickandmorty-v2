package cl.mobdev.challenge.configuration;

import cl.mobdev.challenge.gateway.RickAndMortyGateway;
import org.springframework.beans.factory.annotation.Autowired;

public class RickAndMortyServiceImpl implements RickAndMortyService {

    @Autowired
    private RickAndMortyGateway  ickAndMortyGateway;
}
