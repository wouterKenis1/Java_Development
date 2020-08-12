package Test_01;

public class GenericCompareTo {

//    public <E extends Number> boolean isEqualTo(E obj1, E obj2){
//        return obj1.equals(obj2);
//    }
    public <E> boolean isEqualTo(E obj1, E obj2){
        return obj1.equals(obj2);
    }

    public void testEqualTo(){
        System.out.println(isEqualTo(5, 5) );
        int x,y;
        x = y = 5;
        System.out.println(isEqualTo(x,y) );
        System.out.println(isEqualTo("Hello","Hello") );
        System.out.println(isEqualTo("Hello","hello") );

    }
}
