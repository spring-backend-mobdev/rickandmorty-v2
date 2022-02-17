package cl.mobdev.challenge.domain;

import cl.mobdev.challenge.usecase.GetCharacterUnknownUseCase;

import java.util.Objects;

public class Character {

    private int id;
    private String name;
    private String status;
    private String species;
    private String gender;
    private String type;
    private int episode_count;
    private Location origin;

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

    public int getEpisode_count() {
        return episode_count;
    }

    public void setEpisode_count(int episode_count) {
        this.episode_count = episode_count;
    }

    public Location getOrigin() {
        return origin;
    }

    public void setOrigin(Location origin) {
        this.origin = origin;
    }

    public int getStatusCodeValue(GetCharacterUnknownUseCase getCharacterUnknownUseCase) {
        return id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", species='" + species + '\'' +
                ", gender='" + gender + '\'' +
                ", type='" + type + '\'' +
                ", episode_count=" + episode_count +
                ", origin=" + origin +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return id == character.id && episode_count == character.episode_count && Objects.equals(name, character.name)
                && Objects.equals(status, character.status) && Objects.equals(species, character.species) &&
                Objects.equals(gender, character.gender) && Objects.equals(type, character.type) &&
                Objects.equals(origin, character.origin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, status, species, gender, type, episode_count, origin);
    }
}