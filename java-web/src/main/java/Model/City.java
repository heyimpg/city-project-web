package Model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class City {
    private int ID;
    private String name, country;
    private float area, population, gdp;
    private String instruction;

    public City(String name, String country, float area, float population, float gdp, String instruction) {
        this.name = name;
        this.country = country;
        this.area = area;
        this.population = population;
        this.gdp = gdp;
        this.instruction = instruction;
    }

    public City(int ID, String name, String country, float area, float population, float gdp, String instruction) {
        this.ID = ID;
        this.name = name;
        this.country = country;
        this.area = area;
        this.population = population;
        this.gdp = gdp;
        this.instruction = instruction;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @NotEmpty
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotEmpty
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public float getPopulation() {
        return population;
    }

    public void setPopulation(float population) {
        this.population = population;
    }

    public float getGdp() {
        return gdp;
    }

    public void setGdp(float gdp) {
        this.gdp = gdp;
    }

    @NotNull
    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    @Override
    public String toString() {
        return "City{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", area=" + area +
                ", population=" + population +
                ", gdp=" + gdp +
                ", instruction='" + instruction + '\'' +
                '}';
    }
}
