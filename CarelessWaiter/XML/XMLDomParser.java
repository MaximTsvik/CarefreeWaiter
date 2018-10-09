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

    public void write(File file, DishBase studentBase) {
        this.file = file;
        this.dishBase = dishBase;
        /*try {
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element list = document.createElement("list");

           /* for (int numOfDish = 0; numOfDish < studentBase.getDishBase().size(); numOfDish++) {
                Element dish = document.createElement("dish");
                dish.setAttribute("id", numOfDish + "");

                Element name = document.createElement("name");
                name.setTextContent(dishBase.getDishBase().get(numOfDish).getName());
                dish.appendChild(name);

                Element fatherName = document.createElement("fatherName");
                fatherName.setTextContent(studentBase.getStudentsBase().get(numOfStudent).getFatherName());
                student.appendChild(fatherName);

                Element city = document.createElement("city");
                city.setTextContent(studentBase.getStudentsBase().get(numOfStudent).getCity());
                student.appendChild(city);

                Element street = document.createElement("street");
                street.setTextContent(studentBase.getStudentsBase().get(numOfStudent).getStreet());
                student.appendChild(street);

                Element house = document.createElement("house");
                house.setTextContent(studentBase.getStudentsBase().get(numOfStudent).getHouse());
                student.appendChild(house);

                Element family = document.createElement("family");
                family.setTextContent(String.valueOf(studentBase.getStudentsBase().get(numOfStudent).getFamily()));
                student.appendChild(family);

                Element area = document.createElement("area");
                area.setTextContent(String.valueOf(studentBase.getStudentsBase().get(numOfStudent).getArea()));
                student.appendChild(area);

                Element perarea = document.createElement("perarea");
                perarea.setTextContent(String.valueOf(studentBase.getStudentsBase().get(numOfStudent).getPerarea()));
                student.appendChild(perarea);*/

         /*       list.appendChild(dish);
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
        }*/
    }
}
