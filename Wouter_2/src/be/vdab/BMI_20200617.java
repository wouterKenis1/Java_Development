package be.vdab;

import java.util.Scanner;

import be.vdab.Utils;


public class BMI_20200617 {

    public static void main(String[] args){

        // vraag inputs
        System.out.print("Geef je gewicht in (kg): ");
        double mass = Utils.inputDevice.nextFloat();
        System.out.print("Geef je lengte in (m): ");
        double height  = Utils.inputDevice.nextFloat();

        // doe berekening
        double BMI = CalculateBMI(mass, height);

        // toon uitkomst
        System.out.println("Je hebt een BMI van: " + BMI);
        System.out.println("Je bent categorie: " + GetCategory(BMI));
    }

    public static double CalculateBMI(double mass,double height)
    {
        return (mass / Math.pow(height,2));
    }
    public static String GetCategory(double BMI)
    {
        if(BMI < 16) {return "Severe Thinness";}
        else if(BMI < 17) {return "Moderate Thinness";}
        else if(BMI < 18.5) {return "Mild Thinness";}
        else if(BMI < 25) {return "Normal";}
        else if(BMI < 30) {return "OverWeight";}
        else if(BMI < 35) {return "Obese Class 1";}
        else if(BMI < 40) {return "Obese Class 2";}
        else {return "Obese Class 3";}
    }
}
