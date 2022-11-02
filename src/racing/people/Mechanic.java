package racing.people;

import racing.transport.Transport;

import java.util.Objects;

public class Mechanic<T extends Transport> {

    private final String fullName;
    private String company;

    public Mechanic(String fullName, String company) {
        this.fullName = Transport.parse(fullName);
        setCompany(company);
    }

    public void serviceVehicle(T vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("Транспортное средство не может быть null!");
        }

        System.out.printf("Механик %s от компании %s провел(а) техобслуживание " +
                        "для транспортного средства %s %s.\n",
                getFullName(), getCompany(),
                vehicle.getBrand(), vehicle.getModel());
    }

    public void fixVehicle(T vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("Транспортное средство не может быть null!");
        }

        System.out.printf("Механик %s от компании %s починил(а) " +
                "транспортное средство %s %s.\n",
                getFullName(),
                getCompany(),
                vehicle.getBrand(),
                vehicle.getModel());
    }

    @Override
    public String toString() {
        return String.format("Механик %s от компании %s", fullName, company);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mechanic<?> mechanic = (Mechanic<?>) o;
        return Objects.equals(fullName, mechanic.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName);
    }

    public String getFullName() {
        return fullName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = Transport.parse(company);
    }
}
