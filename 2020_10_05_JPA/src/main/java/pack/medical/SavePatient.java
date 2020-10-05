package pack.medical;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SavePatient {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try{
            emf = Persistence.createEntityManagerFactory("mysqlcontainerdropcreate");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            Patient patient = new Patient();
            patient.setName("Wouter");
            MedicalFile medicalFile = new MedicalFile();
            medicalFile.setHeight(1.80f);
            medicalFile.setWeight(65.0f);
            patient.addMedicalFile(medicalFile);

            em.persist(medicalFile);
            em.persist(patient);
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
