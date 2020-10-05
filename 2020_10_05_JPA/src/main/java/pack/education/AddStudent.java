package pack.education;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AddStudent {
    public static void main(String[] args) {
        SaveSchool.main(args);
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try{
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            School school = em.getReference(School.class,1L);
            Student newStudent = new Student();
            newStudent.setName("Patrick");
            school.addStudent(newStudent);

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
