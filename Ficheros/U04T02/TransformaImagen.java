import java.io.File;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class TransformaImagen {

    File f = null;

    byte[] primerosBytes = new byte[53]; // Primeros 54 bytes.

    byte[] datosPixeles; // El resto del archivo.

    byte[] datosTrabajo;

    public TransformaImagen(File fEnt) throws IOException {

        // Control de existencia del fichero y control de la extensión .bmp (sacar mensajes de error)

        if (fEnt.exists()) {

            System.out.println("File exists.");
            f = fEnt;
            cargarImagen();

            for (int i = 0; i < 100; i++){

                System.out.println(datosPixeles[i]);

            }

        } else {

            System.out.println("[ERROR] File does not exist.");

        }

    }

    private void cargarImagen() throws IOException {

        FileInputStream archivo = new FileInputStream(f);

        // Cargar los primeros 54 bytes.

        for (int i = 0; i < 53; i++) {

            primerosBytes[i] = (byte) archivo.read();

        }

        // Cargar los datos de los pixeles.

        int valor = archivo.read();

        datosPixeles = new byte[archivo.available() - 54];
        datosTrabajo = new byte[archivo.available() - 54];

        for (int i = 0; i < archivo.available() - 54; i++) {

            datosPixeles[i] = (byte) archivo.read();

        }

        archivo.close();

    }

    private void guardarImagen(String nombre) throws IOException {

        FileOutputStream archivo = new FileOutputStream(nombre+".bmp");
        
        for (byte i: primerosBytes) {

            archivo.write(i);

        }

        for (byte i: datosTrabajo) {

            archivo.write(i);

        }

        archivo.close();

    }

    public void transformaNegativo() throws IOException {

        for (int i = 0; i < datosPixeles.length; i++) {

            datosTrabajo[i] = (byte) (255 - datosPixeles[i]);

        }

        guardarImagen(getNombreSinExtension(f.getName()) + "_n");

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

