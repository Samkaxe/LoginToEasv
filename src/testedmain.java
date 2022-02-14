import BE.Student;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class testedmain {
    public static void main(String[] args) {

        java.util.Date Ust = new Date();
        java.sql.Date date = new java.sql.Date(Ust.getTime());

       SimpleDateFormat dayformat = new SimpleDateFormat("E");
       String d = dayformat.format(Calendar.getInstance().getTime());
        System.out.println(d);
        if(d.equals("Mon"))
            System.out.println(d);
        //calendar.add(Calendar.YEAR, -2);

      //  Date d1 = calendar.getTime();



    }
}
