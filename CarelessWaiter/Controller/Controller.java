package Controller;

import Model.Dish;
import Model.DishBase;
import View.Form;
import View.MainFrame;
import View.Offer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Form form;
    private Offer offer;
    private MainFrame mainFrame;
    private DishBase dishBase;

    public Controller() {
        mainFrame = new MainFrame(this);
        //offer = new Offer(this.mainFrame, this);
        dishBase = new DishBase(this);
    }

    /*public void removeStudent(List<Dish> stud) {
        getDishBase().removeAll(dis);
    }*/

    public void addDish(Dish dish) {
        dishBase.add(dish);
    }

    public List<Dish> getDishBase() {
        return dishBase.getDishBase();
    }

    public void setFile(File file){
        dishBase.setFile(file);
    }

    public void toFile(File file){
        dishBase.toFile(file);
    }

    public void fromFile(){
        dishBase.fromFile();
        offer.update();
    }

    public List<Dish> chosedDish (Dish dish){
        List<Dish> searchDish = new ArrayList<>();
        List<Dish> allDish = new ArrayList<>();

        for (Dish dish1 : allDish){
            searchDish.add(dish1);
        }
        return searchDish;
    }

    /*public List<Dish> searchStudents (Dish searchStudent, String paramSearch) {
        List<Dish> searchStud = new ArrayList<>();
        List<Dish> allStudents = getStudentBase();

       if (paramSearch.equals("Family")) {
            for (Dish stud : allStudents) {
                if (stud.getSurname().equals(searchStudent.getSurname())
                        && (stud.getFamily() == (searchStudent.getFamily()))) {
                    searchStud.add(stud);
                }
            }
        }

       else if (paramSearch.equals("Area")) {
           for (Student stud : allStudents) {
               if (stud.getFamily() == searchStudent.getFamily()
                       && (stud.getArea() >= (searchStudent.getMinArea()))
                       && (stud.getArea() <= (searchStudent.getMaxArea())))
               {
                   searchStud.add(stud);
               }
           }
       }

       else if (paramSearch.equals("Surname")) {
            for (Student stud : allStudents) {
                if (stud.getSurname().equals(searchStudent.getSurname())
                        && (stud.getArea() >= (searchStudent.getMinArea()))
                        && (stud.getArea() <= (searchStudent.getMaxArea())))
                {
                    searchStud.add(stud);
                }
            }
        }

       else if (paramSearch.equals("Perarea")) {
           for (Student stud : allStudents) {
               if ((stud.getPerarea() >= (searchStudent.getPerarea())))
               {
                   searchStud.add(stud);
               }
           }
       }

        return searchStud;
    }*/

    public void alertMessage(String text){
        mainFrame.alertMessage(text);
    }
}
