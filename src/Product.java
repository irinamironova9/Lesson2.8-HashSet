import java.util.Objects;

public class Product {
    private final String name;
    private float price;
    private int amount;
    private boolean isBought = false;

    public Product(String name, float price, int amount) {
        if (name == null || name.isBlank() || price <= 0 || amount <= 0) {
            throw new IllegalArgumentException("Заполните карточку товара полностью!");
        }

        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("Продукт: %s, цена %.2f руб., кол-во %s шт., " +
                        "куплен - %s",
                name, price, amount, booleanToString());
    }

    private String booleanToString() {
        return this.isBought ? "да" : "нет";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public boolean getIsBought() {
        return isBought;
    }

    public void setPrice(float price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Недопустимое значение цены!");
        } else {
            this.price = price;
        }
    }

    public void setAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Недопустимое значение количества!");
        } else {
            this.amount = amount;
        }
    }

    protected void setIsBought(boolean isBought) {
        this.isBought = isBought;
    }
}
