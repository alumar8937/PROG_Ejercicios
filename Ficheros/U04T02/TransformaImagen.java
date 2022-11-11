import java.io.File;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class TransformaImagen {

    File f = null;

    char[] primerosBytes; // Primeros 54 bytes.

    char[] datosPixeles; // El resto del archivo.

    public TransformaImagen(File fEnt) throws IOException {

        // Control de existencia del fichero y control de la extensión .bmp (sacar mensajes de error)

        if (fEnt.exists()) {

            System.out.println("File exists.");
            f = fEnt;
            cargarImagen();

        } else {

            System.out.println("[ERROR] File does not exist.");

        }

    }

    private void cargarImagen() throws IOException {

        FileReader archivo = new FileReader(f);

        // Cargar los primeros 54 bytes.

    }

    public void transformaNegativo() throws IOException {

        // Transformar a negativo y guardar como *_n.bmp

    }


    public void transformaOscuro() throws IOException {

        // Transformar a una imagen más oscura y guardar como *_o.bmp

        

    }

    
    public void transformaBlancoNegro() throws IOException {

        // Transformar a una imagen en blanco y negro y guardar como *_bn.bmp

    }


    private String getNombreSinExtension(String nombre) {

        //Devuelve el nombre del archivo f sin extensión
        return nombre.substring(0, nombre.lastIndexOf("."));
        

    }

}

