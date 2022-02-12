package BE;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.scene.image.Image;

import java.util.Date;

public class Student extends RecursiveTreeObject<Student> {
    private int id ;
    private String name ;
    private String email ;
    private int telephone ;
    private int cpr ;
    private Image image ;
    private String address ;
    private int totalscore;
    private int scoalt ;
    private int itoalt ;
    private int sdealt ;
    private Date signin ;
        // there is chance to extends the department class to the studnet to add data to it

    public Student(int id, String name, String email, int telephone, int cpr, Image image,Date signin, String address,int scoalt, int itoalt,int sdealt,int totalscore) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.cpr = cpr;
        this.image = image;
        this.address = address;
        this.totalscore = totalscore;
        this.scoalt = scoalt ;
        this.sdealt = sdealt ;
        this.itoalt = itoalt ;
        this.signin = signin ;
     }

    public Date getSignin() {
        return signin;
    }

    public void setSignin(Date signin) {
        this.signin = signin;
    }

    public int getScoalt() {
        return scoalt;
    }

    public void setScoalt(int scoalt) {
        this.scoalt = scoalt;
    }

    public int getItoalt() {
        return itoalt;
    }

    public void setItoalt(int itoalt) {
        this.itoalt = itoalt;
    }

    public int getSdealt() {
        return sdealt;
    }

    public void setSdealt(int sdealt) {
        this.sdealt = sdealt;
    }

    public int getCpr() {
        return cpr;
    }

    public void setCpr(int cpr) {
        this.cpr = cpr;
    }

    public int getTotalscore() {
        return totalscore;
    }

    public void setTotalscore(int totalscore) {
        this.totalscore = totalscore;
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
                ", cpr=" + cpr +
                ", image=" + image +
                ", address='" + address + '\'' +
                ", totalscore=" + totalscore +
                ", scoalt=" + scoalt +
                ", itoalt=" + itoalt +
                ", sdealt=" + sdealt +
                '}';
    }
}
