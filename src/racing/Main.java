package racing;

import racing.people.Mechanic;
import racing.people.Sponsor;
import racing.people.drivers.Driver;
import racing.people.drivers.DriverB;
import racing.people.drivers.DriverC;
import racing.people.drivers.DriverD;
import racing.transport.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws FailedCheckupException {

        Car lada = new Car("Lada", "Grande",1.7,
                Car.BodyType.SEDAN);
        Car audi = new Car("Audi", "A8 50 L TDI quattro",3.0,
                "   ");
        Car bmw = new Car("BMW", "Z8",3.0,
                "ПИКАП");
        Car kia = new Car("KIA", "Sportage 4",2.4,
                Car.BodyType.VAN);

        Truck volvo = new Truck("Volvo", "FH16", 7.0,
                Truck.LoadCapacityType.N1);
        Truck gaz = new Truck("ГАЗ", "3307", 8.0,
                Truck.LoadCapacityType.N2);
        Truck kamaz = new Truck("КАМАЗ", "65115", 6.5,
                null);
        Truck iveco = new Truck("Iveco", "S-Way", 9.4,
                Truck.LoadCapacityType.N3);

        Bus bus1 = new Bus("JHF", "B-43", 6.0,
                Bus.CapacityType.LARGE);
        Bus bus2 = new Bus("VLJHF", "hf 321", 6.3,
                Bus.CapacityType.SMALL);
        Bus bus3 = new Bus("Toyota", "Bus-157", 6.5,
                null);
        Bus bus4 = new Bus("PAZ", "3205", 6.5,
                Bus.CapacityType.VERY_LARGE);

        DriverB veronica = new DriverB<>("Вероника", 6, lada);
        lada.setDriver(veronica);
        DriverB alexander = new DriverB<>("Александр", 4, audi);
        audi.setDriver(alexander);
        DriverB mary = new DriverB<>("Мария", 3, bmw);
        bmw.setDriver(mary);
        DriverB john = new DriverB<>("John", 5, kia);
        kia.setDriver(john);

        DriverC oleg = new DriverC<>("Олег", 8, volvo);
        volvo.setDriver(oleg);
        DriverC katya = new DriverC<>("Екатерина", 6, gaz);
        gaz.setDriver(katya);
        DriverC jack = new DriverC<>("Jack", 5, kamaz);
        kamaz.setDriver(jack);
        DriverC alisa = new DriverC<>("Алиса", 7, iveco);
        iveco.setDriver(alisa);

        DriverD petr = new DriverD<>("Пётр", 7, bus1);
        bus1.setDriver(petr);
        DriverD liza = new DriverD<>("Лиза", 9, bus2);
        bus2.setDriver(liza);
        DriverD maxim = new DriverD<>("Максим", 8, bus3);
        bus3.setDriver(maxim);
        DriverD anna = new DriverD<>("Анна", 10, bus4);
        bus4.setDriver(anna);

//        bus1.doCheckup();
//        kia.doCheckup();
//        iveco.doCheckup();

        Car ladaDouble = new Car("Lada", "Grande",2.5,
                Car.BodyType.SEDAN);
        Truck ivecoDouble = new Truck("Iveco", "S-Way", 8.7,
                Truck.LoadCapacityType.N3);
        Bus bus4Double = new Bus("PAZ", "3205", 7.1,
                Bus.CapacityType.VERY_LARGE);

        Set<Transport> competing = new HashSet<>();
        competing.add(lada);
        competing.add(audi);
        competing.add(bmw);
        competing.add(kia);
        competing.add(volvo);
        competing.add(gaz);
        competing.add(kamaz);
        competing.add(iveco);
        competing.add(bus1);
        competing.add(bus2);
        competing.add(bus3);
        competing.add(bus4);
        competing.add(bus4Double);
        competing.add(ladaDouble);
        competing.add(ivecoDouble);

        for (Transport transport : competing) {
            System.out.println(transport);
        }
        System.out.println();

        DriverD annaDouble = new DriverD<>("Анна", 4, bus1);

        Set<Driver> drivers = new HashSet<>();
        drivers.add(veronica);
        drivers.add(oleg);
        drivers.add(anna);
        drivers.add(annaDouble);

        for (Driver driver : drivers) {
            System.out.println(driver);
        }
        System.out.println();

//        doCheckupForAll(competing);

        Sponsor vladimir = new Sponsor("Владимир", 500_000);
        Sponsor hannah = new Sponsor("Hannah", 600_000);
        Sponsor jane = new Sponsor("Jane", 480_000);
        Sponsor janeDouble = new Sponsor("Jane", 450_000);
        kia.getSponsors().add(vladimir);
        kia.getSponsors().add(hannah);
        kia.getSponsors().add(jane);
        kia.getSponsors().add(janeDouble);

        Mechanic olga = new Mechanic<>("Ольга", "Wheels");
        Mechanic sasha = new Mechanic<>("Саша", "Fiery Motors");
        Mechanic susan = new Mechanic<>("Susan", "Browne`s");
        Mechanic susanDouble = new Mechanic<>("Susan", "Greene`s");
        kia.getMechanics().add(olga);
        kia.getMechanics().add(sasha);
        kia.getMechanics().add(susan);
        kia.getMechanics().add(susanDouble);

        kia.printVehiclesPeople();

//        ServiceStation serviceStation = new ServiceStation();
//        serviceStation.addToQueue(lada);
//        serviceStation.addToQueue(gaz);
//        serviceStation.addToQueue(audi);
//        serviceStation.addToQueue(volvo);
//        serviceStation.addToQueue(kia);
//        serviceStation.addToQueue(bus1);
//        serviceStation.addToQueue(bmw);
//        serviceStation.addToQueue(kamaz);
//        serviceStation.addToQueue(iveco);

//        serviceStation.service();
    }

//    public static void doCheckupForAll(List<Transport> vehicles)
//            throws FailedCheckupException {
//        try {
//            for (Transport transport : vehicles) {
//                transport.doCheckup();
//            }
//        } catch (FailedCheckupException e) {
//            System.out.println(e.getMessage());
//        } finally {
//            System.out.println("Диагностика прекращена.");
//        }
//    }
}
