import javax.swing.*;
import javax.swing.text.html.Option;
import java.lang.reflect.Field;
import java.util.*;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.logging.Logger;
import java.util.Comparator;

public class Repository<T> implements OperationsRepository {

    private ArrayList<T> lista = new ArrayList<T>();

    private T object;

    private Function<T, String> getName;


    @Override
    public void save(Object obj, String type) {
        T objeto = (T) obj;

        int addStock = ((Product) objeto).getStock();


        try {
            if (this.validateTypeElement(objeto, type)) {

                Optional<Product> optionalProduct = findByProductName((Product) objeto);

                if (optionalProduct.isEmpty()) {
                    lista.add(objeto);
                    JFrame jFrame = new JFrame();
                    JOptionPane.showMessageDialog(jFrame, "Registro almacenado con exito");
                } else {

                    updateStockByProductName(optionalProduct.get(), addStock);

                }


            } else {
                System.out.println("El elemento no es del tipo correcto");
                System.out.println("El elemento no ha sido almacenado");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    public void updateStockByProductName(Product product, int addStock) {

        product.updateStock(addStock);
        JFrame jframeUpdateProduct = new JFrame();
        JOptionPane.showMessageDialog(jframeUpdateProduct, "Producto ya existente. El stock se ha actualizado con exito");
    }

    @Override
    public int count() {
        int c = 0;
        c = lista.size();
        return c;
    }

    @Override
    public ArrayList<T> getElements() {
        return lista;
    }

    @Override
    public T find(int i) {
        T objeto = null;
        if (lista.size() <= i) {
            JFrame jframe = new JFrame();
            JOptionPane.showMessageDialog(jframe, "El valor del indice está fuera de los limites para la longitud de la lista");
        } else {


            objeto = lista.get(i);


        }
        return objeto;
    }

    @Override
    public void getAllSortedBy(String nameAttribute) {

        System.out.println("En nombre del atributo que se ha enviado es:" + nameAttribute);
        if (lista.size() != 0) {
            Class clss = lista.get(0).getClass();


            switch (clss.getName()) {

                case "Product":

                    List<Product> products = new ArrayList<>();

                    Product[] productsArray = new Product[lista.size()];
                    productsArray = lista.toArray(productsArray);

                    products = Arrays.asList(productsArray);

                    if (nameAttribute.equals("name")) {
                        System.out.println("Entró al if de name");
                        products.sort(Comparator.comparing(Product::getName));

                        System.out.println("Lista de productos ordenada por Nombre");


                        for (Product product : products) {
                            System.out.println(product.getName() + " Tiene un stock de: " + product.getStock());

                        }

                        String strinProducts = "";
                        int cont = 0;
                        for (Product p : products) {
                            cont++;

                            strinProducts += cont + "- " + p.getName() + " - " + p.getStock() + " " + "\n";

                        }
                        JFrame jframe = new JFrame();
                        JOptionPane.showMessageDialog(jframe, strinProducts, "Productos ordenados por Nombre", JOptionPane.INFORMATION_MESSAGE, null);


                    } else if (nameAttribute.equals("stock")) {

                        System.out.println("Entró al if de stock");
                        products.sort(Comparator.comparing(Product::getStock));

                        System.out.println("Lista de productos ordenada por Stock");


                        for (Product product : products) {
                            System.out.println(product.getName() + " Tiene un stock de: " + product.getStock());
                        }

                        String stringProducts = "";
                        int cont = 0;
                        for (Product p : products) {
                            cont++;

                            stringProducts += cont + "- " + p.getName() + " - " + p.getStock() + " " + "\n";

                        }
                        JFrame jframe = new JFrame();
                        JOptionPane.showMessageDialog(jframe, stringProducts, "Productos ordenados por Stock", JOptionPane.INFORMATION_MESSAGE, null);


                    }
                    break;
                case "User":

                    List<User> users = new ArrayList<>();

                    User[] usersArray = new User[lista.size()];
                    usersArray = lista.toArray(usersArray);
                    users = Arrays.asList(usersArray);

                    System.out.println("Entro al case USER");

                    if (nameAttribute.equals("userName")) {
                        System.out.println("Entró al if de userName");
                        users.sort(Comparator.comparing(User::getUserName));

                        System.out.println("Lista de users ordenada por UserName");


                        for (User user : users) {
                            System.out.println(user.getUserName() + " --->  " + user.getFirstName() + user.getFirstName());

                        }

                        String stringUsers = "";
                        int cont = 0;
                        for (User u : users) {
                            cont++;

                            stringUsers += cont + "- " + u.getUserName() + " - " + u.getFirstName() + " " + u.getLastName() + "\n";

                        }
                        JFrame jframe = new JFrame();
                        JOptionPane.showMessageDialog(jframe, stringUsers, "Usuarios ordenados por Nombre de Usuario", JOptionPane.INFORMATION_MESSAGE, null);


                    } else if (nameAttribute.equals("firstName")) {
                        System.out.println("Entró al if de firstName");
                        users.sort(Comparator.comparing(User::getFirstName));

                        System.out.println("Lista de users ordenada por firstName");


                        for (User user : users) {
                            System.out.println(user.getUserName() + " --->  " + user.getFirstName() + user.getFirstName());

                        }

                        String stringUsers = "";
                        int cont = 0;
                        for (User u : users) {
                            cont++;

                            stringUsers += cont + "- " + u.getUserName() + " - " + u.getFirstName() + " " + u.getLastName() + "\n";

                        }
                        JFrame jframe = new JFrame();
                        JOptionPane.showMessageDialog(jframe, stringUsers, "Usuarios ordenados por Nombre", JOptionPane.INFORMATION_MESSAGE, null);


                    } else if (nameAttribute.equals("lastName")) {
                        System.out.println("Entró al if de lastName");
                        users.sort(Comparator.comparing(User::getLastName));

                        System.out.println("Lista de users ordenada por lastName");


                        for (User user : users) {
                            System.out.println(user.getUserName() + " --->  " + user.getFirstName() + user.getFirstName());

                        }

                        String stringUsers = "";
                        int cont = 0;
                        for (User u : users) {
                            cont++;

                            stringUsers += cont + "- " + u.getUserName() + " - " + u.getFirstName() + " " + u.getLastName() + "\n";

                        }
                        JFrame jframe = new JFrame();
                        JOptionPane.showMessageDialog(jframe, stringUsers, "Usurios ordenados por Apellido", JOptionPane.INFORMATION_MESSAGE, null);


                    }


                    break;

                case "Country":

                    List<Country> countries = new ArrayList<>();

                    Country[] countryArray = new Country[lista.size()];
                    countryArray = lista.toArray(countryArray);
                    countries = Arrays.asList(countryArray);

                    System.out.println("Entro al case Contry");

                    if (nameAttribute.equals("name")) {
                        System.out.println("Entró al if de name");
                        countries.sort(Comparator.comparing(Country::getName));

                        System.out.println("Lista de paises ordenada por Nombre");


                        for (Country country : countries) {
                            System.out.println(country.getName() + " Tiene un codigo ISO de: " + country.getIsocode());

                        }

                        String stringCountries = "";
                        int cont = 0;
                        for (Country c : countries) {
                            cont++;

                            stringCountries += cont + "- " + c.getName() + " - " + c.getIsocode() + " " + "\n";

                        }
                        JFrame jframe = new JFrame();
                        JOptionPane.showMessageDialog(jframe, stringCountries, "Paises ordenados por Nombre", JOptionPane.INFORMATION_MESSAGE, null);


                    } else if (nameAttribute.equals("isocode")) {
                        System.out.println("Entró al if de isocode");
                        countries.sort(Comparator.comparing(Country::getIsocode));

                        System.out.println("Lista de paises ordenada por Código ISO");


                        for (Country country : countries) {
                            System.out.println(country.getName() + " Tiene un codigo ISO de: " + country.getIsocode());

                        }

                        String stringCountries = "";
                        int cont = 0;
                        for (Country c : countries) {
                            cont++;

                            stringCountries += cont + "- " + c.getName() + " - " + c.getIsocode() + " " + "\n";

                        }
                        JFrame jframe = new JFrame();
                        JOptionPane.showMessageDialog(jframe, stringCountries, "Paises ordenados por Código ISO", JOptionPane.INFORMATION_MESSAGE, null);


                    }


                    break;


            }


        } else {
            JFrame jframe = new JFrame();

            JOptionPane.showMessageDialog(jframe, "El repositorio está vació, debe de ingresar registros");

        }

    }

    @Override
    public String getUserByUserName(String userName) {
        User user, userFound;
        Set<String> setEmails = new HashSet<>();
        Set<String> setDomains = new HashSet<>();

        for (T element : lista) {

            user = (User) element;


            if (user.getUserName().equals(userName)) {
                setEmails = user.getEmailSet();

            }
        }

        for (String email : setEmails) {
            char charIndex = '@';
            int index;
            String domain;
            index = email.indexOf(charIndex);
            domain = email.substring(index);
            setDomains.add(domain);
        }
        String stringDomainsComplete = "";
        String stringDomainsHead = "Lista de Dominios " + "\n";
        stringDomainsHead += "----------------------------" + "\n";
        String stringDomainsList = "";
        int cont = 0;
        for (String domain : setDomains) {
            cont++;
            stringDomainsList += cont + " - " + domain + "\n";
        }
        stringDomainsComplete = stringDomainsHead + stringDomainsList;


        return stringDomainsComplete;
    }


    @Override
    public boolean validateTypeElement(Object obj, String c) throws ClassNotFoundException {
        return Class.forName(c).isInstance(obj);


    }

    public int findByProductName(String s) {

        for (T objeto : lista) {
            Product p = (Product) objeto;
            if (p.getName().equals(s)) {

                int stock = p.getStock();
                return stock;
            }

        }
        return -1;

    }

    public Optional<Product> findByProductName(Product newProduct) {
        Product productFound = new Product();
        List<Product> products = new ArrayList<>();
        Product[] productsArray = new Product[lista.size()];
        productsArray = lista.toArray(productsArray);
        //  products = Arrays.stream(productsArray).toList();
        products = Arrays.asList(productsArray);

        return products.stream().filter(product -> product.getName().equalsIgnoreCase(newProduct.getName())).findFirst();
    }

    public Optional<Country> findByIsoCode(String isoCode) {


        ArrayList<Country> countries = new ArrayList<>();
        Country country = new Country();
        for (T element :
                lista) {
            country = (Country) element;
            countries.add(country);

        }
        return countries.stream().filter(country1 -> country1.getIsocode().equals(isoCode)).findFirst();


    }

    public Optional<User> findByUserName(String userName) {
        User userFound = new User();
        List<User> users = new ArrayList<>();
        User[] userArray = new User[lista.size()];
        userArray = lista.toArray(userArray);
        users = Arrays.asList(userArray);
        return users.stream().filter(user -> user.getUserName().equals(userName)).findFirst();

    }


}
