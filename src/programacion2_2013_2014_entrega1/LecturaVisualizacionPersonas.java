/*
VISUALIZAR EN PANTALLA LOS OBJETOS DE LA CLASE Personas CONTENIDOS EN
* EL FICHERO personas.dat
 */
package programacion2_2013_2014_entrega1;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;

public class LecturaVisualizacionPersonas {
    static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String [] argumentos) {
        ObjectInputStream objeto =null;
        try {
            borrarPantalla();
            objeto = new ObjectInputStream(new FileInputStream("ficheros/personas.dat"));
            try {
                Persona var=(Persona)objeto.readObject();
                while (var!=null) {
                    System.out.println(var.toString());
                    var=(Persona)objeto.readObject();
                }
            }
            catch (EOFException e) {
                System.out.println("\n\n\n CONTINUAR --> pulsar return ");
                try {
                  char c =(char)teclado.read();
                }
                catch (IOException e1) {}
            }
            catch (ClassNotFoundException e) {
                System.out.println("error  --> " + e.toString());
            }
        }
        catch (IOException e) {
            System.out.println("error  --> " + e.toString());
        }
        finally {
            if (objeto != null) {
                try {
                    objeto.close();
                } catch (IOException error) {
                    System.out.println("ERROR : " + error.toString());
              }
            }
        }
    }
    
    public static void borrarPantalla() {
        for (int i=0;i<20;i++) {
            System.out.print("\n");
        }
    } 
}