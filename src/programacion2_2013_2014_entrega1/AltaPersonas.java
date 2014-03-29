/*
GRABAR OBJETOS DE LA CLASE Personas EN EL FICHERO personas.dat
 */
package programacion2_2013_2014_entrega1;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;

public class AltaPersonas {
    static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String [] argumentos) {
        ObjectOutputStream objeto1= null;
        try{
            borrarPantalla();
            objeto1 = new ObjectOutputStream(new FileOutputStream("ficheros/personas.dat"));
            boolean terminar = false;
            while (!terminar) {
                Persona var = new Persona();
                objeto1.writeObject(var);
                System.out.print("CONTINUAR (s/n):  ");
                char car = (char) teclado.read();
                long saltarReturn = teclado.skip(1);
                if ((car=='n') || (car=='N')) {
                    terminar=true;
                }
                borrarPantalla();
            }
        }
        catch (IOException e) {
            System.out.println("error  --> " + e.toString());
        }
        finally {
            if (objeto1 != null) {
                try {
                    objeto1.close();
                }
                catch (IOException error) {
                    System.out.println("ERROR 1: " + error.toString());
                }
            }
        }
    }

    public static void borrarPantalla() {
                for (int i=0;i<50;i++) {
            System.out.print("\n");
        }
    } 
}