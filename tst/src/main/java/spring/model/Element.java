package spring.model;

import javax.persistence.*;

@Entity
public class Element {
    // region variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    // endregion

    public Element() {
    }

    public Element(String name){
        this.name = name;

//        ElementThread eThread = new ElementThread(this);
//        eThread.start();
    }

    // region getters and setters
    public int getId() {
        return id;
    }

    public Element setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Element setName(String name) {
        this.name = name;
        return this;
    }
    // endregion

    @Override
    public String toString() {
        return "Element{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
