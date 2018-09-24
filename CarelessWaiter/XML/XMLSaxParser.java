package XML;

import Model.Student;
import Model.StudentBase;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

import java.util.ArrayList;
import java.util.List;

public class XMLSaxParser extends DefaultHandler {
    private Student student;
    private StudentBase studentBase;
    private List<Student> studentList;
    private String currentElement;
    private StringBuilder content;

    public XMLSaxParser() {
        studentList = new ArrayList<>();
        currentElement = "";
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Начинаем парсить");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Закончили парсить");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attr) {
        currentElement = qName;
        if (currentElement.equals("student")) {
            student = new Student();
            studentList.add(student);
            System.out.println("Новый студент добавлен ура!");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        content = new StringBuilder(new String(ch, start, length));
    }

    @Override
    public void endElement(String uri, String localName, String qName) {

        if (currentElement.equals("surname")) {
            student.setSurname(content.toString());
            return;
        }
        if (currentElement.equals("name")) {
            student.setName(content.toString());
            return;
        }
        if (currentElement.equals("fatherName")) {
            student.setFatherName(content.toString());
            return;
        }
        if (currentElement.equals("city")) {
            student.setCity(content.toString());
            return;
        }
        if (currentElement.equals("street")) {
            student.setStreet(content.toString());
            return;
        }
        if (currentElement.equals("house")) {
            student.setHouse(content.toString());
            return;
        }
        if (currentElement.equals("family")) {
            student.setFamily(Integer.parseInt(content.toString()));
            return;
        }
        if (currentElement.equals("area")) {
            if(content.toString().contains("\t") || content.toString().contains("\n")) return;
            student.setArea(Double.parseDouble(content.toString()));
            return;
        }
        if (currentElement.equals("perarea")) {
            if(content.toString().contains("\t") || content.toString().contains("\n")) return;
            student.setPerarea(Double.parseDouble(content.toString()));
            return;
        }
    }
    public void setBase(StudentBase studentBase) {
        this.studentBase = studentBase;
    }
}