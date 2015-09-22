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

      //Call test runs for Card, Hand, and Deck
      System.out.println("** CARD TEST **");
      runCardTest();
      System.out.println();
      System.out.println("** HAND TEST **");
      runHandTest();
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

   //Hand Unit Test
   public static boolean handTest() {
      Card.Suit club = Card.Suit.clubs;
      Card.Suit spade = Card.Suit.spades;
      Card.Suit diamonds = Card.Suit.diamonds;

      Card testCard1 = new Card('T', spade);
      Card testCard2 = new Card('K', club);
      Card testCard3 = new Card('2', diamonds);
      Hand testHand = new Hand();


      for (int i = 0; i <= testHand.MAX_CARDS; i++) {
         if (testHand.takeCard(testCard1) &&
               testHand.takeCard(testCard2) &&
               testHand.takeCard(testCard3)) ;
      }
      System.out.println("Hand full");
      System.out.println("After deal");
      System.out.println(testHand);
      System.out.println();
      System.out.println(testHand.inspectCard(29));
      System.out.println(testHand.inspectCard(2));
      System.out.println(testHand.inspectCard(13));

      for (int i = testHand.MAX_CARDS; i > 0; i--) {

         System.out.println("Playing " + testHand.playCard());
      }
      System.out.println();
      System.out.println("After playing all cards");
      System.out.println(testHand);
      return true;
   }

   //Deck Unit Test - Loop through 2 packs unshuffled and 8 packs shuffled
   public static boolean deckTest(){
       try {
           int packs = 8;
           Deck testDeck = new Deck();
           System.out.println("1 deck unshuffled");
           for (int x = 0; x < (52); x++){
               Card testCard = testDeck.dealCard();
               System.out.print(" | " + testCard + " ");
               if (((x + 1) %5) == 0){
                   System.out.print(" | " );
                   System.out.println();
               }
           }

           System.out.println();
           System.out.println();
           System.out.println(packs + " decks shuffled");
           Deck testDeck2 = new Deck(packs);
           testDeck2.shuffle();
           for (int i = 0; i < packs; i++){
               for (int x = 0; x < 52; x++){
                   Card testCard2 = testDeck2.dealCard();
                   System.out.print(" | " + testCard2 + " ");
                   if (((x + 1) %5) == 0){
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