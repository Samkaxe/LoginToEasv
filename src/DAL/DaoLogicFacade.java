package DAL;

import BE.Department;
import BE.Student;
import javafx.scene.image.Image;

import java.util.List;

public interface DaoLogicFacade {
    // ------------Student---------------
    List<Student> getAllStudents();

   Student createStudent(String name, String email, int telephone, int CPR, Image image, String address);

   Student updateStudent(Student editedstudnet, String name, String email, int telephone, int CPR, Image image, String address);

   void deleteStudent(Student selectedStudnet);

   //----------------Department---------------

    List<Department> getAllDepartments();

    Department createDepartment(String name);

    Department updateDepartment(Department editeddepartment, String name);

    void deleteDepartment(Department department);

    //------------------Department-Studnet----------

    int getscore(int id);

    void signin(Department selectedDepartment, Student selectedStudent);

}
