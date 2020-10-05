package pack.education;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class GetSchool {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try{
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            School school = em.find(School.class,1L);
            List<Student> students = school.getStudents();

            System.out.println("School: " + school.getName());
            System.out.println("Students:");
            for(Student student : students){
                System.out.println("Id: " + student.getId() + "\tname: " + student.getName());
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
