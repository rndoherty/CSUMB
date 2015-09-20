/*
   Team: Robert Contreras, Hyo Lee, Ryan Doherty
   CST 338 - Fall 2015 Session A
   Assignment 3, Card Game
*/

import java.util.*;

public class Assignment3
{

   public static void main(String[] args)
   {
      
      Scanner keyboard = new Scanner(System.in);
      keyboard.close();

      System.out.println();
      runDeckTest();
      
   }
   
   public static void runDeckTest(){

       if (DeckTest()){
           System.out.println("passed");
       } else {
           System.out.println("failed");
       }
   }
   
   //Deck Test
   public static boolean DeckTest(){
       try {
           Deck testDeck = new Deck(5);
           return true;
       } catch (Exception e) {
           System.err.println( e.getMessage());
           return false;
       }
   }
   
}

