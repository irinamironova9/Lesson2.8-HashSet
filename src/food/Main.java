package food;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Product milk = new Product("Молоко", 73.50f, 2);
        Product bread = new Product("Хлеб", 48.00f, 1);
        Product egg = new Product("Яйцо куриное", 11.20f, 10);
        Product apple = new Product("Яблоко", 9.00f, 6);
        Product chocolate = new Product("Шоколад", 67.90f, 1);

        ProductList toBuy = new ProductList();
        toBuy.addProduct(milk);
        toBuy.addProduct(bread);
        toBuy.addProduct(egg);
        toBuy.addProduct(apple);
        toBuy.addProduct(chocolate);

        System.out.println(toBuy);

        toBuy.markAsBought(milk);
        toBuy.removeProduct(apple);
        toBuy.markAsBought(apple);

        System.out.println(milk.getIsBought());
        System.out.println(egg.getIsBought());

        System.out.println();

        System.out.println(toBuy);

        Recipe pie = new Recipe("Пирог");
        pie.addIngredient(egg);
        pie.addIngredient(milk);
        pie.addIngredient(chocolate);
        pie.addIngredient(apple);

        Recipe frenchToast = new Recipe("Гренки");
        frenchToast.addIngredient(bread);
        frenchToast.addIngredient(milk);
        frenchToast.addIngredient(egg);

        CookBook cookBook = new CookBook();
        cookBook.addRecipe(pie);
        cookBook.addRecipe(frenchToast);
        cookBook.addRecipe("Лимонад");

        System.out.println(pie);

        System.out.println(cookBook);

        task2();
    }

    public static void task2() {
        Random random = new Random();
        Set<Integer> integers = new HashSet<>(20);
        for (int i = 0; i < 20; i++) {
            integers.add(random.nextInt(1000));
        }
        System.out.println(integers);

        integers.removeIf(next -> next % 2 != 0);
        System.out.println(integers);
    }
}