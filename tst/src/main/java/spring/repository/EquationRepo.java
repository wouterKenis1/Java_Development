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

            String sql = "delete from Equation e where e.id = :id";
            Query query = em.createQuery(sql);
            query.setParameter("id",equation.getId());
            query.executeUpdate();

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

    public List<Equation> findEquationsByParentNames(String parent1, String parent2){
        EntityManagerFactory emf = null;
        EntityManager em = null;
        List<Equation> equationtList = new ArrayList<>();

        try {
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();

            tx.begin();

            String sqlString = "select e from Equation e where e.parent1.name = :parent1 and e.parent2.name = :parent2";
            TypedQuery<Equation> query = em.createQuery(sqlString,Equation.class);
            query.setParameter("parent1",parent1);
            query.setParameter("parent2",parent2);
            equationtList = query.getResultList();
            // parents can be switched around too!
            query.setParameter("parent1",parent2);
            query.setParameter("parent2",parent1);
            List<Equation> results2 = query.getResultList();

            // merge the arrays
            for(Equation equation1 : results2){
                boolean isFound = false;
                for(Equation equation2 : equationtList){
                    if(equation1.getId() == equation2.getId()){
                        isFound = true;
                    }
                }
                if(!isFound){
                equationtList.add(equation1);
                }
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
        return equationtList;
    }

    public Equation findEquation(String parent1, String parent2, String child){
        EntityManagerFactory emf = null;
        EntityManager em = null;
        Equation outEquation = null;

        try {
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            String sqlString = "select e from Equation e where e.parent1.name = :parent1 and e.parent2.name = :parent2 and e.child.name = :child";
            TypedQuery<Equation> query = em.createQuery(sqlString,Equation.class);
            query.setParameter("parent1",parent1);
            query.setParameter("parent2",parent2);
            query.setParameter("child",child);
            List<Equation> equationtList = query.getResultList();
            // parents can be switched around too!
            query.setParameter("parent1",parent2);
            query.setParameter("parent2",parent1);
            equationtList.addAll(query.getResultList());
            if(equationtList.isEmpty()){
                outEquation = null;
            } else{
                outEquation = equationtList.get(0);
                //there should never be more than one entry
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

    public boolean isEquationInDatabase(String parent1, String parent2, String child){
        boolean result = false;
        List<Equation> equationList = findEquationsByParentNames(parent1,parent2);
        for(Equation equation1 : equationList){
            if(child == equation1.getChild().getName()){
                result = true;
            }
        }
        return  result;
    }

    public void updateEquationVotes(Equation equation){
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try{
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            String sql = "update Equation e set e.voteCount = :votes where e.id = :id";
            Query query = em.createQuery(sql);
            query.setParameter("id",equation.getId());
            query.setParameter("votes",equation.getVoteCount());
            query.executeUpdate();

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

    public void updateEquitionPublic(Equation equation){
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try{
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            String sql = "update Equation e set e.isPublic = :isPublic where e.id = :id";
            Query query = em.createQuery(sql);
            query.setParameter("id",equation.getId());
            query.setParameter("isPublic",equation.isPublic());
            query.executeUpdate();

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

}
