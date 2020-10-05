package pack.company;

import javax.persistence.*;

@Entity
public class StaffMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private StaffRole role;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StaffRole getRole() {
        return role;
    }

    public void setRole(StaffRole role) {
        this.role = role;
    }
}
