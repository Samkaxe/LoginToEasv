package BE;

public class Department {
    private int id ;
    private String name ;
    private int score ;

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
        this.score = score;

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

    @Override
    public String toString() {
        return  name ;
    }
}
