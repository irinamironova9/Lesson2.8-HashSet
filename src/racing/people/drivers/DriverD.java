package racing.people.drivers;

import racing.transport.Bus;

public final class DriverD <B extends Bus> extends Driver {
    private final String category = "D";

    public DriverD(String fullName, Integer drivingExperience, B transport) {
        super(fullName, drivingExperience, transport);
    }

    @Override
    public void startMoving() {
        System.out.printf("Водитель %s на автобусе %s %s начал движение.\n",
                getFullName(), getTransport().getBrand(), getTransport().getModel());
    }

    @Override
    public void stopMoving() {
        System.out.printf("Водитель %s на автобусе %s %s закончил движение.\n",
                getFullName(), getTransport().getBrand(), getTransport().getModel());
    }

    @Override
    public void refill() {
        System.out.printf("Водитель %s на автобусе %s %s заправляет автобус.\n",
                getFullName(), getTransport().getBrand(), getTransport().getModel());
    }

    public String getCategory() {
        return category;
    }
}
