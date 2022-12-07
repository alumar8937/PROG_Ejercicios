import java.io.File;
import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;

public class XMLPlayer {

    final private static String decimalSeparator = ",";

    // XML Tags.
    final private static String XMLTag_Root = "mundial";
    final private static String XMLTag_Selection = "seleccion";
    final private static String XMLTag_Country = "pais";
    //final private static String XMLTag_Manager = "entrenador"; // Unsused
    //final private static String XMLTag_Team = "plantilla"; // Unused
        // Player Tags.
    final private static String XMLTag_PlayerTag = "jugador";
    //final private static String XMLTag_countryID = ""; // Unused
    //final private static String XMLTag_countryName = ""; // Unused
    final private static String XMLTag_playerName = "nombre";
    final private static String XMLTag_birthYear = "nacimiento";
    final private static String XMLTag_playerHeight ="altura";
    final private static String XMLTag_club = "club";

    public static ArrayList<Player> loadXMLFile(File file) throws Exception {

        ArrayList<Player> list = new ArrayList<Player>(1);

        Document xml = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
        Element root = xml.getDocumentElement(); // Root element.
        NodeList selection = root.getElementsByTagName(XMLTag_Selection); // Get all teams.

        // Player class variables.

        int countryID;
        String countryName;
        String playerName;
        int birthYear;
        float playerHeight;
        String club;

        for (int i=0; i<selection.getLength(); i++) {

            Element currentSelection = (Element)selection.item(i);
            NodeList players = currentSelection.getElementsByTagName(XMLTag_PlayerTag);

            countryID = Integer.parseInt(currentSelection.getAttributes().item(0).getTextContent()); // Get country ID from selection attribute.
            countryName = currentSelection.getElementsByTagName(XMLTag_Country).item(0).getTextContent(); // Get country name from selection child element.

            for (int j = 0; i < players.getLength(); i++) {

                Element currentPlayer = (Element)players.item(i);

                playerName = currentPlayer.getElementsByTagName(XMLTag_playerName).item(0).getTextContent();
                birthYear = Integer.parseInt(currentPlayer.getElementsByTagName(XMLTag_birthYear).item(0).getTextContent());
                playerHeight = Float.parseFloat(currentPlayer.getElementsByTagName(XMLTag_playerHeight).item(0).getTextContent().replaceAll(decimalSeparator, "."));
                club = currentPlayer.getElementsByTagName(XMLTag_club).item(0).getTextContent();

                list.add(new Player(countryID, countryName, playerName, birthYear, playerHeight, club)); // Add Player to list.

            }

        }

        return list;

    }


    public static ArrayList<Player> appendXMLFile(ArrayList<Player> list, File file) throws Exception {

        for (Player i: loadXMLFile(file)) {

            list.add(i);

        }

        return list;

    }


    public static void exportXMLFile(ArrayList<Player> list, File file) throws Exception{

        ArrayList<Integer> selectionList = new ArrayList<Integer>(1);
        ArrayList<String> countryNameList = new ArrayList<String>(1);
        boolean isSelectionOnList = true;

        for (Player i: list) {

            isSelectionOnList = false;

            for (Integer j: selectionList) {

                if (i.getCountryID() == j) {
                    isSelectionOnList = true;
                }

            }

            if (!isSelectionOnList) {

                selectionList.add(i.getCountryID());
                countryNameList.add(i.getCountryName());

            }

        }

        Document XMLDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        XMLDocument.appendChild(XMLDocument.createElement(XMLTag_Root)); // Root element
        for (Integer i: selectionList) {

            XMLDocument.appendChild(XMLDocument.createElement(countryNameList.get(i)));

        }

        /*// Creamos un objeto vehiculo para incorporar al nuevo fichero XML
        Modelo modelo = new Modelo("rojo", "C40");
        Motor motor = new Motor("HD2.0","diesel", 118);
        Vehiculo vehiculo = new Vehiculo("Volvo", modelo, motor, "1234HJK", 10102);
        // Creamos el documento de trabajo
        // Incorporamos el elemento raíz al documento de trabajo
        doc.appendChild(root);
        // Creamos un nuevo nodo tipo element con etiqueta "vehiculo"
        Element vehiculoXml = doc.createElement("vehiculo");
        Element marcaXml = doc.createElement("marca");
        // Creamos el contenido de marcaXml como un TextNode y lo asociamos como hijo a marcaXml
        marcaXml.appendChild(doc.createTextNode(vehiculo.getMarca()));
        // Incorporamos marcaXml como hijo de vehiculoXml
        vehiculoXml.appendChild(marcaXml);
        // Incorporamos vehiculoXml como hijo de nuestro elemento raíz.
        root.appendChild(vehiculoXml);

        // Generación del fichero XML a partir del documento DOM en memoria
        // Instanciamos una clase que realizará la transformación.
        Transformer claseTransformadora = TransformerFactory.newInstance().newTransformer();
        // Instanciamos un objeto DOMSource a partir del Document
        DOMSource documentoOrigen = new DOMSource(doc);
        // Preparamos el flujo de salida
        StreamResult flujoSalida = new StreamResult(new FileOutputStream("./recursos/archivos/nuevaOferta.xml"));
        // Trasformamos el documentoOrigen y lo volcamos en el flujoSalida.
        claseTransformadora.transform(documentoOrigen, flujoSalida);*/

    }
    
}
