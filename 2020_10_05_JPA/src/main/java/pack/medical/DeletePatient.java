package pack.medical;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeletePatient {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try{
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            //Patient patient = em.find(Patient.class,1L);
            //MedicalFile medicalFile = patient.getMedicalFile();

            Patient patient = em.getReference(Patient.class,1L);
            em.remove(patient);
            tx.commit();
            System.out.println("Delete Succeeded!");

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
