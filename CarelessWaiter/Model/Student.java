package Model;

public class Student {

    private String surname;
    private String name;
    private String fatherName;
    private String city;
    private String street;
    private String house;
    private int family;
    private double area;
    private double MinArea;
    private double MaxArea;
    private double perarea;

    public Student() {
        surname = "";
        name = "";
        fatherName = "";
        city = "";
        street = "";
        house = "";
        family = 0;
        area = 0.0;
        MinArea = 0.0;
        MaxArea = 0.0;
        perarea = 0.0;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String FIO() {
        return surname + " " +
                name + " " +
                fatherName;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHouse() {
        return house;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String Adress() {
        return "Город " + city + ", ул. " +
                street + ", " +
                house;
    }

    public void setFamily(int family) {
        this.family = family;
    }

    public int getFamily() {
        return family;
    }

    public void setMinArea(double MinArea) {
        this.MinArea = MinArea;
    }

    public double getMinArea()  {
        return MinArea;
    };

    public void setArea(double area) {
        this.area = area;
    }

    public double getArea() {
        return area;
    }

    public void setMaxArea(double MaxArea) {
        this.MaxArea = MaxArea;
    }

    public double getMaxArea()  {
        return MaxArea;
    };

    public void setPerarea(double perarea) {
        this.perarea = perarea;
    }

    public double getPerarea() {
        return perarea;
    }

    public void setFullName(String surname, String name, String fatherName) {
        this.surname = surname;
        this.name = name;
        this.fatherName = fatherName;
    }

    public void setFullAdress(String city, String street, String house) {
        this.city = city;
        this.street = street;
        this.house = house;
    }

    public void clean() {
        surname = "";
        name = "";
        fatherName = "";
        family = 0;
        area = 0.0;
        MaxArea = 0.0;
        MinArea = 0.0;
        perarea = 0.0;
    }
}
