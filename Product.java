import java.lang.reflect.Field;
import java.util.Collection;

public  class  Product implements Comparable<Product>  {


    private  String name ;
   private int stock;

    public Product() {
    }

    public Product(String name, int stock) {
        this.name = name;
        this.stock = stock;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void updateStock(int value){
        int newValue ;
        newValue = this.getStock() + value;
        this.setStock(newValue);
    }

    @Override
    public int compareTo(Product p) {
      //  this.name.compareTo(p.name);
        return 0;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
