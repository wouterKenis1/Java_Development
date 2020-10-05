package pack.library;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;

public class SaveReader {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try{
            emf = Persistence.createEntityManagerFactory("mysqlcontainerdropcreate");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            Reader reader1 = new Reader();
            reader1.setName("Wouter");
            Magazine magazine1 = new Magazine();
            magazine1.setTitle("Eragon");
            Magazine magazine2 = new Magazine();
            magazine2.setTitle("Eldest");
            Magazine magazine3 = new Magazine();
            magazine3.setTitle("Brisingr");
            Magazine magazine4 = new Magazine();
            magazine4.setTitle("Inheritance");

            Set<Magazine> magazines = new HashSet<>();
            magazines.add(magazine1);
            magazines.add(magazine2);
            magazines.add(magazine3);
            magazines.add(magazine4);
            reader1.setMagazines(magazines);

            em.persist(reader1);
            em.persist(magazine1);
            em.persist(magazine2);
            em.persist(magazine3);
            em.persist(magazine4);
            tx.commit();
            System.out.println("save succeeded!");

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
