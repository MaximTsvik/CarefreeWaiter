package XML;

import Model.DishBase;
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

public class XMLDomParser {
    private File file;
    private Document document;
    private DishBase dishBase;

    public void write(File file, DishBase dishBase) {
        this.file = file;
        this.dishBase = dishBase;
        try {
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element list = document.createElement("list");

            for (int numOfDish = 0; numOfDish < dishBase.getDishBase().size(); numOfDish++) {
                Element dish = document.createElement("dish");
                dish.setAttribute("id", numOfDish + "");

                Element name = document.createElement("name");
                name.setTextContent(dishBase.getDishBase().get(numOfDish).getName());
                dish.appendChild(name);

                Element category = document.createElement("category");
                category.setTextContent(dishBase.getDishBase().get(numOfDish).getCategory());
                dish.appendChild(category);

                Element value = document.createElement("value");
                value.setTextContent(String.valueOf(dishBase.getDishBase().get(numOfDish).getValue()));
                dish.appendChild(value);

                Element cost = document.createElement("cost");
                cost.setTextContent(String.valueOf(dishBase.getDishBase().get(numOfDish).getCost()));
                dish.appendChild(cost);

                list.appendChild(dish);
            }

            document.appendChild(list);
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult streamResult = new StreamResult(file);
            transformer.transform(source, streamResult);
        } catch (ParserConfigurationException ex) {
            String exText = ex.getMessage();
            dishBase.getController().alertMessage(exText);
        } catch (TransformerConfigurationException ex) {
            String exText = ex.getMessage();
            dishBase.getController().alertMessage(exText);
        } catch (TransformerException ex) {
            String exText = ex.getMessage();
            dishBase.getController().alertMessage(exText);
        }
    }
}
