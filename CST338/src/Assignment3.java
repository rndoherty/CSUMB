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
      cardTest();
      System.out.println();
      System.out.println("** DECK TEST **");
      deckTest();
      System.out.println();
   }

   //Card Test
   public static void cardTest(){

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
   }

   //Deck Test 
   //Loop through 2 packs unshuffled then shuffled
   //Loop through 1 pack unshuffled then shuffled
   public static void deckTest(){

           int packs = 2;
           System.out.println(packs + " decks unshuffled");
           Deck testDeck2 = new Deck(packs);
           for (int i=0;i<packs;i++){    
               for (int x = 0;x<52;x++){
                   System.out.print(" / " + testDeck2.dealCard() + " ");
                   if (((x+1)%5)==0){
                       System.out.print(" / " );
                       System.out.println();
                       }
               }
               System.out.print(" / " );
               System.out.println();
               System.out.println();

           }

           System.out.println(packs + " decks shuffled");
           testDeck2.init(packs);
           testDeck2.shuffle();
           for (int i = 0; i < packs; i++){
               for (int x = 0; x < 52; x++){
                   System.out.print(" / " + testDeck2.dealCard() + " ");
                   if (((x+1)%5)==0){
                       System.out.print(" / " );

                       System.out.println();
                   }
               }
               System.out.print(" / " );
               System.out.println();
               System.out.println();
           }
           
           Deck testDeck = new Deck();
           System.out.println("1 deck unshuffled");
           for (int x = 0;x<(52);x++){
               Card testCard = testDeck.dealCard();
               System.out.print(" / " + testCard + " ");
               if (((x+1)%5)==0){
                   System.out.print(" / " );
                   System.out.println();
                   }
           }
           System.out.print(" / " );
           System.out.println();
           System.out.println();

           System.out.println("1 deck shuffled");
           testDeck.init(1);
           testDeck.shuffle();
           for (int x = 0;x<(52);x++){
               Card testCard = testDeck.dealCard();
               System.out.print(" / " + testCard + " ");
               if (((x+1)%5)==0){
                   System.out.print(" / " );
                   System.out.println();
                   }
           }
           System.out.print(" / " );
           System.out.println();
           System.out.println();
           
           
           
           System.out.println();
   }
}
