package racing.transport;

import racing.people.drivers.DriverB;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public final class Car extends Transport implements Competing {

    public enum BodyType {

        SEDAN("Седан"),
        HATCHBACK("Хетчбек"),
        COUPE("Купе"),
        STATION_WAGON("Универсал"),
        SUV("Внедорожник"),
        CROSSOVER("Кроссовер"),
        PICKUP("Пикап"),
        VAN("Фургон"),
        MINIVAN("Минивэн");

        private final String bodyTypeName;

        BodyType(String bodyTypeName) {
            this.bodyTypeName = bodyTypeName;
        }

        public static void displayCarBodyType(Car car) {
            if (car.getBodyType() == null) {
                System.out.printf("Нет данных о типе кузова автомобиля %s %s.\n",
                        car.getBrand(), car.getModel());
                return;
            }
            for (int i = 0; i < BodyType.values().length; i++) {
                if (car.getBodyType().equals(BodyType.values()[i])) {
                    System.out.printf("Тип кузова автомобиля %s %s - %s.\n",
                            car.getBrand(), car.getModel(),
                            BodyType.values()[i].getBodyTypeName());
                }
            }
        }

        private static BodyType setCarBodyType(String bodyTypeName) {
            for (int i = 0; i < BodyType.values().length; i++) {
                if (bodyTypeName.equalsIgnoreCase(BodyType.values()[i].getBodyTypeName())) {
                    return BodyType.values()[i];
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return bodyTypeName;
        }

        public String getBodyTypeName() {
            return bodyTypeName;
        }
    }

    private final BodyType bodyType;
//    private DriverB driver;

    public Car(String brand,
               String model,
               Double engineVolume,
               BodyType bodyType) {

        super(brand, model, engineVolume);
        this.bodyType = bodyType;
    }

    public Car(String brand,
               String model,
               Double engineVolume,
               String bodyType) {

        super(brand, model, engineVolume);
        this.bodyType = BodyType.setCarBodyType(parse(bodyType));
    }

    @Override
    public void startMoving() {
        System.out.printf("Автомобиль %s %s начал движение.\n", getBrand(), getModel());
    }

    @Override
    public void stopMoving() {
        System.out.printf("Автомобиль %s %s закончил движение.\n", getBrand(), getModel());
    }

    @Override
    public void doCheckup() throws FailedCheckupException {
        if (ThreadLocalRandom.current().nextInt(1, 5) == 1) {
            throw new FailedCheckupException("Автомобиль " + getBrand() +
                    getModel() + " не прошёл диагностику.");
        } else {
            System.out.printf("Автомобиль %s %s успешно прошёл диагностику.\n",
                    getBrand(), getModel());
        }
    }

    @Override
    public String toString() {
        return "Автомобиль " +
                super.toString() +
                " и типом кузова " + bodyType;
    }

    @Override
    public void pitStop() {
        System.out.printf("Автомобиль %s %s совершил пит-стоп.\n", getBrand(), getModel());
    }

    @Override
    public void getBestLapTime() {
        System.out.printf("Лучшее время круга автомобиля %s %s - %s секунд.\n",
                getBrand(),
                getModel(),
                ThreadLocalRandom.current().nextInt(1, 1000));
    }

    @Override
    public void getMaxSpeed() {
        System.out.printf("Максимальная скорость автомобиля %s %s - %s км/ч.\n",
                getBrand(),
                getModel(),
                ThreadLocalRandom.current().nextInt(1, 400));
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setDriver(DriverB driver) {
        if (driver != null) {
            this.driver = driver;
        } else {
            throw new IllegalArgumentException("Водитель не может быть null!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return (bodyType == car.bodyType &&
                getBrand().equals(car.getBrand()) &&
                getModel().equals(car.getModel()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getModel(), bodyType);
    }
}
