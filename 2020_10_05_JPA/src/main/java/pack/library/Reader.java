package pack.library;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToMany
    private Set<Magazine> magazines = new HashSet<>();

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Magazine> getMagazines() {
        return magazines;
    }

    public void setMagazines(Set<Magazine> magazines) {
        this.magazines = magazines;
    }
}
