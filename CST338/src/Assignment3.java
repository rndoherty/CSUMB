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

      //System.out.println();

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

      Card.Suit club = Card.Suit.clubs;
      Card.Suit spade = Card.Suit.spades;
      Card.Suit diamonds = Card.Suit.diamonds;

      try {
         Card testCard0 = new Card();
         Card testCard1 = new Card('0', club);
         Card testCard2 = new Card('J', spade);
         Card testCard3 = new Card('Y', diamonds);
         System.out.println(testCard0);
         System.out.println(testCard1);
         System.out.println(testCard2);
         System.out.println(testCard3);
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
           int packs = 2;
           //Deck testDeck = new Deck();
           Deck testDeck = new Deck(packs);
           testDeck.shuffle();
           for (int x = 0;x<(52*packs);x++){
               Card testCard = testDeck.dealCard();
               //System.out.println(testCard.toString());
           }
           
           Deck testDeck2 = new Deck(packs);
           testDeck2.shuffle();
           for (int x = 0;x<(52*packs);x++){
               Card testCard2 = testDeck2.dealCard();
               System.out.println(testCard2.toString());
           }
           
           return true;
       } catch (Exception e) {
           System.err.println( e.getMessage());
           return false;
       }
   }

}

