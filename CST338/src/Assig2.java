
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
    
    public static String getSlotMachineSymbol(){
        /* Weights
         * BAR      1/2  (50%)
         * cherries 1/4  (25%)
         * space    1/8  (12.5%)
         * 7        1/8  (12.5%)
         * 
         */
        
        //TODO: find better way to do the weighted random
        
        //set to 1000 so weights are whole numbers.
        String[] slotMachine = new String[1000]; 
        int[] weight = new int[4];
        weight[0]=500;//bar
        weight[1]=250;//cherries
        weight[2]=125;//space
        weight[3]=125;//7
        
        String[] symbols = new String[4];
        symbols[0] = "BAR";
        symbols[1] = "Cherries";
        symbols[2] = "Space";
        symbols[3] = "7";
        
        int start=0;
        int last=0;
        for (int x=0;x<weight.length;x++){
            for (int y=start;y<start+weight[x];y++){
               slotMachine[y] = symbols[x];
               last=y;
            }
            start=last+1;
        }
               
        String randomSymbol=slotMachine[(int) Math.floor(Math.random()*slotMachine.length-1)];
        slotMachine=null; //clear array
        return randomSymbol;
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
    
    public String getString1(){
        return string1;
    }
    public String getString2(){
        return string2;
    }
    public String getString3(){
        return string3;
    }
}