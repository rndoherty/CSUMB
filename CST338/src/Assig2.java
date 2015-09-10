
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
       
        //TODO: Complete user input and getBet()
        /*
        int bet=-1;
        
        while (bet!=0){
            bet = getBet();
            TripleString thePull = pull();
            display(thePull,getWinnings(thePull,bet));
        }
        */
        
        //TODO: remove this test code after the above is completed
        TripleString thePull = pull();
        //TODO: remove this test code after it's placed in the display() method
        System.out.println(thePull.getString1() + " " + thePull.getString2() + " " + thePull.getString3());
        System.out.println();
    }

    public static int getWinnings(TripleString thePull,int bet){
        
        
        return 0;
    }
    
    public static String randString(){
        /* Weights
         * BAR      1/2  (50%)
         * cherries 1/4  (25%)
         * space    1/8  (12.5%)
         * 7        1/8  (12.5%)
         * 
         */
        
        String randomSymbol="";
        int bar = 500;
        int cherry=250;
        int space=125;
        int seven=0;
        
        int randomNumber = (int) Math.floor(Math.random()*1000);
        if (randomNumber>=seven && randomNumber<space){
            randomSymbol="7";
        }
        if (randomNumber>=space && randomNumber<cherry){
            randomSymbol="Space";
        }
        if (randomNumber>=cherry && randomNumber<bar){
            randomSymbol="Cherries";
        }
        if (randomNumber>=bar){
            randomSymbol="BAR";
        }
        
        return randomSymbol;
    }
    

    public static int getPayMultiplier (TripleString thePull){
        
        return 0;
    }
    public static int getBet(){
        
        Scanner scan = new Scanner(System.in);

        int bet = scan.nextInt();
        
        scan.close();
        return bet;
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
    
    private boolean validString( String str ) {
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