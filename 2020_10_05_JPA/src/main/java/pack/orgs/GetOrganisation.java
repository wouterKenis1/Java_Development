package pack.orgs;

import pack.library.Magazine;
import pack.library.Reader;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Set;

public class GetOrganisation {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try{
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            Organisation org = em.find(Organisation.class, 1L);
            Set<Member> members = org.getMembers();

            System.out.println("Organisation: " + org.getName());
            System.out.println("Members: ");
            for (Member member : members){
                System.out.println("Id: " + member.getId() + "\tName: " + member.getName());
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
