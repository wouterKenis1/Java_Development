package pack.orgs;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToMany
    @JoinTable(
            name = "ORG_MEMBER",
            joinColumns = @JoinColumn(name = "MEM_ID"),
            inverseJoinColumns = @JoinColumn(name = "ORG_ID"))
    private Set<Organization> organizations = new HashSet<>();

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(Set<Organization> organizations) {
        this.organizations = organizations;
    }
}
