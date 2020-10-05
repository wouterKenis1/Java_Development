package pack.library;

import pack.education.School;
import pack.education.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Set;

public class GetReader {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try{
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            Reader reader = em.find(Reader.class,1L);
            Set<Magazine> magazines = reader.getMagazines();

            System.out.println("Reader: " + reader.getName());
            System.out.println("Magazines:");
            for (Magazine magazine: magazines) {
                System.out.println("Id: " + magazine.getId() + "\tTitle: " + magazine.getTitle());
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
