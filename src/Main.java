public class Main {
    public static void main(String[] args) {
        Product milk = new Product("Молоко", 73.50f, 2);
        Product bread = new Product("Хлеб", 48.00f, 1);
        Product egg = new Product("Яйцо куриное", 81.20f, 10);
        Product apple = new Product("Яблоко", 34.00f, 6);
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
    }
}