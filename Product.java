public class Product {

   private String name ;
   private int Stock;


    public Product() {
    }

    public Product(String name, int stock) {
        this.name = name;
        Stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return Stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setStock(int stock) {
        Stock = stock;
    }
}
