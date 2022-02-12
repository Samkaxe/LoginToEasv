package DAL;

import BE.Department;
import BE.Student;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class DaoManager implements DaoLogicFacade {

     private  ArrayList<Student> students ;
     private ArrayList<Department> departments ;

    @Override
    public List<Student> getAllStudents() {
        students = new ArrayList<>();
        Student student1 = new Student(1,"zahra","zahra@gmail.com", 123456,1527141212,null,null,"majlbevij13",0,0,0,0);
        Student student2 = new Student(2,"imad","zahra@gmail.com", 123456,1527141212,null,null,"majlbevij13",0,0,0,0);
        Student student3 = new Student(3,"peter","zahra@gmail.com", 123456,1527141212,null,null,"majlbevij13",0,0,0,0);
        Student student4 = new Student(4,"trine","zahra@gmail.com", 123456,1527141212,null,null,"majlbevij13",0,0,0,0);
        Student student5 = new Student(5,"george","zahra@gmail.com", 123456,1527141212,null,null,"majlbevij13",0,0,0,0);
        Student student6 = new Student(6,"matt","zahra@gmail.com", 123456,1527141212,null,null,"majlbevij13",0,0,0,0);

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);
        return students;
    }

    @Override
    public Student createStudent(String name, String email, int telephone, int CPR, Image image, String address) {

        Student createdstudent  = new Student(1,name,email,telephone,CPR,image,null,address,0,0,0,0);

         return createdstudent;
    }

    @Override
    public Student updateStudent(Student editedstudnet, String name, String email, int telephone, int CPR, Image image, String address) {
       editedstudnet = new Student(0,name ,email,telephone,CPR,image,null,address,0,0,0,0);
        return editedstudnet ;
    }

    @Override
    public void deleteStudent(Student selectedStudnet) {
        students.remove(selectedStudnet);
    }

    @Override
    public List<Department> getAllDepartments() {
        departments = new ArrayList<>();
        Department department1 = new Department(1,"ITO",0);
        Department department2 = new Department(2,"SCO",0);
        Department department3 = new Department(3,"SDE",0);
        Department department4 = new Department(4,"DBOS",0);
        departments.add(department1);
        departments.add(department2);
        departments.add(department3);
        departments.add(department4);

        return departments;
    }

    @Override
    public Department createDepartment(String name) {
        Department department = new Department(1,name,0);

        return department;
    }

    @Override
    public Department updateDepartment(Department editeddepartment,String name) {
        editeddepartment = new Department(1 , name,0);
        return editeddepartment;
    }

    @Override
    public void deleteDepartment(Department department) {
        departments.remove(department);

    }

    @Override
    public int getscore(int id) {
        // this method should return the score of student  attendance
        // require joints to the table that hold the relationship bewteen department and student
        return 0;
    }

    @Override
    public void signin(Department selectedDepartment, Student selectedStudent) {
        // this method add studnet to selected department
        // for everytime student sign in it add score of 1

    }
}
