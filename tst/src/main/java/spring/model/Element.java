package spring.model;

import spring.threads.ElementThread;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
public class Element {
    // region variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "color")
    private int colorId;
    @Column(name = "name")
    private String name;
    @Column(name = "birthTime")
    private BigInteger birthTime;
    @Column(name = "owners")
    private int owners;
    @Column(name = "mark")
    private String mark;
    @OneToOne
    private Equation originalEquation;
    @Column(name = "publicBirthTime")
    private BigInteger publicBirthTime;
    @Column(name = "nameChanges")
    private int nameChanges;
    @Column(name = "prevalence")
    private int prevalence;
    @Column(name = "usefulness")
    private int usefulness;
    // endregion

    public Element() {
    }

    public Element(String name){
        this.name = name;

        ElementThread eThread = new ElementThread(this);
        eThread.start();
    }
    public Element(String name,Equation originalEquation){
        this.name = name;
        this.originalEquation = originalEquation;

//        ElementThread eThread = new ElementThread(this);
//        eThread.start();
    }


    // region getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getBirthTime() {
        return birthTime;
    }

    public void setBirthTime(BigInteger birthTime) {
        this.birthTime = birthTime;

    }

    public int getOwners() {
        return owners;
    }

    public void setOwners(int owners) {
        this.owners = owners;

    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;

    }

    public Equation getOriginalEquation() {
        return originalEquation;
    }

    public void setOriginalEquation(Equation originalEquation) {
        this.originalEquation = originalEquation;

    }

    public BigInteger getPublicBirthTime() {
        return publicBirthTime;
    }

    public void setPublicBirthTime(BigInteger publicBirthTime) {
        this.publicBirthTime = publicBirthTime;

    }

    public int getNameChanges() {
        return nameChanges;
    }

    public void setNameChanges(int nameChanges) {
        this.nameChanges = nameChanges;

    }

    public int getPrevalence() {
        return prevalence;
    }

    public void setPrevalence(int prevalence) {
        this.prevalence = prevalence;

    }

    public int getUsefulness() {
        return usefulness;
    }

    public void setUsefulness(int usefulness) {
        this.usefulness = usefulness;

    }
    // endregion




    @Override
    public String toString() {
        return "Element{" +
                "id=" + id +
                ", colorId=" + colorId +
                ", name='" + name + '\'' +
                ", birthTime=" + birthTime +
                ", owners=" + owners +
                ", mark='" + mark + '\'' +
//                ", originalEquation=" + originalEquation.getId() +
                ", publicBirthTime=" + publicBirthTime +
                ", nameChanges=" + nameChanges +
                ", prevalence=" + prevalence +
                ", usefulness=" + usefulness +
                '}';
    }
}
