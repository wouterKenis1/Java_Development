import java.util.Vector;

public class Zoo {
    private Vector<Lion> m_Lions;
    private Vector<Tiger> m_Tigers;
    private Vector<Monkey> m_Monkeys;
    private Vector<Lynx> m_Lynxs;
    private Vector<Wolf> m_Wolves;

    public Zoo(){
        m_Lions = new Vector<Lion>();
        m_Tigers = new Vector<Tiger>();
        m_Monkeys = new Vector<Monkey>();
        m_Lynxs = new Vector<Lynx>();
        m_Wolves = new Vector<Wolf>();
    }

    public void addAnimal(Animal animal){
        if(animal instanceof  Lion){
            m_Lions.add((Lion)animal);
        }
        else if(animal instanceof  Tiger){
            m_Tigers.add((Tiger)animal);
        }
        else if(animal instanceof  Monkey){
            m_Monkeys.add((Monkey)animal);
        }
        else if(animal instanceof  Lynx){
            m_Lynxs.add((Lynx)animal);
        }
        else if(animal instanceof  Wolf){
            m_Wolves.add((Wolf)animal);
        }
    }

    public void printAnimals() {
        for(Lion lion : m_Lions)
        {
            lion.printAnimal();
        }
        for(Tiger tiger : m_Tigers)
        {
            tiger.printAnimal();
        }
        for(Monkey monkey : m_Monkeys)
        {
            monkey.printAnimal();
        }
        for(Lynx lynx : m_Lynxs)
        {
            lynx.printAnimal();
        }
        for(Wolf wolf : m_Wolves)
        {
            wolf.printAnimal();
        }

    }
}
