package pack.company;


import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(cascade = CascadeType.PERSIST)
    @MapKey(name="role")
    private Map<StaffRole,StaffMember> staff = new HashMap<>();

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<StaffRole, StaffMember> getStaff() {
        return staff;
    }

    public void setStaff(Map<StaffRole, StaffMember> staff) {
        this.staff = staff;
    }
}
