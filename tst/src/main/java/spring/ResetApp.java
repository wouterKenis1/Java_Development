package spring;

import spring.model.Element;
import spring.model.Equation;
import spring.repository.ElementRepo;
import spring.repository.EquationRepo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.math.BigInteger;
import java.util.List;

public class ResetApp {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try{
            emf = Persistence.createEntityManagerFactory("mysqlcontainerdropcreate");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            // make basic elements
            tx.begin();
            Element air = new Element("air");
            em.persist(air);
            Element water = new Element("water");
            em.persist(water);
            Element fire = new Element("fire");
            em.persist(fire);
            Element earth = new Element("earth");
            em.persist(earth);
            tx.commit();

            // make steam (delete this section in final release)
            tx.begin();
            Element steam = new Element("steam");
            em.persist(steam);
            tx.commit();

            tx.begin();
            Equation steamEquation = new Equation(false);
            steamEquation.setParent1(water);
            steamEquation.setParent2(fire);
            steamEquation.setChild(steam);
            steamEquation.setNewElement(true);
            em.persist(steamEquation);
            tx.commit();

            System.out.println("database was reset!");

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
