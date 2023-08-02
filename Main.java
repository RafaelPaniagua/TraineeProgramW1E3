import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

import static jdk.dynalink.linker.support.Guards.isInstance;

public class Main {
    public static void main(String[] args) {
        Repositorio<User> userRepositorio = new Repositorio<>();
        Repositorio<Product> productRepositorio = new Repositorio<>();
        Repositorio<Country> countryRepositorio = new Repositorio<>();

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
                choice = Integer.parseInt(JOptionPane.showInputDialog(null, menu.menuPrincipal()));

                switch (choice) {

                    //Opción 1: Muestra el Mnuú para administrar los usuarios.

                    case 1:
                        do {
                            //Administración de Usuarios
                            choice1 = Integer.parseInt(JOptionPane.showInputDialog(null, menu.menuUsuario()));
                            switch (choice1) {
                                //Ingreso de Usuarios al Repositorio.
                                case 11:

                                    String usrname;
                                    usrname = JOptionPane.showInputDialog(null, "Ingresar Nombre de Usuario: ");
                                    String fname;
                                    fname = JOptionPane.showInputDialog(null, "Ingresar Primer Nombre: ");
                                    String sname;
                                    sname = JOptionPane.showInputDialog(null, "Ingresar Primer Apellido: ");

                                    User user = new User(usrname, fname, sname);
                                    userRepositorio.save(user, "User");
                                    break;

                                case 12:
                                    // int countuser = 0;
                                    if (userRepositorio.count() != 0) {

                                        ArrayList<User> userArrayList = new ArrayList<>();
                                        userArrayList = userRepositorio.getElements();
                                        String strUsers = "";
                                        int cont = 0;
                                        for (User u : userArrayList) {
                                            cont++;

                                            strUsers += cont + "- " + u.getUserName() + " - " + u.getFirstName() + " " + u.getLastName() + "\n";

                                        }
                                        JFrame jframe = new JFrame();
                                        JOptionPane.showMessageDialog(jframe, strUsers);
                                    } else {
                                        JFrame jfame6 = new JFrame();
                                        JOptionPane.showMessageDialog(jfame6, "No hay registros en el repositorio de Usuarios");
                                    }


                                    break;

                                case 13:
                                    int countUser;
                                    countUser = userRepositorio.count();
                                    String srtUser;
                                    srtUser = "Se han contado " + countUser + " registros de Usuario en el repositorio";
                                    JFrame jframe2 = new JFrame();
                                    JOptionPane.showMessageDialog(jframe2, srtUser);
                                    break;

                                case 14:
                                    if (userRepositorio.count() != 0) {
                                        User userx = new User();
                                        int idx = 0;
                                        JFrame jframe3 = new JFrame();
                                        idx = Integer.parseInt(JOptionPane.showInputDialog(jframe3, "Ingrese el valor del indice para el elemento que desee encon"));
                                        userx = userRepositorio.find(idx);
                                        if (userx != null) {

                                            JOptionPane.showMessageDialog(jframe3, "Usuario encontrado en la posicion " + idx + " " + userx.getFirstName() + " " + userx.getLastName());

                                        }
                                    } else {
                                        JFrame jfame7 = new JFrame();
                                        JOptionPane.showMessageDialog(jfame7, "No hay regustros en el repositorio de Usuarios");
                                    }
                                    break;

                                case 15:
                                    JFrame jframe4 = new JFrame();
                                    JOptionPane.showMessageDialog(null, "Regresará a menú Principal");
                                    activated1 = true;

                                    break;
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
                                    countryRepositorio.save(country, "Country");
                                    break;

                                case 22:
                                    // Mueestra Lista de Paises
                                    if (countryRepositorio.count() != 0) {

                                        ArrayList<Country> countryArrayList = new ArrayList<>();
                                        countryArrayList = countryRepositorio.getElements();
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
                                    countPais = countryRepositorio.count();
                                    String srtPais;
                                    srtPais = "Se han contado " + countPais + " registros de Pais en el repositorio";
                                    JFrame jframe2 = new JFrame();
                                    JOptionPane.showMessageDialog(jframe2, srtPais);
                                    break;

                                case 24:
                                    if (countryRepositorio.count() != 0) {
                                        Country countryx = new Country();
                                        int idx = 0;
                                        JFrame jframe3 = new JFrame();
                                        idx = Integer.parseInt(JOptionPane.showInputDialog(jframe3, "Ingrese el valor del indice para el Pais que desee encontrar"));
                                        countryx = countryRepositorio.find(idx);
                                        if (countryx != null) {

                                            JOptionPane.showMessageDialog(jframe3, "Pais encontrado en la posicion " + idx + " " + countryx.getName() + " " + countryx.getIsocode());

                                        }
                                    } else {
                                        JFrame jfame7 = new JFrame();
                                        JOptionPane.showMessageDialog(jfame7, "No hay regustros en el repositorio de Paises");
                                    }
                                    break;

                                case 25:
                                    JFrame jframe25 = new JFrame();
                                    JOptionPane.showMessageDialog(jframe25, "Regresará a menú Principal");
                                    activated2 = false;
                                    break;


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


                                    Product product = new Product(prdname, prdstock);
                                    productRepositorio.save(product, "Product");
                                    break;

                                case 32
                                        //Muestra todos los registros del Repositorio Producto
                                        :
                                    if (productRepositorio.count() != 0) {

                                        ArrayList<Product> productsArrayList = new ArrayList<>();
                                        productsArrayList = productRepositorio.getElements();
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
                                    // Muesra un conteo de los registros del Repositorio de Productos

                                    int countProducts;
                                    countProducts = productRepositorio.count();
                                    String strProduct;
                                    strProduct = "Se han contado " + countProducts + " registros  en el repositorio de Productos";
                                    JFrame jframe2 = new JFrame();
                                    JOptionPane.showMessageDialog(jframe2, strProduct);
                                    break;

                                case 34:
                                    //Encontrar un producto dado su posicion de indice.
                                    if (productRepositorio.count() != 0) {
                                        Product product1x = new Product();
                                        int idx = 0;
                                        JFrame jframe3 = new JFrame();
                                        idx = Integer.parseInt(JOptionPane.showInputDialog(jframe3, "Ingrese el valor del indice para el Producto que desee encontrar"));
                                        product1x = productRepositorio.find(idx);
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
                                    if (productRepositorio.count() != 0) {
                                        String strnameproduct;
                                        int strstockproduct;
                                        JFrame jframep = new JFrame();
                                        strnameproduct = JOptionPane.showInputDialog(jframep, "Ingrese el nombre del Producto:");
                                        strstockproduct = productRepositorio.findByNombreProducto(strnameproduct);
                                        JOptionPane.showMessageDialog(jframep, "El stock de " + strnameproduct + " es: " + strstockproduct);


                                    } else {
                                        JFrame jfame7 = new JFrame();
                                        JOptionPane.showMessageDialog(jfame7, "No hay registros en el repositorio de Productos");
                                    }
                                    break;

                                case 36:
                                    JFrame jframe25 = new JFrame();
                                    JOptionPane.showMessageDialog(null, "Regresará a menú Principal");
                                    activated3 = false;
                                    break;


                                default:
                                    JFrame jframe26 = new JFrame();
                                    JOptionPane.showMessageDialog(null, "Opción no valida");
                                    break;

                            }
                        } while (activated3);

                    case 4:

                        activated = false;
                        JOptionPane.showMessageDialog(null, "Ha salido del sistema");
                        // System.exit(1);
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