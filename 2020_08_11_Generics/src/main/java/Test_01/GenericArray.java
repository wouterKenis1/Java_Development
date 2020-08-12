package Test_01;

public class GenericArray<E> {
    public E[] array;

    public int getSize(){
        return array.length;
    }

    public E peek(){
        return array[array.length - 1];
    }

    public E push(E object){
        E[] newArray = (E[])new Object[array.length + 1];
        for (int i = 0; i < array.length; i++) {
        newArray[i] = array[i];
        }
        newArray[array.length] = object;
        array = newArray;
        return object;
    }

    public E pop(){
        E object = array[array.length - 1];
        E[] newArray = (E[])new Object[array.length - 1];
        for (int i = 0; i < array.length - 1; i++) {
            newArray[i] = array[i];
        }
        return object;
    }

    public boolean isEmpty(){
        return array.length == 0;
    }

    @Override
    public String toString(){
        return "stack: " + array.toString();
    }
}
