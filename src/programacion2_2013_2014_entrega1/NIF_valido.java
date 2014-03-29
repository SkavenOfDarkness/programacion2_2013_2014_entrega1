/**********************************************************************************
 * Realizar un programa que a demanda del mismo permita al usuario introducir     *
 * un NIF por teclado el cual será utilizado para buscar si en el fichero         *
 * perdonas.dat hay un objeto persona con dicho NIF. Si es afirmativa el objeto   *
 * persona será visualizado en pantalla, en caso negativo se visualizará "NIF no  *
 * localizado o no hay una persona con dicho NIF". En todo momento se ha de poder *
 * seguir introduciendo sucesivos NIF si se desea.                                *
 **********************************************************************************/

package programacion2_2013_2014_entrega1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;

public class NIF_valido {
    static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
    private static boolean terminar = false;
    
    public static void main(String[] arg) {
        ObjectInputStream ois = null;
        borrarPantalla();
        String NIF;
        while(!terminar) {
            try {
                ois = new ObjectInputStream(new FileInputStream("ficheros/personas.dat"));
                System.out.print("Introduzca el DNI a buscar: ");
                NIF = teclado.readLine();
                Persona p = (Persona)ois.readObject();
                while(p != null) {
                    if(p.getNif().equals(NIF)){
                        System.out.println(p.toString());
                        break;
                    }
                    p =(Persona)ois.readObject();
                }
                continuar();
            }
            catch (ClassNotFoundException e) {
                System.out.println("error --> " + e);
            }
            catch (IOException e) {
                System.out.println("NIF no encontrado");
                continuar();
            }
        }
    }

    private static void borrarPantalla() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }
    
    private static void continuar() {
        try {
            System.out.print("CONTINUAR (s/n): ");
            char car = (char)teclado.read();
            long saltarReturn = teclado.skip(1);
            if ((car=='n') || (car=='N')) {
                terminar = true;
            }
        } catch (IOException e) {
            System.out.println("error --> " + e);
        }
    }
    
}
