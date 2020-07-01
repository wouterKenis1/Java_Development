public class Animal {
    private String m_Name;
    private double m_Age;
    private double m_Weight;
    private Gender m_Gender;

    Animal(){
        this("-NoName-",0.0,0.0,Gender.None);
    }
    Animal(String name, double age, double weight, Gender gender) {
        m_Name = name;
        m_Age = age;
        m_Weight = weight;
        m_Gender = gender;
    }

    public String getM_Name() {
        return m_Name;
    }

    public void setM_Name(String m_Name) {
        this.m_Name = m_Name;
    }

    public double getM_Age() {
        return m_Age;
    }

    public void setM_Age(double m_Age) {
        this.m_Age = m_Age;
    }

    public double getM_Weight() {
        return m_Weight;
    }

    public void setM_Weight(double m_Weight) {
        this.m_Weight = m_Weight;
    }

    public Gender getM_Gender() {
        return m_Gender;
    }

    public void setM_Gender(Gender m_Gender) {
        this.m_Gender = m_Gender;
    }

    public void printAnimal() {
        System.out.println("\t\t" + m_Name + "\t\t" + m_Age + "\t\t" + m_Weight + "\t\t" + m_Gender);
    }
}
