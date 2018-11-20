package XML;

import Model.DishBase;
import Model.Table;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;

public class XMLDomParser {
    private File file;
    private Document document;
    private Table table;

    public void write1(File file, Table table) {
        this.file = file;
        this.table = table;
        double allCost = 0;
        try {
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element list = document.createElement("list");

            for (int numOfDish = 0; numOfDish < table.dishBase.size(); numOfDish++) {
                Element dish = document.createElement("dish");
                dish.setAttribute("id", numOfDish + " ");

                Element name = document.createElement("name");
                name.setTextContent(table.dishBase.get(numOfDish).getName());
                dish.appendChild(name);

                Element cost = document.createElement("cost");
                cost.setTextContent(String.valueOf(table.dishBase.get(numOfDish).getCost()));
                dish.appendChild(cost);

                allCost += table.dishBase.get(numOfDish).getCost();

                list.appendChild(dish);
            }

            Element allCost1 = document.createElement("allCost");
            Element cost1 = document.createElement("cost");
            cost1.setTextContent(allCost + "");
            allCost1.appendChild(cost1);
            list.appendChild(allCost1);

            document.appendChild(list);

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult streamResult = new StreamResult(file);
            transformer.transform(source, streamResult);
        } catch (ParserConfigurationException ex) {
            String exText = ex.getMessage();
        } catch (TransformerConfigurationException ex) {
            String exText = ex.getMessage();
        } catch (TransformerException ex) {
            String exText = ex.getMessage();
        }
    }

    public void write2(File file, Table table) {
        this.file = file;
        this.table = table;
        try {
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element list = document.createElement("list");

            for (int numOfDish = 0; numOfDish < table.resultOfOffer.size(); numOfDish++) {
                Element dish = document.createElement("dish");
                dish.setAttribute("id", numOfDish + " ");

                Element name = document.createElement("name");
                name.setTextContent(table.resultOfOffer.get(numOfDish).getName());
                dish.appendChild(name);

                Element category = document.createElement("category");
                category.setTextContent(table.resultOfOffer.get(numOfDish).getCategory());
                dish.appendChild(category);

                Element value = document.createElement("value");
                value.setTextContent(String.valueOf(table.resultOfOffer.get(numOfDish).getValue()));
                dish.appendChild(value);

                Element cost = document.createElement("cost");
                cost.setTextContent(String.valueOf(table.resultOfOffer.get(numOfDish).getCost()));
                dish.appendChild(cost);

                list.appendChild(dish);
            }
            table.resultOfOffer = new ArrayList<>();
            document.appendChild(list);
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult streamResult = new StreamResult(file);
            transformer.transform(source, streamResult);
        } catch (ParserConfigurationException ex) {
            String exText = ex.getMessage();
        } catch (TransformerConfigurationException ex) {
            String exText = ex.getMessage();
        } catch (TransformerException ex) {
            String exText = ex.getMessage();
        }
    }
}
