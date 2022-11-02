import java.util.HashSet;
import java.util.Set;

public class ProductList {
    private final Set<Product> products = new HashSet<>();

    public void addProduct(Product product) {
        product = nonNull(product);

        if (products.contains(product)) {
            throw new ProductDoubleException("Продукт уже добавлен в список!");
        }

        products.add(product);
    }

    public void markAsBought(Product product) {
        product = nonNull(product);
        if (products.contains(product)) {
            product.setIsBought(true);
        } else {
            System.out.println("В данном списке отсутствует " + product);
        }
    }

    public void removeProduct(Product product) {
        product = nonNull(product);
        if (products.contains(product)) {
            products.remove(product);
        } else {
            System.out.println("В данном списке отсутствует " + product);
        }
    }

    private Product nonNull(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Продукт не может быть null!");
        } else {
            return product;
        }
    }

    @Override
    public String toString() {
        return "Список продуктов:\n" + printProducts();
    }

    private StringBuilder printProducts() {
        StringBuilder sb = new StringBuilder();
        for (Product product : products) {
            sb.append(product).append("\n");
        }
        return sb;
    }
}
