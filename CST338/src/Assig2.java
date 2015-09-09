
/*
 * Ryan Doherty
 * rdoherty@csumb.edu
 * CST338
 * 2015-09-12 
 * Description: Module 2 - Casino
 */

import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;

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
       
        int bet=-1;
        
        while (bet!=0){
            bet = getBet();
            TripleString thePull = pull();
            display(thePull,getWinnings(thePull,bet));
        }
        
    }
    
    public static String getSlotMachineSymbol(){
        /* Weights
         * BAR      1/2  (50%)
         * cherries 1/4  (25%)
         * space    1/8  (12.5%)
         * 7        1/8  (12.5%)
         * 
         */
        
        String symbol= "";
        
        return symbol;
    }
    

    public static int getWinnings(TripleString thePull,int bet){
        
        
        return 0;
    }
    
    public static int getBet(){
        
        Scanner scan = new Scanner(System.in);

        int bet = scan.nextInt();
        
        scan.close();
        return bet;
    }
    
    public static TripleString pull(){
        String string1=getSlotMachineSymbol();
        String string2=getSlotMachineSymbol();
        String string3=getSlotMachineSymbol();
        
        TripleString tripString = new TripleString(string1,string2,string3);
        
        return tripString;
    }
    
    public static void display (TripleString thePull, int winnings ){
        
    }
    
}

class TripleString {
    
    private String string1;
    private String string2;
    private String string3;
    
    public TripleString(String string1,String string2,String string3){
        this.string1=string1;
        this.string2=string2;
        this.string3=string3;
    }
    
    
}