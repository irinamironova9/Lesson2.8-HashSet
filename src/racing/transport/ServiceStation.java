package racing.transport;

import java.util.LinkedList;
import java.util.Queue;

public class ServiceStation<T extends Transport> {
    Queue<T> queue = new LinkedList<>();

    public void addToQueue(T vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("Транспортное средство " +
                    "не может быть null!");
        }
        if (vehicle instanceof Bus) {
            System.out.println("Автобусы не нуждаются в техобслуживании.");
        } else {
            queue.add(vehicle);
            System.out.printf("ТС %s %s добавлено в очередь на техобслуживание.\n",
                    vehicle.getBrand(), vehicle.getModel());
        }
    }

    public void service() {
        T vehicle = queue.poll();
        if (vehicle != null) {
            System.out.printf("Проводится техобслуживание %s %s\n",
                    vehicle.getBrand(), vehicle.getModel());
            service();
        } else {
            System.out.println("Техобслуживание окончено.");
        }
    }
}
