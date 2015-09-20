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



      runCardTest();
      runDeckTest();

   }

   public static void runCardTest()
   {
      if (CardTest()){
         System.out.println("passed");
      } else {
         System.out.println("failed");
      }
   }
   

   //Card Unit Test
   public static boolean CardTest(){

      Card.Value queen = Card.Value.Q;
      Card.Value nine = Card.Value.NINE;
      Card.Suit club = Card.Suit.clubs;
      Card.Suit spade = Card.Suit.spades;

      try {
         Card testCard1 = new Card(queen, club);
         Card testCard2 = new Card(nine, spade);
         testCard1.getSuit();
         testCard2.getValue();
         return true;
      } catch (Exception e) {
         return false;
      }
   }

   public static void runDeckTest(){

      if (DeckTest()){
         System.out.println("passed");
      } else {
         System.out.println("failed");
      }
   }

   //Deck Unit Test
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

