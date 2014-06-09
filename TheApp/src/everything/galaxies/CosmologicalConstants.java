package everything.galaxies;

import java.util.Random;

public class CosmologicalConstants {
    public static final Random RANDOM = new Random();

    public static final int MAX_NUMBER_OF_GALAXIES = 5;
    public static final int MAX_NUMBER_OF_STARS = 20;
    public static final int MAX_NUMBER_OF_PLANETS = 5;

    private static final double CHANCE_OF_LIFE_BEING_SENTIENT = 0.01;
    private static final int AVERAGE_PLANET_LIFESPAN = 1000;
    private static final int AVERAGE_SOLAR_SYSTEM_LIFESPAN = 30000;
    private static final int AVERAGE_GALAXY_LIFESPAN = 100000;
    private static final int AVERAGE_UNIVERSE_LIFESPAN = 1000000;

    public static boolean hasSentientLife() {
        return ! (RANDOM.nextDouble() > CHANCE_OF_LIFE_BEING_SENTIENT);
    }

    public static int randomNumberOfPlanets() {
        return RANDOM.nextInt(CosmologicalConstants.MAX_NUMBER_OF_PLANETS);
    }

    public static int randomNumberOfGalaxies() {
        return RANDOM.nextInt(CosmologicalConstants.MAX_NUMBER_OF_GALAXIES);
    }

    public static int randomNumberOfSolarSystems() {
        return RANDOM.nextInt(CosmologicalConstants.MAX_NUMBER_OF_STARS);
    }

    public static int randomPlanetLifespan() {
        return RANDOM.nextInt(CosmologicalConstants.AVERAGE_PLANET_LIFESPAN);
    }

    public static int randomSolarSystemLifespan() {
        return RANDOM.nextInt(CosmologicalConstants.AVERAGE_SOLAR_SYSTEM_LIFESPAN);
    }

    public static int randomGalaxyLifespan() {
        return RANDOM.nextInt(CosmologicalConstants.AVERAGE_GALAXY_LIFESPAN);
    }

    public static int randomUniverseLifespan() {
        return RANDOM.nextInt(CosmologicalConstants.AVERAGE_UNIVERSE_LIFESPAN);
    }
}
