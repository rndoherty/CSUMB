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

      System.out.println("** CARD TEST **");
      runCardTest();
      System.out.println();
      System.out.println("** DECK TEST **");
      runDeckTest();
      System.out.println();
   }

   public static void runCardTest()
   {
      if (cardTest()){
         System.out.println("passed");
      } else {
         System.out.println("failed");
      }
   }
   
   //Card Unit Test
   public static boolean cardTest(){

      Card.Suit club = Card.Suit.clubs;
      Card.Suit spade = Card.Suit.spades;
      Card.Suit diamonds = Card.Suit.diamonds;
      Card testCard0 = new Card();
      Card testCard1 = new Card('0', club);
      Card testCard2 = new Card('J', spade);
      Card testCard3 = new Card('Y', diamonds);

      System.out.println(testCard0);
      System.out.println(testCard1);
      System.out.println(testCard2);
      System.out.println(testCard3);
      return true;
   }

   public static void runDeckTest(){

      if (deckTest()){
         System.out.println("passed");
      } else {
         System.out.println("failed");
      }
   }

   //Deck Unit Test
   public static boolean deckTest(){
       try {
           int packs = 8;
           Deck testDeck = new Deck();
           System.out.println("1 deck unshuffled");
           for (int x = 0;x<(52);x++){
               Card testCard = testDeck.dealCard();
               System.out.print(" | " + testCard + " ");
               if (((x+1)%5)==0){
                   System.out.print(" | " );
                   System.out.println();
                   }
           }

           System.out.println();
           System.out.println();
           System.out.println(packs + " decks shuffled");
           Deck testDeck2 = new Deck(packs);
           testDeck2.shuffle();
           for (int i=0;i<packs;i++){    
               for (int x = 0;x<52;x++){
                   Card testCard2 = testDeck2.dealCard();
                   System.out.print(" | " + testCard2 + " ");
                   if (((x+1)%5)==0){
                       System.out.print(" | " );
                       System.out.println();
                       }
               }
               System.out.println();
               System.out.println();
           }
           System.out.println();
           return true;
       } catch (Exception e) {
           return false;
       }
   }

}

