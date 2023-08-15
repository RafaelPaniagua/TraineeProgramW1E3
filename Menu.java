import javax.swing.*;

public class Menu {

    String menuMain ;

    public Menu() {
    }

    public String OptionsMain(){

        String menu = "--------------------------------------------------------------" + "\n";
        menu += "REPOSITORIO" + "\n";
        menu += "Menú Principal                       " + "\n";
        menu += "Seleccione la opción que desea realizar:" + "\n";
        menu += "1- Administracion de Usuarios" + "\n";
        menu += "2- Administracion de Paises" + "\n";
        menu += "3- Administracion de Productos" + "\n";
        menu += "4- Salir" + "\n";

        return menu;

    }

    public String  menuUsuario(){

        int choice;

        String menu = "--------------------------------------------------------------" + "\n";

        menu += "ADMINISTRACION DE USUARIOS                        " + "\n";
        menu += "Seleccione la opción que desea realizar:" + "\n";
        menu += "11- Crear registro de Usuario" + "\n";
        menu += "12- Consultar registros de Usuario" + "\n";
        menu += "13- Consultar Dominios por Nombre de Usuario" + "\n";
        menu += "14- Contar Usuarios" + "\n";
        menu += "15- Buscar registro de Usuario" + "\n";
       menu +=  "16-  Ordenar Repositorio de usuarios por nombre de campo" + "\n";


        return menu;

    }

public String menuPais(){
    int choice;

    String menu = "--------------------------------------------------------------" + "\n";

    menu += "ADMINISTRACION DE PAISES                        " + "\n";
    menu += "Seleccionar opción que desea realizar:" + "\n";
    menu += "21- Crear registro de Pais" + "\n";
    menu += "22- Consultar registros de País" + "\n";
    menu += "23- Contar registros de País" + "\n";
    menu += "24- Buscar registro de País" + "\n";
    menu += "25- Ordenar repositorio de Paises  por nombre de campo" + "\n";


    return menu;

}

    public String menuProduct(){
        int choice;

        String menu = "--------------------------------------------------------------" + "\n";

        menu += "ADMINISTRACION DE PRODUCTOS                        " + "\n";
        menu += "Seleccionar opción que desea realizar:" + "\n";
        menu += "31- Crear registro de Producto" + "\n";
        menu += "32- Consultar registros de Productos" + "\n";
        menu += "33- Contar registros de Productos" + "\n";
        menu += "34- Buscar registro de Productos" + "\n";
        menu += "35- Retornar el Stock de un Producto, buscando por el nombre" + "\n";
        menu += "36.- Ordenar repositorio de productos por nombre de campo" + "\n";


        return menu;

    }


public  int getMenuMain(){
        JFrame  jframe = new JFrame();
        int choice ;

    String menu = "--------------------------------------------------------------" + "\n";
    menu += "REPOSITORIO" + "\n";
    menu += "Menú Principal                       " + "\n";
    menu += "Seleccione la opción que desea realizar:" + "\n";
    menu += "1- Administracion de Usuarios" + "\n";
    menu += "2- Administracion de Paises" + "\n";
    menu += "3- Administracion de Productos" + "\n";
    menu += "4- Salir" + "\n";



     choice =   Integer.parseInt(  JOptionPane.showInputDialog(jframe,OptionsMain(),"Menú Princiapl",3));

        return choice;


}






}
