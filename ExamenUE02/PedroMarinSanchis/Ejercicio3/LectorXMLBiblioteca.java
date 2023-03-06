package PedroMarinSanchis.Ejercicio3;

import java.io.File;
import PedroMarinSanchis.Ejercicio2.Biblioteca.Video.Saga;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import PedroMarinSanchis.Ejercicio2.Biblioteca.Video.Movie;

public class LectorXMLBiblioteca {

    public static Saga cargarSaga(String titulo, File fuente) throws Exception {
        Saga saga = null;
        Document xml = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(fuente);
        Element root = xml.getDocumentElement(); // Root element.
        NodeList sagas = root.getElementsByTagName("saga");

        for (int i = 0; i < sagas.getLength(); i++) {
            if (sagas.item(i).getAttributes().item(0).getNodeValue().equalsIgnoreCase(titulo)) { // Comprobar el título.
                Element sagaElement = (Element)sagas.item(i);
                NodeList ejemplares = sagaElement.getElementsByTagName("pelicula");
                Movie[] movieArray = getMovieArray(ejemplares);
                saga = new Saga(titulo, movieArray);
            }
        }
        return saga;
    }

    private static Movie[] getMovieArray(NodeList ejemplares) {
        Movie[] movieArray = new Movie[ejemplares.getLength()];

        for (int j = 0; j < ejemplares.getLength(); j++) {

            Element currentelement = (Element) ejemplares.item(j);
            String title = currentelement.getAttributes().getNamedItem("titulo").getNodeValue();
            int duration = Integer.parseInt(currentelement.getElementsByTagName("duracion").item(0).getTextContent());
            int[] releases = new int[1];
            releases[0] = Integer.parseInt(currentelement.getElementsByTagName("fecha").item(0).getTextContent());
            String director = currentelement.getElementsByTagName("director").item(0).getTextContent();
            int order = Integer.parseInt(currentelement.getElementsByTagName("orden").item(0).getTextContent());

            movieArray[j] = new Movie(title, duration, releases, director, order);
        }
        return movieArray;
    }

}
