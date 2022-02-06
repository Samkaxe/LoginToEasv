package GUI.Model;

import javafx.scene.image.Image;

public class Student {
    private int id ;
    private String name ;
    private String email ;
    private int telephone ;
    private int CPR ;
    private Image image ;
    private String address ;

    public Student(int id, String name, String email, int telephone, int CPR, Image image, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.CPR = CPR;
        this.image = image;
        this.address = address;
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

    public int getCPR() {
        return CPR;
    }

    public void setCPR(int CPR) {
        this.CPR = CPR;
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
                ", CPR=" + CPR +
                ", image=" + image +
                ", address='" + address + '\'' +
                '}';
    }
}
