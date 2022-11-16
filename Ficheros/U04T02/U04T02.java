import java.io.File;

import java.io.IOException;

public class U04T02 {

    public static void main(String[] args) throws IOException {

        

        File f = new File("penyagolosa.bmp");

        

        TransformaImagen ti = new TransformaImagen(f);

        
        ti.transformaNegativo();
        
        ti.transformaOscuro();

        ti.transformaBlancoNegro();

    }

}