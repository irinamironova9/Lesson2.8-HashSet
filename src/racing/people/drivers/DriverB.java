package racing.people.drivers;

import racing.transport.Car;

public final class DriverB <C extends Car> extends Driver {
    private final String category = "B";

    public DriverB(String fullName, Integer drivingExperience, C transport) {
        super(fullName, drivingExperience, transport);
    }

    @Override
    public void startMoving() {
        System.out.printf("Водитель %s на автомобиле %s %s начал движение.\n",
                getFullName(), getTransport().getBrand(), getTransport().getModel());
    }

    @Override
    public void stopMoving() {
        System.out.printf("Водитель %s на автомобиле %s %s закончил движение.\n",
                getFullName(), getTransport().getBrand(), getTransport().getModel());
    }

    @Override
    public void refill() {
        System.out.printf("Водитель %s на автомобиле %s %s заправляет автомобиль.\n",
                getFullName(), getTransport().getBrand(), getTransport().getModel());
    }

    public String getCategory() {
        return category;
    }
}
