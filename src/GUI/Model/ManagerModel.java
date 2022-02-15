package GUI.Model;

import BE.Student;
import BLL.BLLmanager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class ManagerModel {


    private final ObservableList<Student> listofstudent;

    public ManagerModel(){

        listofstudent = FXCollections.observableArrayList();
        listofstudent.addAll(getallstudent());
    }
     public ArrayList<Student> getallstudent(){
        ArrayList<Student> getallstudent = new ArrayList<>();
         Image image1 = new Image("/tools/image/studnets/1.jpg");
         Image image2 = new Image("/tools/image/studnets/2.jpg");
         Image image3 = new Image("/tools/image/studnets/3.jpg");
         Image image4 = new Image("/tools/image/studnets/4.jpg");
         Image image5 = new Image("/tools/image/studnets/5.jpg");
         Image image6 = new Image("/tools/image/studnets/6.jpg");

         Student student1 = new Student(1,"imad","conteb@live.com",158692,19253881 ,image1,null,"sdasdd",15,5,4,0);
         Student student2 = new Student(2,"john","srour@yahoo.com",154726,19285425 ,image2,null,"sdasdd",13,4,2,1);
         Student student3 = new Student(3 ,"darwin","helger@icloud.com",245842,17914099  ,image3,null,"sdasdd",22,0,2,1);
         Student student4 = new Student(4,"miami","scarlet@live.com",694252,61589431  ,image4,null,"sdasdd",12,0,0,1);
         Student student5 = new Student(5,"sarah","hyper@live.com",254861,18497631 ,image5,null,"sdasdd",10,10,5,0);
         Student student6 = new Student(6,"Dan","yzheng@optonline.net",287465,91549940 ,image6,null,"sdasdd",13,4,2,1);

         getallstudent.add(student1);
         getallstudent.add(student2);
         getallstudent.add(student3);
         getallstudent.add(student4);
         getallstudent.add(student5);
         getallstudent.add(student6);

         return getallstudent;

     }


    public ObservableList<Student> getStudnets() {
        return listofstudent;
    }
}


