package hwPart3;

import java.util.Objects;
import java.util.Random;

public class Task {
    private final static Random RANDOM = new Random();
    private final int a;
    private final int b;

    public Task() {
        int first = RANDOM.nextInt(10);
        int second = RANDOM.nextInt(10);

        this.a = first < 2 ? first + 2 : first;
        this.b = second < 2 ? second + 2 : second;
    }

    @Override
    public String toString() {
        return a + " * " + b + " = ?";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task that = (Task) o;
        return (a == that.a && b == that.b) ||
                (a == that.b && b == that.a);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a * b, a + b);
    }
}
