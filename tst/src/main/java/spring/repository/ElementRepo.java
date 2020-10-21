package spring.repository;

import org.springframework.context.annotation.Bean;
import spring.model.Element;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;


public class ElementRepo {

    public void saveElement(Element element){
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try{
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(element);
            tx.commit();
            System.out.println("elements saved!");

        } finally{
            if(em != null){
                em.close();
            }
            if(emf != null){
                emf.close();
            }
        }
    }

    public void saveElement(String name){
        Element element = new Element(name);
        saveElement(element);
    }

    public void deleteElement(Element element){
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try{
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.remove(element);
            tx.commit();
            System.out.println("element deleted!");

        } finally{
            if(em != null){
                em.close();
            }
            if(emf != null){
                emf.close();
            }
        }
    }

    public List<Element> getAllElements(){
        EntityManagerFactory emf = null;
        EntityManager em = null;
        List<Element> outElements = null;

        try {
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            String sqlString = "select e from Element e";
            TypedQuery<Element> query = em.createQuery(sqlString,Element.class);
            outElements = query.getResultList();

            tx.commit();
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
        return outElements;
    }

    public List<Element> getStartElements(){
        EntityManagerFactory emf = null;
        EntityManager em = null;
        List<Element> outElements = null;

        try {
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            String sqlString = "select e from Element e where e.id <= 4"; // return the basic 4 elements
            TypedQuery<Element> query = em.createQuery(sqlString,Element.class);
            outElements = query.getResultList();

            tx.commit();
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
        return outElements;
    }

    public Element findElementByIndex(int index) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        Element outElement = null;

        try {
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            outElement = em.find(Element.class, 1);

            

            tx.commit();
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
        return outElement;
    }

    public Element findElementByName(String name) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        Element outElement = null;

        try {
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            String sqlString = "select e from Element e where e.name = :name";
            TypedQuery<Element> query = em.createQuery(sqlString,Element.class);
            query.setParameter("name",name);
            List<Element> elementList = query.getResultList();
            if(elementList.isEmpty()){
                outElement = null;
            } else{
            outElement = elementList.get(0);
            }



            tx.commit();
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
        return outElement;
    }

    public Element findCombinationElementByName(String name1, String name2){
        EntityManagerFactory emf = null;
        EntityManager em = null;
        Element outElement = null;

        try {
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            String sql = "select e.child from Equation e where e.parent1.name = :firstName AND e.parent2.name = :secondName";
            TypedQuery<Element> query = em.createQuery(sql,Element.class);

            query.setParameter("firstName",name1);
            query.setParameter("secondName",name2);
            List<Element> results1 = query.getResultList();

            query.setParameter("firstName",name2);
            query.setParameter("secondName",name1);
            List<Element> results2 = query.getResultList();

            results1.addAll(results2);

            if(!results1.isEmpty()) {
                outElement = results1.get(0);
            }

            tx.commit();
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
        return outElement;
    }

}
