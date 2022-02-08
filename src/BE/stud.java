package BE;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class stud extends Department {
    private int id ;
    private String name ;
    private String email ;
    private int telephone ;
    private int CPR ;
    private Image image ;
    private String address ;

    public stud(int id, String name,int score, int id1, String name1, String email, int telephone, int CPR, Image image, String address) {
        super(id, name, score);
        this.id = id1;
        this.name = name1;
        this.email = email;
        this.telephone = telephone;
        this.CPR = CPR;
        this.image = image;
        this.address = address;
    }
    public void me(){
        ArrayList<stud> studnets = new ArrayList();

    }
}
