package food;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Recipe {
    private final String dishName;
    private final Set<Product> ingredients = new HashSet<>();

    public Recipe(String dishName) {
        if (dishName == null || dishName.isBlank()) {
            throw new IllegalArgumentException("Недопустимое название!");
        } else {
            this.dishName = dishName;
        }
    }

    public void addIngredient(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Продукт не может быть null!");
        }

        if (ingredients.contains(product)) {
            throw new ProductDoubleException("Продукт уже добавлен в список!");
        }

        ingredients.add(product);
    }

    public float calculateCost() {
        float sum = 0f;
        for (Product product : ingredients) {
            sum += product.getPrice() * (float) product.getAmount();
        }
        return sum;
    }

    @Override
    public String toString() {
        return String.format("Рецепт '%s':\n" +
                        "Суммарная стоимость ингредиентов - %.2f руб.\n" +
                        "Ингредиенты:\n" +
                        "%s",
                dishName,
                calculateCost(),
                printIngredients());
    }

    private StringBuilder printIngredients() {
        StringBuilder sb = new StringBuilder();
        for (Product product : ingredients) {
            sb.append(product).append("\n");
        }
        return sb;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(dishName, recipe.dishName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dishName);
    }

    public String getDishName() {
        return dishName;
    }
}
