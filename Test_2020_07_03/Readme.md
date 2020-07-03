-----
vraag:
11. ClassB en ClassC erven over van de abstracte ClassA. ClassC implimenteert ook InterfaceA. Welke cases zullen compileren? (teken het diagram!)

ClassA variableA = new ClassA();
ClassA variableA = new ClassB();
InterfaceA variableA = new ClassB();
Interface variableA = new ClassC();
ClassA variableA = new ClassC(); Interface variableB = variableA;
-----
antwoord:

ClassA variableA = new ClassB();
