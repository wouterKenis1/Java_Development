package pack.orgs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;

public class SaveOrganisation {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mysqlcontainerdropcreate");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            Organisation organisation = new Organisation();
            organisation.setName("G2 Esports");

            Member member1 = new Member();
            member1.setName("Wunder");
            Member member2 = new Member();
            member2.setName("Jankos");
            Member member3 = new Member();
            member3.setName("Caps");
            Member member4 = new Member();
            member4.setName("Perkz");
            Member member5 = new Member();
            member5.setName("Mikyx");

            Set<Organisation> organisations = new HashSet<>();
            organisations.add(organisation);
            Set<Member> members = new HashSet<>();
            members.add(member1);
            members.add(member2);
            members.add(member3);
            members.add(member4);
            members.add(member5);

            organisation.setMembers(members);
            member1.setOrganisations(organisations);
            member2.setOrganisations(organisations);
            member3.setOrganisations(organisations);
            member4.setOrganisations(organisations);
            member5.setOrganisations(organisations);

            em.persist(organisation);
            em.persist(member1);
            em.persist(member2);
            em.persist(member3);
            em.persist(member4);
            em.persist(member5);

            tx.commit();
            System.out.println("save succeeded!");

        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }

    }
}

