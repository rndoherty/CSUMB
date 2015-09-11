/*
 * Ryan Doherty
 * rdoherty@csumb.edu
 * CST338
 * 2015-09-12 
 * Description: Module 2 - Casino
 */

import java.io.*;
import java.util.*;
import java.lang.Math;

/**
 * 
 * @author Ryan Doherty
 *
 */
public class Assig2 {

    /** 
     * 
     * @param args
     * @throws IOException
     */
    public static void main (String[] args) throws IOException {  
       
        Scanner scan = new Scanner(System.in);
        int bet=getBet(scan);
        
        while (bet!=0){
            
            TripleString thePull = pull();
            display(thePull,(getPayMultiplier(thePull)*bet));
            //TODO: Add bounds check
            bet = getBet(scan);
        }
        kthxbye();
        scan.close();
        
    }
    
    public static void kthxbye(){
        System.out.println("Thanks for playing.");
    }
    
    private static String randString(){
        /* Weights
         * BAR      1/2  (50%)
         * cherries 1/4  (25%)
         * space    1/8  (12.5%)
         * 7        1/8  (12.5%)
         * 
         */
        
        String symbol="";
        
        //Range threshold set to 1000 for whole numbered weights.
        int randomNumber = (int) Math.floor(Math.random()*1000);
        
        //weighted starting points for symbols.
        int bar = 500;
        int cherry=250;
        int space=125;
        int seven=0;
        
        //find symbol based on randomNumber value and weighted range
        if (randomNumber>=seven && randomNumber<space){
            symbol="7";
        }
        if (randomNumber>=space && randomNumber<cherry){
            symbol="(Space)";
        }
        if (randomNumber>=cherry && randomNumber<bar){
            symbol="Cherries";
        }
        if (randomNumber>=bar){
            symbol="BAR";
        }
        
        return symbol;
    }
    

    public static int getPayMultiplier (TripleString thePull){
        
        /*
         * The following combinations should pay the bet as shown 
         * (note ORDER MATTERS):
         * cherries  [not cherries]  [any] pays 5 � bet (5 times the bet)
         * cherries  cherries  [not cherries] pays 15 � bet
         * cherries  cherries  cherries pays 30 � bet
         * BAR  BAR  BARpays 50 � bet
         * 7  7  7 pays 100 � bet
         */   
        
        if (thePull.getString1() == "Cherries" &&  
            thePull.getString2() != "Cherries"){
            return 5;
        } else if (thePull.getString1() == "Cherries" &&  
                   thePull.getString2() == "Cherries" &&  
                   thePull.getString3() != "Cherries"){
            return 15;
        } else if (thePull.getString1() == "Cherries" &&  
                   thePull.getString2() == "Cherries" &&  
                   thePull.getString3() == "Cherries"){
            return 30;
         } else if (thePull.getString1() == "BAR" &&  
                 thePull.getString2() == "BAR" &&  
                 thePull.getString3() == "BAR"){
             return 50;
         } else if (thePull.getString1() == "7" &&  
                 thePull.getString2() == "7" &&  
                 thePull.getString3() == "7"){
             return 100;
         }
        return 0;
    }
    
    public static int getBet(Scanner scan){
        System.out.println("How much would you like to bet (1 - 100) or 0 to quit?");
       
        return scan.nextInt();
    }
    
    public static TripleString pull(){
        String string1=randString();
        String string2=randString();
        String string3=randString();
        
        TripleString tripString = new TripleString();
        
        tripString.setString1(string1);
        tripString.setString2(string2);
        tripString.setString3(string3);
        
        return tripString;
    }
    
    public static void display (TripleString thePull, int winnings ){
        System.out.println(thePull.toString());
        if (winnings>0){
            System.out.println("Congratulations! You won $" + winnings);
        } else {
            System.out.println("Sorry...you lost.");
        }
    }
    
}

class TripleString {
    
    private String string1;
    private String string2;
    private String string3;
    
    public static final int MAX_LEN = 20;
    public static final int MAX_PULLS = 40;
    public static int[] pullWinnings;
    
    public TripleString(){
        string1="";
        string2="";
        string3="";
        pullWinnings = new int[MAX_PULLS];
    }
    
    private boolean validString(String str) {
        //TODO: add logic here
        return false;
    }
    
    public String getString1(){
        return string1;
    }
    public void setString1(String string4){
        this.string1=string4;
    }
    public String getString2(){
        return string2;
    }
    public void setString2(String string4){
        this.string2=string4;
    }
    public String getString3(){
        return string3;
    }
    public void setString3(String string4){
        this.string3=string4;
    }
    
    public void saveWinnings(int winnings){
        
    }
    
    public String displayWinnings(){
        return "";
    }
    
    public String toString() {
        return string1 + " " + string2 + " " + string3;
    }
    
}