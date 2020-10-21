package spring.repository;

import spring.model.Element;
import spring.model.Equation;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class EquationRepo {
    public void saveEquation(Equation equation){
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try{
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(equation);
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

    public void deleteEquation(Equation equation){
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try{
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.remove(equation);
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

    public List<Equation> getAllEquations(){
        EntityManagerFactory emf = null;
        EntityManager em = null;
        List<Equation> equationtList = new ArrayList<>();
        try {
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            String sqlString = "select e from Equation e";
            TypedQuery<Equation> query = em.createQuery(sqlString,Equation.class);
            equationtList = query.getResultList();

            tx.commit();
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
        return equationtList;
    }

    public Equation findEquationByIndex(int index){
        EntityManagerFactory emf = null;
        EntityManager em = null;
        Equation outEquation = null;

        try{
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            outEquation = em.find(Equation.class,1);
            tx.commit();

        } finally{
            if(em != null){
                em.close();
            }
            if(emf != null){
                emf.close();
            }
        }
        return outEquation;
    }

    public Equation findEquationByParentNames(String parent1, String parent2){
        EntityManagerFactory emf = null;
        EntityManager em = null;
        Equation outEquation = null;

        try {
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            String sqlString = "select e from Equation e where e.parent1.name = :parent1 and e.parent2.name = :parent2";
            TypedQuery<Equation> query = em.createQuery(sqlString,Equation.class);
            query.setParameter("parent1",parent1);
            query.setParameter("parent2",parent2);
            List<Equation> equationtList = query.getResultList();
            // parents can be switched around too!
            query.setParameter("parent1",parent2);
            query.setParameter("parent2",parent1);
            equationtList.addAll(query.getResultList());
            if(equationtList.isEmpty()){
                outEquation = null;
            } else{
                outEquation = equationtList.get(0);
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
        return outEquation;
    }

}
