package cl.mobdev.challenge.domain;

import java.util.ArrayList;
import java.util.Objects;

public class Location {

    private String name;
    private String url;
    private String dimension;
    private ArrayList<String> residents;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public ArrayList<String> getResidents() {
        return residents;
    }

    public void setResidents(ArrayList<String> residents) {
        this.residents = residents;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", dimension='" + dimension + '\'' +
                ", residents=" + residents +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(name, location.name) && Objects.equals(url, location.url) && Objects.equals(dimension, location.dimension) && Objects.equals(residents, location.residents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, url, dimension, residents);
    }
}