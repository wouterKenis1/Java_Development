package pack.education;

import pack.medical.MedicalFile;
import pack.medical.Patient;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveSchool {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try{
            emf = Persistence.createEntityManagerFactory("mysqlcontainerdropcreate");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            School school = new School();
            school.setName("Howest");
            Student s1 = new Student();
            s1.setName("Wouter");
            Student s2 = new Student();
            s2.setName("Lukas");
            school.addStudent(s1);
            school.addStudent(s2);


            em.persist(school);
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
