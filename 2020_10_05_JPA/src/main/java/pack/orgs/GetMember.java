package pack.orgs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Set;

public class GetMember {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try{
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            Member member = em.find(Member.class, 1L);
            Set<Organisation> organisations = member.getOrganisations();

            System.out.println("Member: " + member.getName());
            System.out.println("Organisations: ");
            for (Organisation organisation : organisations){
                System.out.println("Id: " + organisation.getId() + "\tName: " + organisation.getName());
            }
            tx.commit();


        } finally{
            if(em != null){
                em.close();
            }
            if(emf != null){
                emf.close();
            }
        }
    }
}
