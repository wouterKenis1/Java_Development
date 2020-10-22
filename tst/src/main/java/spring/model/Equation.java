package spring.model;

import spring.threads.EquationThread;

import javax.persistence.*;

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
    @Column(name = "voteCount")
    private int voteCount;
    @Column(name = "newElement")
    private boolean newElement;
    @Column(name = "public")
    private boolean isPublic = false;
    @Transient
    private boolean checkVotes = true;
    // endregion

    // region constructors
    public Equation(){
    }

    public Equation(boolean checkVotes){
        this.checkVotes = checkVotes;
        if(checkVotes){
            isPublic = false;
            EquationThread eThread = new EquationThread(this);
            eThread.start();
        }
        else{
            isPublic = true;
        }
    }

    //endregion

    // region getters and setters
    public int getId() {
        return id;
    }

    public Equation setId(int id) {
        this.id = id;
        return this;
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

    public boolean isCheckVotes() {
        return checkVotes;
    }

    public Equation setCheckVotes(boolean checkVotes) {
        this.checkVotes = checkVotes;
        return this;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public Equation setPublic(boolean aPublic) {
        isPublic = aPublic;
        return this;
    }
    // endregion

    public void addVote(){
        voteCount++;
    }


    @Override
    public String toString() {
        return "Equation{" +
                "id=" + id +
                ", parent1=" + parent1 +
                ", parent2=" + parent2 +
                ", child=" + child +
                ", newElement=" + newElement +
                ", votes=" + voteCount +
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
