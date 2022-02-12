package BLL;

import BE.Department;
import BE.Student;
import javafx.scene.image.Image;

import java.util.List;

public interface BLLLogicFacade {

    List<Student> getAllStudnets();

    Student addStudnet(String name, String email, int telephone, int CPR, Image image, String address) ;

    void updateStudnet(Student student, String name, String email, int telephone, int CPR, Image image, String address) ;

    void deleteStudent(Student selectedStudnet);

    List<Department> getAllDepartment() ;

    Department addDeparment(String name);

    void deleteDepartment(Department department);

    void signStudnettoDepartment(Department department, Student student) ;

    int getscore(int id);
}
