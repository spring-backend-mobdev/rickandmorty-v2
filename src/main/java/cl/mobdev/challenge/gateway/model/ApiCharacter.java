package cl.mobdev.challenge.gateway.model;

import java.util.ArrayList;

public class ApiCharacter {

    private int id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private ApiLocation location;
    private ApiOrigin origin;
    private String image;
    private ArrayList<String> episode;
    private String url;
    private String created;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ApiLocation getLocation() {
        return location;
    }

    public void setLocation(ApiLocation location) {
        this.location = location;
    }


    public ApiOrigin getOrigin() {
        return origin;
    }

    public void setOrigin(ApiOrigin origin) {
        this.origin = origin;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ArrayList<String> getEpisode() {
        return episode;
    }

    public void setEpisode(ArrayList<String> episode) {
        this.episode = episode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}

// Test
// 1.- Testear nombre de cada personaje por id (Rick Sanchez = Id 1)
// 2.- Testear nombre indistinamente May. o Min.
// 3.- Id no encontrado (fuera de rango)
// 4.- Verificar si Especies es: Human, Humanoid, Alien, Robot ....
// 5.- Verificar si Gender es: Male, Female, GenderLess,
// 6.-