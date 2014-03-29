/**
 * Redefinicion de la clase ObjectOutputStream para que no escriba una cabecera
 * al principio del Stream.
 */
package programacion2_2013_2014_entrega1;

import java.io.*;


public class AdicionObjectOutputStream extends ObjectOutputStream {
    /** Constructor que recibe OutputStream
     * @param out
     * @throws java.io.IOException */
    public AdicionObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    /** Constructor sin parÃ¡metros
     * @throws java.io.IOException */
    protected AdicionObjectOutputStream() throws IOException, SecurityException {
        super();
    }

    /** RedefiniciÃ³n del mÃ©todo de escribir la cabecera para que no haga nada.
     * @throws java.io.IOException */
    @Override
    protected void writeStreamHeader() throws IOException {
    }
}