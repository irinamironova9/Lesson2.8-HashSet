package hwPart3;

import java.util.HashSet;
import java.util.Set;

public class MultiplicationTable {
    private final Set<Task> tasks = new HashSet<>(15);

    public MultiplicationTable() {
        while (tasks.size() < 15) {
            tasks.add(new Task());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Task task : tasks) {
            sb.append(task).append('\n');
        }
        return "Задачи дня:\n" + sb;
    }
}
