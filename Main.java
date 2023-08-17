import javax.swing.*;
import java.lang.reflect.Field;
import java.util.*;

//import static jdk.dynalink.linker.support.Guards.isInstance;

public class Main {
    public static void main(String[] args) {

        Repository<User> userRepository = new Repository<>();

        Repository<Country> countryRepository = new Repository<>();

        Repository<Product> productRepository = new Repository<>();

        boolean activated = true;
        boolean activated1 = true;
        boolean activated2 = true;
        boolean activated3 = true;
        Menu menu = new Menu();
        int choice;
        int choice1;
        int choice2;
        int choice3;
        do {

            try {
                choice = menu.getMenuMain();
                //   choice = Integer.parseInt(JOptionPane.showInputDialog(null, menu.menuPrincipal()));

                switch (choice) {

                    //Opción 1: Muestra el Menú para administrar los usuarios.

                    case 1:
                        do {
                            //Administración de Usuarios
                            choice1 = Integer.parseInt(JOptionPane.showInputDialog(null, menu.menuUsuario()));

                            switch (choice1) {
                                //Ingreso de Usuarios al Repositorio.
                                case 11:

                                    String usrname;
                                    usrname = JOptionPane.showInputDialog(null, "Ingresar Nombre de Usuario: ");

                                    Optional<User> optionalCountry = userRepository.findByUserName(usrname);

                                    if (optionalCountry.isEmpty()) {

                                        String fname;
                                        fname = JOptionPane.showInputDialog(null, "Ingresar Primer Nombre: ");
                                        String sname;
                                        sname = JOptionPane.showInputDialog(null, "Ingresar Primer Apellido: ");

                                        boolean activatedemail = true;
                                        String email;
                                        String choiceEmail;
                                        String menuemail;
                                        menuemail = "Desea agregar cuanta de Email" + "\n";
                                        menuemail += "1 - Agregar email" + "\n";
                                        menuemail += "2 - Salir. ";


                                        User user = new User(usrname, fname, sname);
                                        do {

                                            choiceEmail = JOptionPane.showInputDialog(null, menuemail, "", JOptionPane.INFORMATION_MESSAGE);

                                            if (choiceEmail.equals("1")) {
                                                email = JOptionPane.showInputDialog(null, "Ingresar cuenta de correo");
                                                user.addEmail(email);
                                            } else {
                                                activatedemail = false;
                                            }

                                        }
                                        while (activatedemail);


                                        userRepository.save(user, "User");
                                    } else {
                                        JFrame jframeMessageIsPresent = new JFrame();
                                        JOptionPane.showMessageDialog(jframeMessageIsPresent, "Nombre de Usuario ya xiste . El registro no será almacenado.");
                                    }

                                    break;

                                case 12:

                                    if (userRepository.count() != 0) {

                                        ArrayList<User> userArrayList = new ArrayList<>();
                                        Set<String> setEmail = new HashSet<>();

                                        userArrayList = userRepository.getElements();
                                        String strUsers = "";
                                        int cont = 0;
                                        int cont2 = 0;
                                        String strEmail = "";
                                        String strUsersComplete = "";
                                        cont2 = 0;
                                        for (User u : userArrayList) {
                                            cont++;


                                            strUsers += cont + "- " + u.getUserName() + " - " + u.getFirstName() + " " + u.getLastName() + "\n";
                                            setEmail = u.getEmailSet();

                                            strUsers += "----------------------------------------------\n";


                                            for (String s : setEmail) {
                                                cont2++;
                                                strEmail += cont2 + " - " + s.toString() + "\n";
                                            }


                                            strUsersComplete += strUsers + "\n" + strEmail + "\n";
                                            strEmail = "";
                                            strUsers = "";
                                            cont2 = 0;

                                        }


                                        JFrame jframe = new JFrame();
                                        //  JOptionPane.showMessageDialog(jframe, strUsers);
                                        JOptionPane.showMessageDialog(jframe, strUsersComplete);
                                    } else {
                                        JFrame jfame6 = new JFrame();
                                        JOptionPane.showMessageDialog(jfame6, "No hay registros en el repositorio de Usuarios");
                                    }


                                    break;

                                //Retorna la colecciión de dominios de acuerdo al Nombre de Usuario
                                case 13:
                                    int cont = 0;
                                    String userName;
                                    String selectedUserName;

                                    String[] usersNames = new String[userRepository.count()];
                                    ArrayList<User> userArrayList = new ArrayList<>();
                                    userArrayList = userRepository.getElements();

                                    for (User userx : userArrayList) {

                                        usersNames[cont] = userx.getUserName();
                                        cont++;

                                    }
                                    JFrame jframeUsersNames = new JFrame();
                                    selectedUserName = (String) JOptionPane.showInputDialog(jframeUsersNames, "Seleccione el nombre de usuario", "Nombres de Usuario", JOptionPane.QUESTION_MESSAGE, null, usersNames, usersNames[0]);

                                    String stringDomains;
                                    stringDomains = userRepository.getUserByUserName(selectedUserName);
                                    JFrame jframeDomains = new JFrame();

                                    JOptionPane.showMessageDialog(jframeDomains, stringDomains, "Dominios por Nombre de Usuario", JOptionPane.INFORMATION_MESSAGE, null);

                                    System.out.println(stringDomains);

                                    break;


                                case 14:
                                    int countUser;
                                    countUser = userRepository.count();
                                    String srtUser;
                                    srtUser = "Se han contado " + countUser + " registros de Usuario en el repositorio";
                                    JFrame jframe2 = new JFrame();
                                    JOptionPane.showMessageDialog(jframe2, srtUser);
                                    break;

                                case 15:
                                    if (userRepository.count() != 0) {

                                        User userx = new User();
                                        int idx = 0;
                                        JFrame jframe3 = new JFrame();
                                        idx = Integer.parseInt(JOptionPane.showInputDialog(jframe3, "Ingrese el valor del indice para el elemento que desee encon"));

                                        userx = userRepository.find(idx);

                                        if (userx != null) {

                                            JOptionPane.showMessageDialog(jframe3, "Usuario encontrado en la posicion " + idx + " " + userx.getFirstName() + " " + userx.getLastName());

                                        }
                                    } else {
                                        JFrame jfame7 = new JFrame();
                                        JOptionPane.showMessageDialog(jfame7, "No hay regustros en el repositorio de Usuarios");
                                    }
                                    break;


                                case 16:
                                    JFrame jframe = new JFrame();

                                    String nameAttribute;

                                    Class<User> userClass = User.class;
                                    Field[] fields = userClass.getDeclaredFields();
                                    String[] attributeNames = new String[fields.length];
                                    for (int i = 0; i < fields.length; i++) {
                                        attributeNames[i] = fields[i].getName();
                                    }
                                    if (userRepository.count() != 0) {
                                        nameAttribute = (String) JOptionPane.showInputDialog(null, "Ingrese el nombre del campo de ordenamiento", "List de Campos", JOptionPane.INFORMATION_MESSAGE, null, attributeNames, attributeNames[0]);

                                        userRepository.getAllSortedBy(nameAttribute);
                                    } else {
                                        JOptionPane.showMessageDialog(jframe, "El reporsitorio está vacio, debe de ingresar registros");
                                    }

                                    break;

                           /*     case 16:
                                    JFrame jframe4 = new JFrame();
                                    JOptionPane.showMessageDialog(null, "Regresará a menú Principal");
                                    menu.getMenuMain();
                                    activated1 = true;

                                    break;
*/

                                default:
                                    JFrame jframe5 = new JFrame();
                                    JOptionPane.showMessageDialog(jframe5, "Opción no valida");
                                    break;

                            }

                        } while (activated1);

                        // Administración de Paises;

                    case 2:
                        do {
                            choice2 = Integer.parseInt(JOptionPane.showInputDialog(null, menu.menuPais()));

                            switch (choice2) {


                                case 21:
                                    String ctrname;
                                    ctrname = JOptionPane.showInputDialog(null, "Ingresar Nombre del País: ");
                                    String ctrisocode;
                                    ctrisocode = JOptionPane.showInputDialog(null, "Ingresar Código ISO: ");

                                    Country country = new Country(ctrname, ctrisocode);
                                    Optional<Country> optionalCountry = countryRepository.findByIsoCode(country.getIsocode());

                                    if (optionalCountry.isEmpty()) {

                                        countryRepository.save(country, "Country");
                                    } else {

                                        JFrame jframeMessageIsPresent = new JFrame();
                                        JOptionPane.showMessageDialog(jframeMessageIsPresent, "País ya existe con este isocode. El registro no será almacenado.");
                                    }
                                    break;

                                case 22:
                                    // Mueestra Lista de Paises
                                    if (countryRepository.count() != 0) {

                                        ArrayList<Country> countryArrayList = new ArrayList<>();
                                        countryArrayList = countryRepository.getElements();

                                        String strContries = "";
                                        int cont = 0;
                                        for (Country c : countryArrayList) {
                                            cont++;

                                            strContries += cont + "- " + c.getName() + " - " + c.getIsocode() + " " + "\n";

                                        }
                                        JFrame jframe = new JFrame();
                                        JOptionPane.showMessageDialog(jframe, strContries);
                                    } else {
                                        JFrame jfame6 = new JFrame();
                                        JOptionPane.showMessageDialog(jfame6, "No hay registros en el repositorio de Paises");
                                    }
                                    break;

                                case 23:
                                    // Muesra un conteo de los registros del Repositorio de Paises

                                    int countPais;

                                    countPais = countryRepository.count();

                                    String srtPais;
                                    srtPais = "Se han contado " + countPais + " registros de Pais en el repositorio";
                                    JFrame jframe2 = new JFrame();
                                    JOptionPane.showMessageDialog(jframe2, srtPais);
                                    break;

                                case 24:

                                    if (countryRepository.count() != 0) {

                                        Country countryx = new Country();
                                        int idx = 0;
                                        JFrame jframe3 = new JFrame();
                                        idx = Integer.parseInt(JOptionPane.showInputDialog(jframe3, "Ingrese el valor del indice para el Pais que desee encontrar"));
                                        countryx = countryRepository.find(idx);

                                        if (countryx != null) {

                                            JOptionPane.showMessageDialog(jframe3, "Pais encontrado en la posicion " + idx + " " + countryx.getName() + " " + countryx.getIsocode());

                                        }
                                    } else {
                                        JFrame jfame7 = new JFrame();
                                        JOptionPane.showMessageDialog(jfame7, "No hay regustros en el repositorio de Paises");
                                    }
                                    break;

                                case 25:
                                    JFrame jframe = new JFrame();

                                    String nameAttribute;

                                    Class<Country> countryClass = Country.class;
                                    Field[] fields = countryClass.getDeclaredFields();
                                    String[] attributeNames = new String[fields.length];
                                    for (int i = 0; i < fields.length; i++) {
                                        attributeNames[i] = fields[i].getName();
                                    }
                                    if (countryRepository.count() != 0) {
                                        nameAttribute = (String) JOptionPane.showInputDialog(null, "Ingrese el nombre del campo de ordenamiento", "Lista de Campos", JOptionPane.INFORMATION_MESSAGE, null, attributeNames, attributeNames[0]);

                                        countryRepository.getAllSortedBy(nameAttribute);
                                    } else {
                                        JOptionPane.showMessageDialog(jframe, "El reporsitorio está vacio, debe de ingresar registros");
                                    }


                                    break;

                   /*             case 26:
                                    JFrame jframe25 = new JFrame();
                                    JOptionPane.showMessageDialog(jframe25, "Regresará a menú Principal");
                                    activated2 = false;
                                    break;
*/

                                default:
                                    JFrame jframe26 = new JFrame();
                                    JOptionPane.showMessageDialog(jframe26, "Opción no valida");
                                    break;


                            }
                        } while (activated2);

                    case 3:
                        do {
                            //Administracion de Productos.
                            choice3 = Integer.parseInt(JOptionPane.showInputDialog(null, menu.menuProduct()));

                            switch (choice3) {

                                //INgresar productos al Repositorio
                                case 31:

                                    String prdname;
                                    prdname = JOptionPane.showInputDialog(null, "Ingresar Nombre del Producto: ");
                                    int prdstock;
                                    prdstock = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresar stock del Producmto: "));


                                            Product newproduct = new Product(prdname, prdstock);
                                    productRepository.save(newproduct, "Product");


                                    break;

                                case 32:
                                    //Muestra todos los registros del Repositorio Producto

                                    if (productRepository.count() != 0) {


                                        ArrayList<Product> productsArrayList = new ArrayList<>();
                                        productsArrayList = productRepository.getElements();

                                        String strProducts = "";
                                        int cont = 0;
                                        for (Product p : productsArrayList) {
                                            cont++;

                                            strProducts += cont + "- " + p.getName() + " - " + p.getStock() + " " + "\n";

                                        }
                                        JFrame jframe = new JFrame();
                                        JOptionPane.showMessageDialog(jframe, strProducts);
                                    } else {
                                        JFrame jframe = new JFrame();
                                        JOptionPane.showMessageDialog(jframe, "No hay registros en el repositorio de Productos");
                                    }
                                    break;

                                case 33:
                                    // Muestra un conteo de los registros del Repositorio de Productos

                                    int countProducts;
                                    countProducts = productRepository.count();
                                    productRepository.getAllSortedBy("name");

                                    String strProduct;
                                    strProduct = "Se han contado " + countProducts + " registros  en el repositorio de Productos";
                                    JFrame jframe2 = new JFrame();
                                    JOptionPane.showMessageDialog(jframe2, strProduct);
                                    break;

                                case 34:
                                    //Encontrar un producto dado su posicion de indice.
                                    if (productRepository.count() != 0) {

                                        Product product1x = new Product();
                                        int idx = 0;
                                        JFrame jframe3 = new JFrame();
                                        idx = Integer.parseInt(JOptionPane.showInputDialog(jframe3, "Ingrese el valor del indice para el Producto que desee encontrar"));
                                        product1x = productRepository.find(idx);

                                        if (product1x != null) {

                                            JOptionPane.showMessageDialog(jframe3, "Producto  encontrado en la posicion " + idx + " " + product1x.getName() + " " + product1x.getStock());

                                        }
                                    } else {
                                        JFrame jfame7 = new JFrame();
                                        JOptionPane.showMessageDialog(jfame7, "No hay registros en el repositorio de Productos");
                                    }
                                    break;

                                case 35:
                                    // Retornar el Stock de un Producto buscando por el nombre.
                                    if (productRepository.count() != 0) {
                                        String strnameproduct;
                                        int strstockproduct;
                                        JFrame jframep = new JFrame();
                                        strnameproduct = JOptionPane.showInputDialog(jframep, "Ingrese el nombre del Producto:");
                                        strstockproduct = productRepository.findByProductName(strnameproduct);


                                        JOptionPane.showMessageDialog(jframep, "El stock de " + strnameproduct + " es: " + strstockproduct);


                                    } else {
                                        JFrame jfame7 = new JFrame();
                                        JOptionPane.showMessageDialog(jfame7, "No hay registros en el repositorio de Productos");
                                    }
                                    break;

                                case 36:
                                    JFrame jframe = new JFrame();

                                    String nameAttriube;

                                    Class<Product> productClass = Product.class;
                                    Field[] fields = productClass.getDeclaredFields();
                                    String[] nombresAtributos = new String[fields.length];
                                    for (int i = 0; i < fields.length; i++) {
                                        nombresAtributos[i] = fields[i].getName();
                                    }
                                    if (productRepository.count() != 0) {
                                        nameAttriube = (String) JOptionPane.showInputDialog(null, "Ingrese el nombre del campo de ordenamiento", "Lista de Campos", JOptionPane.INFORMATION_MESSAGE, null, nombresAtributos, nombresAtributos[0]);

                                        productRepository.getAllSortedBy(nameAttriube);
                                    } else {
                                        JOptionPane.showMessageDialog(jframe, "El reporsitorio está vacio, debe de ingresar registros");
                                    }


                                    break;


                                default:
                                    JFrame jframe26 = new JFrame();
                                    JOptionPane.showMessageDialog(jframe26, "Opción no valida");
                                    break;

                            }
                        } while (activated3);

                    case 4:

                        activated = false;
                        JOptionPane.showMessageDialog(null, "Ha salido del sistema");
                        System.exit(130);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no valida");
                        break;


                }


            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, " No ha seleccionado ninguna opción");

            }


        } while (activated);


    }


}