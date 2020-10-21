package spring.model;

import spring.threads.ElementThread;
import spring.threads.EquationThread;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
public class Equation {

    //region variables
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private int id;
    @OneToOne
    private Element parent1;
    @OneToOne
    private Element parent2;
    @OneToOne
    private Element child;
    @Column(name = "birthTime")
    private BigInteger birthTime;
    @Column(name = "voteCount")
    private int voteCount;
    @Column(name = "newElement")
    private boolean newElement;
    @Column(name = "consensus")
    private int consensus;
    @Column(name = "publicBirthTime")
    private BigInteger publicBirthTime;
    // endregion

    // region constructors
    public Equation(){
//        EquationThread eThread = new EquationThread(this);
//        eThread.start();
    }

    //endregion

    // region getters and setters
    public int getId() {
        return id;
    }

    public Element getParent1() {
        return parent1;
    }

    public Equation setParent1(Element parent1) {
        this.parent1 = parent1;
        return this;
    }

    public Element getParent2() {
        return parent2;
    }

    public Equation setParent2(Element parent2) {
        this.parent2 = parent2;
        return this;
    }

    public Element getChild() {
        return child;
    }

    public Equation setChild(Element child) {
        this.child = child;
        return this;
    }

    public BigInteger getBirthTime() {
        return birthTime;
    }

    public Equation setBirthTime(BigInteger birthTime) {
        this.birthTime = birthTime;
        return this;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public Equation setVoteCount(int voteCount) {
        this.voteCount = voteCount;
        return this;
    }

    public boolean isNewElement() {
        return newElement;
    }

    public Equation setNewElement(boolean newElement) {
        this.newElement = newElement;
        return this;
    }

    public int getConsensus() {
        return consensus;
    }

    public Equation setConsensus(int consensus) {
        this.consensus = consensus;
        return this;
    }

    public BigInteger getPublicBirthTime() {
        return publicBirthTime;
    }

    public Equation setPublicBirthTime(BigInteger publicBirthTime) {
        this.publicBirthTime = publicBirthTime;
        return this;
    }
    // endregion


    @Override
    public String toString() {
        return "Equation{" +
                "id=" + id +
//                ", parent1=" + parent1.getId() +
//                ", parent2=" + parent2.getId() +
//                ", child=" + child.getId() +
                ", birthTime=" + birthTime +
                ", voteCount=" + voteCount +
                ", newElement=" + newElement +
                ", consensus=" + consensus +
                ", publicBirthTime=" + publicBirthTime +
                '}';
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(this.getClass() != obj.getClass()){
            return false;
        }
        Equation other = (Equation)obj;
        if(parent1 != other.parent1 || parent2 != other.parent2){
            return false;
        }
        if(child != other.child){
            return false;
        }
        return true;
    }
}
