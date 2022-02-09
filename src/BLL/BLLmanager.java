package BLL;

import BE.Department;
import BE.Student;
import DAL.DaoManager;
import javafx.scene.image.Image;

import java.util.List;

public class BLLmanager implements BLLLogicFacade{

        private final DaoManager daoManager ;

    public BLLmanager() {
        daoManager = new DaoManager();
    }

    @Override
    public List<Student> getAllStudnets() {

        return daoManager.getAllStudents();
    }

    @Override
    public Student addStudnet(String name, String email, int telephone, long CPR, Image image, String address) {
        return daoManager.createStudent( name,email,telephone,CPR,image,address);
    }

    @Override
    public void updateStudnet(Student student, String name, String email, int telephone, long CPR, Image image, String address) {
        daoManager.updateStudent(student,name,email,telephone,CPR,image,address);
    }

    @Override
    public void deleteStudent(Student selectedStudnet) {
        daoManager.deleteStudent(selectedStudnet);
    }

    @Override
    public List<Department> getAllDepartment() {

        return daoManager.getAllDepartments();
    }

    @Override
    public Department addDeparment(String name) {
        return daoManager.createDepartment(name);
    }

    @Override
    public void deleteDepartment(Department department) {
        daoManager.deleteDepartment(department);
    }

    @Override
    public void signStudnettoDepartment(Department department, Student student) {

    }

    @Override
    public int getscore(int id) {
        return 0;
    }
}
