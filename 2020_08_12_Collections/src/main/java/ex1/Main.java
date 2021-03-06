package ex1;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Random;

public class Main {
    public static Random r = new Random();

    public static void main(String[] args) {
        Main main = new Main();

        Point2D[] points = new Point2D[10];
        generatePoints(points,20);
        points = sortArrayPoint2D(points);
        for (Point2D point2D: points) {
            Point point = (Point)point2D;
            System.out.print("(" + point.x + "," + point.y + ") ");
        }
    }


    public static Point2D[] sortArrayPoint2D(Point2D[] array){
        return quickSort(array);
    }

    public static Point2D[] quickSort(Point2D[] array){
        return quickSort(array,0,array.length - 1);
    }
    public static  Point2D[] quickSort(Point2D[] array,int low,int high){
        if (low < high){
            int p = partition(array,low,high);
            array = quickSort(array,low,p-1);
            array = quickSort(array,p+1, high);
        }
        return array;
    }
    public static  int partition(Point2D[] array, int low, int high){
        Point2D pivot = array[high];
        int i = low;
        for(int j = low; j < high; j++){
            if(array[j].getY() < pivot.getY()){ // if j < pivot
                swap(array,i,j); // swap i and j
                i++;
            }
            else if(array[j].getY() == pivot.getY() && array[j].getX() < pivot.getX()){
                swap(array,i,j); // swap i and j
                i++;
            }
        }
        swap(array,i,high);
        return i;
    }
    public static Point2D[] swap(Point2D[] list, int id1, int id2){
        Point2D obj1 = list[id1];
        Point2D obj2 = list[id2];
        list[id1] = obj2;
        list[id2] = obj1;
        return list;
    }

    public static Point2D[] generatePoints(Point2D[] list, int bound){
        for(int i = 0; i < list.length; i++){
            list[i] = generatePoint(bound);
        }
        return list;
    }

    public static Point generatePoint(int bound){
        return new Point(r.nextInt(bound),r.nextInt(bound));
    }

}
