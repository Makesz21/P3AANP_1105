package domp3aanp;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomParserP3AANP {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("student.xml"));

        document.getDocumentElement().normalize();

        System.out.println("root element : " + document.getDocumentElement().getNodeName());
        System.out.println("---------------------");

        NodeList nodes = document.getElementsByTagName("student");

        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            Element element = (Element) node;

            System.out.println("\ncurrent element : " + node.getNodeName());
            System.out.println("student roll no : " + element.getAttribute("rollno"));

            NodeList childNodes = element.getChildNodes();

            for (int j = 0; j < childNodes.getLength(); j++) {
                Node childNode = childNodes.item(j);

                if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                    System.out.println(childNode.getNodeName() + " : " + childNode.getTextContent());
                }
            }
        }
    }
}