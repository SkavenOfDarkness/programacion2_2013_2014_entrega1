/*
 *  CLASE Persona
 */

package programacion2_2013_2014_entrega1;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Persona implements Serializable {
    static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
    private String NIF;
    private String nombre;
    private int edad;

    public Persona()  {
        String entrada;
        try {
            System.out.print("INTRODUCE NIF: ");
            NIF = teclado.readLine();
            System.out.print("INTRODUCE NOMBRE: ");
            nombre = teclado.readLine();
            System.out.print("INTRODUCE EDAD: ");
            entrada = teclado.readLine();
            edad = Integer.parseInt(entrada);
        }
        catch (IOException error) {
            System.err.println("ERROR "+ error.toString());
        }
    }
    
    public Persona(String NIF, String nombre,int edad) {
        this.NIF = NIF;
        this.nombre = nombre;
        this.edad = edad;
    }
 
    @Override
    public String toString() {
        String cadena="";
        cadena=("NIF: " + NIF + " || Nombre: " + nombre + "  || edad: " +
                edad);
        return cadena;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }
    
    public String getNif() {
        return NIF;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
    
    public void actualiza(ObjectOutputStream oos) {
        Persona actu = new Persona(NIF, nombre, edad);
        try {
            oos.writeObject(actu);
        }
        catch (IOException e) {
            System.out.println("error --> " + e);
        }
    }
}
