package pack.medical;

import javax.persistence.*;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToOne(fetch = FetchType.EAGER, orphanRemoval = true)
    private MedicalFile medicalFile;

    public MedicalFile getMedicalFile() {
        return medicalFile;
    }

    public void setMedicalFile(MedicalFile medicalFile) {
        this.medicalFile = medicalFile;
    }

    public void addMedicalFile(MedicalFile mf){
        medicalFile = mf;
        mf.setPatient(this);
    }

    public void removeMedicalFile(){
        if(medicalFile != null){
            medicalFile.setPatient(null);
            medicalFile = null;
        }
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
