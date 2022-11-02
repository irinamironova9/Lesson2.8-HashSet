package racing.people.drivers;

import racing.transport.Transport;

import java.util.Objects;

public abstract class Driver <T extends Transport> {
    private final String fullName;
    private int drivingExperience;
    private T transport;

    public Driver(String fullName, Integer drivingExperience, T transport) {
        this.fullName = transport.parse(fullName);
        setDrivingExperience(drivingExperience);
        setTransport(transport);
    }

    public final void participateInRacing() {
        System.out.println(this + " и будет участвовать в заезде.");
    }

    public abstract void startMoving();

    public abstract void stopMoving();

    public abstract void refill();

    @Override
    public final String toString() {
        return "Водитель " + fullName + " со стажем " +
                drivingExperience + " лет, авто - " + transport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver<?> driver = (Driver<?>) o;
        return Objects.equals(fullName, driver.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName);
    }

    public final String getFullName() {
        return fullName;
    }

    public final int getDrivingExperience() {
        return drivingExperience;
    }

    public final T getTransport() {
        return transport;
    }

    public final void setDrivingExperience(Integer drivingExperience) {
        this.drivingExperience = drivingExperience != null && drivingExperience >= 0 ?
                drivingExperience : 0;
    }

    public final void setTransport(T transport) {
        this.transport = transport;
    }
}