import java.io.File;
import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;

public class XMLPlayer {

    final private static String decimalSeparator = ",";

    // XML Tags.
    final private static String XMLTag_Root = "mundial";
    final private static String XMLTag_Selection = "seleccion";
    final private static String XMLTag_Country = "pais";
    final private static String XMLTag_Manager = "entrenador";
    final private static String XMLTag_Team = "plantilla";
        // Player Tags.
    final private static String XMLTag_PlayerTag = "jugador";
    //final private static String XMLTag_countryID = ""; // Unused
    //final private static String XMLTag_countryName = ""; // Unused
    final private static String XMLTag_playerName = "nombre";
    final private static String XMLTag_birthYear = "nacimiento";
    final private static String XMLTag_playerHeight ="altura";
    final private static String XMLTag_club = "club";
    final private static String XMLTag_playerNumber = "dorsal";
    final private static String XMLTag_position = "demarcación";

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

            for (int j = 0; j < players.getLength(); j++) {

                Element currentPlayer = (Element)players.item(j);

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


    public static void exportXMLFile(ArrayList<Player> list, File file) throws Exception {

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
        Element rootElement = XMLDocument.createElement(XMLTag_Root); // Root element
        XMLDocument.appendChild(rootElement);
        for (int i = 0; i < selectionList.size(); i++) {

            Element selection = XMLDocument.createElement(XMLTag_Selection);
            Element country = XMLDocument.createElement(XMLTag_Country);
            Element manager = XMLDocument.createElement(XMLTag_Manager);
            Element team = XMLDocument.createElement(XMLTag_Team);

            selection.appendChild(country);
            selection.appendChild(manager);
            selection.appendChild(team);

            selection.setAttribute("id", Integer.toString(selectionList.get(i)));
            country.setAttribute(XMLTag_Country, countryNameList.get(i));

            for (Player j: list) {

                if (j.getCountryID() == selectionList.get(i)) {

                    Element player = XMLDocument.createElement(XMLTag_PlayerTag);
                    Element name = XMLDocument.createElement(XMLTag_playerName);
                    Element birthYear = XMLDocument.createElement(XMLTag_birthYear);
                    Element height = XMLDocument.createElement(XMLTag_playerHeight);
                    Element number = XMLDocument.createElement(XMLTag_playerNumber);
                    Element club = XMLDocument.createElement(XMLTag_club);

                    team.appendChild(player);

                    player.setAttribute(XMLTag_position, "");
                    player.appendChild(name);
                    player.appendChild(birthYear);
                    player.appendChild(height);
                    player.appendChild(number);
                    player.appendChild(club);

                    name.setTextContent(j.getPlayerName());
                    birthYear.setTextContent(Integer.toString(j.getBirthYear()));
                    height.setTextContent(Float.toString(j.getPlayerHeight()));
                    number.setTextContent("");
                    club.setTextContent(j.getClub());

                }

            }

            rootElement.appendChild(selection);

        }

        // Generación del fichero XML a partir del documento DOM en memoria
        // Instanciamos una clase que realizará la transformación.
        Transformer transformerClass = TransformerFactory.newInstance().newTransformer();
        transformerClass.setOutputProperty(OutputKeys.INDENT, "yes");
        // Instanciamos un objeto DOMSource a partir del Document
        DOMSource sourceDocument = new DOMSource(XMLDocument);
        // Preparamos el flujo de salida
        StreamResult streamResultClass = new StreamResult(new FileOutputStream(file));
        // Trasformamos el documentoOrigen y lo volcamos en el flujoSalida.
        transformerClass.transform(sourceDocument, streamResultClass);

    }
    
}
