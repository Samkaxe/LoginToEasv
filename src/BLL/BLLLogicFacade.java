package BLL;

import BE.Department;
import BE.Student;
import javafx.scene.image.Image;

import java.util.List;

public interface BLLLogicFacade {

    public List<Student> getAllStudnets();

    public Student addStudnet(String name, String email, int telephone, int CPR, Image image, String address) ;

    public void updateStudnet(Student student,String name, String email, int telephone, int CPR, Image image, String address) ;

    public void deleteStudent(Student selectedStudnet);

    public  List<Department> getAllDepartment() ;

    public Department addDeparment(String name);

    public void deleteDepartment(Department department);

    public void signStudnettoDepartment(Department department , Student student) ;

    public int getscore (int id);
}
