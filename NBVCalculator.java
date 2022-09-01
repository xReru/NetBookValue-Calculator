/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nbv.calculator;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Janrell Quiaroro
 */
public class NBVCalculator {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    //Declaring Variables
    double cost;
    int months;
    double deprec;
    double newNBV;
    double nbv;
    DecimalFormat f = new DecimalFormat("###");
    Scanner input = new Scanner(System.in);
    //Declare the object 
    Calc C = new Calc();
    //Getting the value of the items that is needed in the formula 
    System.out.print("Enter item cost : ");
    cost = input.nextInt();

    System.out.print("Enter life in months : ");
    months = input.nextInt();
    
    //Computing the results using the formula 
    deprec = C.getDep(cost,months);
    nbv = C.getNBV(cost,deprec);
    
    //Printing the results
    System.out.println(" | Months"+" | Dep Value"+" | Dep"+" | NBV ");
    System.out.println(" | "+1+" | "+f.format(cost)+" | "+f.format(deprec)+" | "+f.format(nbv)+" | ");
    
    
    for (int i = 2; i <= months; i++){
        
        newNBV = C.getNBV(nbv,deprec);
        System.out.println(" | "+i+" | "+f.format(nbv)+" | "+f.format(deprec)+" | "+f.format(newNBV)+" | ");
        nbv = newNBV;    

    }
    
    }

}
class Calc{
    //Formula for getting the Depreciation
    public static double getDep(double cost, int months){
         double dep = cost/months;
    return dep;
    }
    
    //Formula for getting the Net book Value
    public static double getNBV(double cost, double deprec){
        double nbv = cost-deprec;
    return nbv;
    }
}
    

