package racing.transport;

import racing.people.Mechanic;
import racing.people.Sponsor;
import racing.people.drivers.Driver;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public abstract class Transport<D extends Driver> {
    private final String brand;
    private final String model;
    private double engineVolume;
    protected D driver;
    private final Set<Mechanic> mechanics = new HashSet<>();
    private final Set<Sponsor> sponsors = new HashSet<>();

    public Transport(String brand,
                     String model,
                     Double engineVolume) {

        this.brand = parse(brand);
        this.model = parse(model);
        setEngineVolume(engineVolume);
    }

    public abstract void startMoving();

    public abstract void stopMoving();

    public abstract void doCheckup() throws FailedCheckupException;

    public void printVehiclesPeople() {
        System.out.printf("Над %s %s работают:\n" +
                        "Водитель - %s\n" +
                        "Механики:\n",
                brand, model,
                driver.getFullName());

        for (Mechanic mechanic : mechanics) {
            System.out.println(mechanic);
        }

        System.out.println("Спонсоры:");
        for (Sponsor sponsor : sponsors) {
            System.out.println(sponsor);
        }
    }

    public static String parse(String value){
        return value != null && !value.isEmpty() && !value.isBlank() ?
                value : "(информация не указана)";
    }

    @Override
    public String toString() {
        return brand + " " + model +
                " с объёмом двигателя в " +
                engineVolume + " литров";
    }

    public final String getBrand() {
        return brand;
    }

    public final String getModel() {
        return model;
    }

    public final double getEngineVolume() {
        return engineVolume;
    }

    public final D getDriver() {
        return driver;
    }

    public final Set<Mechanic> getMechanics() {
        return mechanics;
    }

    public final Set<Sponsor> getSponsors() {
        return sponsors;
    }

    public void setEngineVolume(Double engineVolume) {
        this.engineVolume = engineVolume != null && engineVolume > 0 ?
                engineVolume : 1.5;
    }
}