package spring.wrappers;

import spring.model.Element;
import spring.repository.ElementRepo;

public class ElementPair {
    public Element element1;
    public Element element2;
    public String name1;
    public String name2;

    public ElementPair() {
    }

    public ElementPair(String name1, String name2) {
        this.name1 = name1;
        this.name2 = name2;
        ElementRepo tempRepo = new ElementRepo();
        element1 = tempRepo.findElementByName(name1);
        element1 = tempRepo.findElementByName(name2);
    }

    public Element getElement1() {
        return element1;
    }

    public ElementPair setElement1(Element element1) {
        this.element1 = element1;

        return this;
    }

    public Element getElement2() {
        return element2;
    }

    public ElementPair setElement2(Element element2) {
        this.element2 = element2;
        return this;
    }

    public String getName1() {
        return name1;
    }

    public ElementPair setName1(String name1) {
        this.name1 = name1;
        ElementRepo tempRepo = new ElementRepo();
        element1 = tempRepo.findElementByName(name1);
        return this;
    }

    public String getName2() {
        return name2;
    }

    public ElementPair setName2(String name2) {
        this.name2 = name2;
        ElementRepo tempRepo = new ElementRepo();
        element2 = tempRepo.findElementByName(name2);
        return this;
    }
}
