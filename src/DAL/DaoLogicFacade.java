package DAL;

import BE.Department;
import BE.Student;
import javafx.scene.image.Image;

import java.util.List;

public interface DaoLogicFacade {
    // ------------Student---------------
   public List<Student> getAllStudents();

   public Student createStudent(String name, String email, int telephone, long CPR, Image image, String address);

   public Student updateStudent(Student editedstudnet ,String name, String email, int telephone, long CPR, Image image, String address );

   public void deleteStudent(Student selectedStudnet);

   //----------------Department---------------

    public List<Department> getAllDepartments();

    public Department createDepartment(String name);

    public Department updateDepartment(Department editeddepartment, String name);

    public void deleteDepartment(Department department);

    //------------------Department-Studnet----------

    public int getscore (int id);

    public void signin(Department selectedDepartment , Student selectedStudent);

}
