package PedroMarinSanchis.Ejercicio4;

import java.io.File;
import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import PedroMarinSanchis.Ejercicio2.Biblioteca.Video.Movie;
import PedroMarinSanchis.Ejercicio2.Biblioteca.Video.Saga;

public class ExportadorDeSagasXML {

    public static void exportarSaga(Saga saga, File file) throws Exception {

        // Generate XML document in memory.
        Document XMLDocument = generateXMLDocument(sortMovies(saga.getMovies()));
    
        // Transform and export to file from XMLDocument in memory.
        Transformer transformerClass = TransformerFactory.newInstance().newTransformer();
        transformerClass.setOutputProperty(OutputKeys.INDENT, "yes");
    
        DOMSource sourceDocument = new DOMSource(XMLDocument);
    
        StreamResult streamResultClass = new StreamResult(new FileOutputStream(file));
        transformerClass.transform(sourceDocument, streamResultClass);
    
    }
    
    private static Movie[] sortMovies(Movie[] movies) {
        return movies; //TODO: SORTING.
    }

    private static Document generateXMLDocument(Movie[] movies) throws Exception {
    
        Document XMLDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element rootElement = XMLDocument.createElement("saga"); // Root element.
        XMLDocument.appendChild(rootElement);
    
        for (Element i: generateMovieElements(movies, XMLDocument)) {
    
            rootElement.appendChild(i); 
    
        }
    
        return XMLDocument;
    
    }
    
    private static Element[] generateMovieElements(Movie[] movies, Document XMLDocument) {

        Element[] elements = new Element[movies.length];

        for (int i = 0; i < movies.length; i++) {
            Element pelicula = XMLDocument.createElement("pelicula");
            Element director = XMLDocument.createElement("director");
            Element fecha = XMLDocument.createElement("fecha");
            Element duracion = XMLDocument.createElement("duracion");
            Element orden = XMLDocument.createElement("orden");
    
            pelicula.setAttribute("titulo", movies[i].getTitle());
            director.setTextContent(movies[i].getDirector());
            fecha.setTextContent(Integer.toString(movies[i].getRelease()));
            duracion.setTextContent(Integer.toString(movies[i].getDurationInMinutes()));
            orden.setTextContent(Integer.toString(movies[i].getOrder()));

            pelicula.appendChild(director);
            pelicula.appendChild(fecha);
            pelicula.appendChild(duracion);
            pelicula.appendChild(orden);

            elements[i] = pelicula;
        }

        return elements;

    }
}
