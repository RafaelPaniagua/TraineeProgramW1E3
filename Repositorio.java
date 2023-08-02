import javax.swing.*;
import java.util.ArrayList;

public class Repositorio <T> {

    private ArrayList< T > lista = new ArrayList < T >();



    public void save(T objeto,String type){ // throws ClassNotFoundException {

        try {
            if ( this.validateTypeElement(objeto,type) ) {
                lista.add(objeto);
                JFrame jFrame = new JFrame();
                JOptionPane.showMessageDialog(jFrame,"Registro almacenado con exito");
            }
            else {
                System.out.println("El elemento no es del tipo correcto");
                System.out.println("El elemento no ha sido almacenado");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public int count(){
        int c = 0;
        c = lista.size();
        return c;
    }

    public ArrayList<T> getElements(){

        return lista;

    }

    public void showElements(){
        String strLista;
        Object[] ta ;
       ta = lista.toArray();
       JFrame jFrame = new JFrame();
       JOptionPane.showMessageDialog(jFrame,lista);

    }


    public T find ( int i){
        T objeto = null;
        if( lista.size() <= i){
            JFrame jframe = new JFrame();
            JOptionPane.showMessageDialog(jframe,"El valor del indice está fuera de los limites para la longitud de la lista");
        }else {


            objeto = lista.get(i);


        }
           return objeto;

    }

    public  int findByNombreProducto (String s) {



        for ( T objeto: lista )  {
         Product p =    (Product) objeto;


            if( p.getName().equals(s)){
                int stock = p.getStock();


                return stock;
            }



        }


        return -1;

    }



    public  boolean validateTypeElement(T obj, String c) throws ClassNotFoundException
    {
      //  try {


            return Class.forName(c).isInstance(obj);
       // } catch (ClassNotFoundException e) {
            // JOptionPane.showMessageDialog(null,"Producto no valido" + );

         //   throw new RuntimeException(e);

        }



    }





