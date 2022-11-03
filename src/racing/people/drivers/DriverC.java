package racing.people.drivers;

import racing.transport.Truck;

public final class DriverC <T extends Truck> extends Driver {
    private final String category = "C";

    public DriverC(String fullName, Integer drivingExperience, T transport) {
        super(fullName, drivingExperience, transport);
    }

    @Override
    public void startMoving() {
        System.out.printf("Водитель %s на грузовике %s %s начал движение.\n",
                getFullName(), getTransport().getBrand(), getTransport().getModel());
    }

    @Override
    public void stopMoving() {
        System.out.printf("Водитель %s на грузовике %s %s закончил движение.\n",
                getFullName(), getTransport().getBrand(), getTransport().getModel());
    }

    @Override
    public void refill() {
        System.out.printf("Водитель %s на грузовике %s %s заправляет грузовик.\n",
                getFullName(), getTransport().getBrand(), getTransport().getModel());
    }

    public String getCategory() {
        return category;
    }
}
