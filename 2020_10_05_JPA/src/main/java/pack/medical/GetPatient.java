package pack.medical;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GetPatient {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try{
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            Patient patient = em.find(Patient.class,1L);
            MedicalFile medicalFile = patient.getMedicalFile();
            System.out.println(patient.getName() + " " + medicalFile.getHeight() + "m " + medicalFile.getWeight() + "kg");

            tx.commit();
            //MedicalFile medicalFile = patient.getMedicalFile();
            System.out.println(patient.getName() + " " + medicalFile.getHeight() + "m " + medicalFile.getWeight() + "kg");


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
