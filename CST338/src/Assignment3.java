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
      System.out.println("** HAND TEST **");
      handTest();
      System.out.println();
      System.out.println("** DECK TEST **");
      deckTest();
      System.out.println();
      int players = getInputInt();
      System.out.println(players);
     
      Deck deck = new Deck();
      Hand[] playerHand = new Hand[players];
    
      while (deck.getTopCard()>=0){
          for (int x=0;x<players;x++){
              if (deck.getTopCard()<0) break;
              if (playerHand[x]==null){
                 playerHand[x]=new Hand();
             }
             playerHand[x].takeCard(deck.dealCard());
             if (x==players){x=0;}
          }
             
      }
      System.out.println();
      System.out.println(players + " hands from unshuffled deck.");
      for (int y=0;y<players;y++){
          System.out.println(playerHand[y]);
      }
      
      Hand[] playerHand2 = new Hand[players];
      deck.init(1);
      deck.shuffle();
      while (deck.getTopCard()>=0){
          for (int x=0;x<players;x++){
             if (deck.getTopCard()<0) break;
              if (playerHand2[x]==null){
                 playerHand2[x]=new Hand();
             }
             playerHand2[x].takeCard(deck.dealCard());
             if (x==players){x=0;}
          }
             
      }
      System.out.println();
      System.out.println(players + " hands from shuffled deck.");
      for (int y=0;y<players;y++){
          System.out.println(playerHand2[y]);
      }
      
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

   //Hand Test
   public static void handTest() {
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
