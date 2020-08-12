package Algorithms;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list = fillInts(list,20,30);
        printArray(list);
//        quickSort(list);
        list = mergeSort(list);
        printArray(list);
    }


    public static <E extends Comparable> ArrayList quickSort(ArrayList<E> list){
        return quickSort(list,0,list.size() - 1);
    }
    public static <E extends Comparable> ArrayList quickSort(ArrayList<E> list,int low,int high){
        if (low < high){
            int p = partition(list,low,high);
            list = quickSort(list,low,p-1);
            list = quickSort(list,p+1, high);
        }
        return list;
    }
    public static <E extends Comparable> int partition(ArrayList<E> list, int low, int high){
        E pivot = list.get(high);
        //System.out.println(pivot);
        int i = low;
        for(int j = low; j < high; j++){
            if(list.get(j).compareTo(pivot) == -1){ // if j < pivot
                //System.out.print(i + ", " + j + "|\t");
                swap(list,i,j); // swap i and j
                i++;
            }
        }
//        System.out.print(i + ", " + high + "|\t");
        swap(list,i,high);
        return i;
    }

    public static <E extends Comparable> ArrayList mergeSort(ArrayList<E> list){
        if(list.size() <= 1){
            return list;
        }

            int lastOfFront = list.size() / 2;
            ArrayList<E> front = mergeSort(new ArrayList<E>(list.subList(0,lastOfFront )));
            ArrayList<E> back = mergeSort(new ArrayList<E>(list.subList(lastOfFront, list.size())));
            list = mergeArrays(front,back);
            return list;

    }
    public static <E extends Comparable> ArrayList mergeArrays(ArrayList<E> arr1, ArrayList<E> arr2){
        ArrayList<E> newArr = new ArrayList<>();
        int i = 0;
        int j = 0;
        while( (i < (arr1.size() )) &&
                (j < (arr2.size() ))){
            if(arr1.get(i).compareTo(arr2.get(j)) == -1){ // i < j
                newArr.add(arr1.get(i));
                i++;
            }
            else{
                newArr.add(arr2.get(j));
                j++;
            }
        }
        for(; i < arr1.size(); i++) {
                newArr.add(arr1.get(i));
        }
        for(; j < arr2.size(); j++) {
            newArr.add(arr2.get(j));
        }
        return newArr;
    }

    public static <E> ArrayList swap(ArrayList<E> list, int id1, int id2){
        E obj1 = list.get(id1);
        E obj2 = list.get(id2);
        list.set(id1,obj2);
        list.set(id2,obj1);
//        System.out.print(obj1 + ", " + obj2 + "|\t");
//        printArray(list);
        return list;
    }
    public static <E extends Number> ArrayList fillInts(ArrayList<E> list, int amount, int bound){
        Random r = new Random();
        int tempInt = 0;
        for (int i = 0; i < amount; i++) {
            tempInt = r.nextInt(bound);
            list.add(i,(E)(Number)tempInt);
        }
        return list;
    }
    public static <E> void printArray(ArrayList<E> list){
        for (E e : list) {
            System.out.print(e + " ");
        }
        System.out.println(""); //newLine
    }


}
