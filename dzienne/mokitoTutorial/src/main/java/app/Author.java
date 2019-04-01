package app;

/**
 * Created by Krzysztof Podlaski on 04.03.2019.
 */
public class Author {
    private int id;
    private String name;

    public Author(String name) {
        this.id = -1;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }
}
