package BE;

import javafx.scene.image.Image;

public class Student  {
    private int id ;
    private String name ;
    private String email ;
    private int telephone ;
    private long cpr ;
    private Image image ;
    private String address ;
    private int attendance ;
        // there is chance to extends the department class to the studnet to add data to it

    public Student(int id, String name, String email, int telephone, long cpr, Image image, String address,int attendance) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.cpr = cpr;
        this.image = image;
        this.address = address;
        this.attendance = attendance;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public long getCPR() {
        return cpr;
    }

    public void setCPR(long CPR) {
        this.cpr = CPR;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", telephone=" + telephone +
                ", CPR=" + cpr +
                ", image=" + image +
                ", address='" + address + '\'' +
                '}';
    }
}
