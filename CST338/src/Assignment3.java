/*
   Team: Robert Contreras, Hyo Lee, Ryan Doherty
   CST 338 - Fall 2015 Session A
   Assignment 3, Card Game
*/

import java.util.*;
public class Assignment3
{

   private static Scanner keyboard = new Scanner(System.in);

   public static void main(String[] args)
   {

      //Call test runs for Card, Hand, and Deck
      System.out.println("** CARD TEST **");
      cardTest();
      System.out.println();
      System.out.println("** DECK TEST **");
      deckTest();
      System.out.println();
      int myInt = getInputInt();
      System.out.println(myInt);
      
      Deck deck = new Deck();
      Hand[] playerHand = new Hand[myInt];
      /*int x=0;
      while (deck.getTopCard()>0){
          System.out.println("card: " + deck.getTopCard());
             if (playerHand[x]==null){
                 System.out.println(x);
                 playerHand[x]=new Hand();
             }
             playerHand[x].takeCard(deck.dealCard());
             if (x==myInt){
                 x=0;
              }else{
                 x++;
              }

             System.out.println(" --" + x);
      }
      
      for (int y=0;y<myInt;y++){
          System.out.println(playerHand[y]);
      }*/
      
      keyboard.close();
   }

   public static int getInputInt()
   {
      System.out.print("How many hands? (1 - 10, please): ");
      int inputInt = 0;
      while (inputInt < 1 || inputInt > 10)
      {
         try {
            inputInt = keyboard.nextInt();
         } catch (InputMismatchException e) {
            // Flushes previous input
            keyboard.nextLine();
            inputInt = 0;
         }
         if (inputInt < 1 || inputInt > 10)
            System.out.print("Please enter a value between 1-10: ");
      }
      return inputInt;
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
