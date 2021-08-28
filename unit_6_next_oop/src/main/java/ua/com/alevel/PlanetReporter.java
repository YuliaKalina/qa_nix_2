package ua.com.alevel;

import lombok.Getter;

public class PlanetReporter {
    @Getter
    private Planet planet;

    public PlanetReporter setPlanet(Planet planet) {
        this.planet = planet;
        return this;
    }

    public void report(){
        System.out.println("The gravity of " + planet.getName() + " - " + planet.getVelocity());
    }
}
