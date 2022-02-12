import BE.Student;

import java.sql.Time;
import java.util.Date;

public class testedmain {
    public static void main(String[] args) {

        java.util.Date Ust = new Date();
        java.sql.Date date = new java.sql.Date(Ust.getTime());

        System.out.println(date);
        Student student1 = new Student(1,"imad","conteb@live.com",158692,19253881 ,null,date,"sdasdd",3,5,0,0);

    }
}
