/************************************************************************************
 * Dado un fichero personas.dat, normalizar el NIF de las personas que no lo tengan *
 * así. Todo NIF tiene 9 caracteres, si tiene menos de 9 tenemos que agregar un 50  *
 * al principio y se le asigna la letra que se calcula automaticamente.             *
 ************************************************************************************/

package programacion2_2013_2014_entrega1;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class NIF_normalizado {
    static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] arg) {
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("ficheros/personas.dat"));
            oos = new ObjectOutputStream(new FileOutputStream("ficheros/personasModificadas.dat"));
            String DNI;
            int tamañoDNI;
            Persona p =(Persona)ois.readObject();
            while(p != null) {
                DNI = p.getNif();
                tamañoDNI = p.getNif().length();
                if(tamañoDNI < 8) {
                    for (int i = tamañoDNI; i < 7; i++) {
                        DNI = "0" + DNI;
                    }
                    DNI = "5" + DNI;
                    p.setNIF(letraDNI(Integer.parseInt(DNI)));
                    p.actualiza(oos);
                }
                else if (tamañoDNI == 8) {
                    p.setNIF(letraDNI(Integer.parseInt(DNI)));
                    p.actualiza(oos);
                }
                else {
                    p.actualiza(oos);
                }
                p =(Persona)ois.readObject();
            }
        }
        
        catch (ClassNotFoundException e) {
            System.out.println("error --> " + e);
        }
        catch (FileNotFoundException e) {
            System.out.println("error --> " + e);
        }
        catch (EOFException e) {
            System.out.println("Actualización realizada");
        }
        catch (IOException e) {
            System.out.println("error --> " + e);
        }     
    }
    
    public static String letraDNI(int dni) {
        String letrasDNI = "TRWAGMYFPDXBNJZSQVHLCKE";
        return String.valueOf(dni) + letrasDNI.charAt(dni % 23);
    }
}
