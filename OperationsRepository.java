import java.util.ArrayList;
import java.util.Optional;

public interface OperationsRepository<T> {
    public void save(T objeto,String type);

    public int  count();
    public ArrayList<T> getElements();

    public T find(int i);


public void getAllSortedBy(String nameAttribute);


public String getUserByUserName(String userName);


    public boolean validateTypeElement(T obj, String c) throws ClassNotFoundException;

    public  int findByProductName (String s);
    public  Optional<Product> findByProductName(Product newProduct);

    public Optional<Country> findByIsoCode(String isoCode);

    public Optional<User> findByUserName(String userName);

    public void updateStockByProductName(Product product, int addStock) ;


    }

