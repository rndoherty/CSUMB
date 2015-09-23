/**
   CST 338 - Fall 2015 Session A
   Assignment 3, Card Game
   @author Robert Contreras
   @author Ryan Doherty
   @author Hyo Lee
*/

import java.util.*;

public class Assignment3
{
   private static Scanner keyboard = new Scanner(System.in);

   public static void main(String[] args)
   {
      //Call test runs for Card, Hand, and Deck
      // Phase 1 test
      System.out.println("** CARD TEST **");
      cardTest();
      System.out.println();
      // Phase 2 test
      System.out.println("** HAND TEST **");
      handTest();
      System.out.println();
      // Phase 3 test
      System.out.println("** DECK TEST **");
      deckTest();
      System.out.println();
      // Phase 4 test
      System.out.println("** DECK + HAND TEST **");
      int players = getInputInt();
      System.out.println(players);
      Deck deck = new Deck();
      Hand[] playerHand = new Hand[players];
      deckHandTest(players, deck, playerHand, "unshuffled");

      // Test with shuffled Deck
      Hand[] playerHand2 = new Hand[players];
      deck.init(1);
      deck.shuffle();
      deckHandTest(players, deck, playerHand2, "shuffled");

      keyboard.close();
   }

   // Input validation method for Phase 4 tests
   public static int getInputInt()
   {
      System.out.print("How many hands? (1 - 10, please): ");
      int inputInt = 0;
      while (inputInt < 1 || inputInt > 10)
      {
         // Use an exception to insure proper int input
         try
         {
            inputInt = keyboard.nextInt();
         }
         // If anything but an int...
         catch (InputMismatchException e)
         {
            // Flushes previous input
            keyboard.nextLine();
            inputInt = 0;
         }
         if (inputInt < 1 || inputInt > 10)
            System.out.print("Please enter a value between 1-10: ");
      }
      return inputInt;
   }

   // Phase 4 testing method
   public static void deckHandTest(int players, Deck deck,
      Hand[] hand, String shuffleState)
   {
      while (deck.getTopCard() >= 0)
      {
         for (int x = 0; x < players; x++)
         {
            if (deck.getTopCard() < 0) break;
            if (hand[x] == null)
            {
               hand[x] = new Hand();
            }
            hand[x].takeCard(deck.dealCard());
            if (x == players)
            {
               x = 0;
            }
         }

      }
      System.out.println();
      System.out.println(players + " hands from " + shuffleState + " deck.");
      for (int y = 0; y < players; y++)
      {
         System.out.println(hand[y]);
      }
   }

   //Card Test
   public static void cardTest()
   {
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
   public static void handTest()
   {
      Card.Suit club = Card.Suit.clubs;
      Card.Suit spade = Card.Suit.spades;
      Card.Suit diamonds = Card.Suit.diamonds;

      Card testCard1 = new Card('T', spade);
      Card testCard2 = new Card('K', club);
      Card testCard3 = new Card('2', diamonds);
      Hand testHand = new Hand();

      for (int i = 0; i <= Hand.MAX_CARDS; i++)
      {
         if (testHand.takeCard(testCard1) &&
               testHand.takeCard(testCard2) &&
               testHand.takeCard(testCard3)) ;
      }
      System.out.println("Hand full");
      System.out.println("After deal");
      System.out.println(testHand);
      System.out.println();
      System.out.println(testHand.inspectCard(80));
      System.out.println(testHand.inspectCard(101));
      System.out.println(testHand.inspectCard(0));
      System.out.println(testHand.inspectCard(120));
      System.out.println();

      for (int i = Hand.MAX_CARDS; i > 0; i--)
      {

         System.out.println("Playing " + testHand.playCard());
      }
      System.out.println();
      System.out.println("After playing all cards");
      System.out.println(testHand);

   }

   //Deck Test
   //Loop through 2 packs unshuffled then shuffled
   //Loop through 1 pack unshuffled then shuffled
   public static void deckTest()
   {
      int packs = 2;
      System.out.println(packs + " decks unshuffled");
      Deck testDeck2 = new Deck(packs);
      for (int i = 0; i < packs; i++)
      {
         for (int x = 0; x < 52; x++)
         {
            System.out.print(" / " + testDeck2.dealCard() + " ");
            if (((x + 1) % 5) == 0)
            {
               System.out.print(" / ");
               System.out.println();
            }
         }
         System.out.print(" / ");
         System.out.println();
         System.out.println();

      }

      System.out.println(packs + " decks shuffled");
      testDeck2.init(packs);
      testDeck2.shuffle();
      for (int i = 0; i < packs; i++)
      {
         for (int x = 0; x < 52; x++)
         {
            System.out.print(" / " + testDeck2.dealCard() + " ");
            if (((x + 1) % 5) == 0)
            {
               System.out.print(" / ");

               System.out.println();
            }
         }
         System.out.print(" / ");
         System.out.println();
         System.out.println();
      }

      Deck testDeck = new Deck();
      System.out.println("1 deck unshuffled");
      for (int x = 0; x < (52); x++)
      {
         Card testCard = testDeck.dealCard();
         System.out.print(" / " + testCard + " ");
         if (((x + 1) % 5) == 0)
         {
            System.out.print(" / ");
            System.out.println();
         }
      }
      System.out.print(" / ");
      System.out.println();
      System.out.println();

      System.out.println("1 deck shuffled");
      testDeck.init(1);
      testDeck.shuffle();
      for (int x = 0; x < (52); x++)
      {
         Card testCard = testDeck.dealCard();
         System.out.print(" / " + testCard + " ");
         if (((x + 1) % 5) == 0)
         {
            System.out.print(" / ");
            System.out.println();
         }
      }
      System.out.print(" / ");
      System.out.println();
      System.out.println();

      System.out.println();
   }
}

/*
   Set valid suits and values for each card in a standard deck
*/

class Card
{
   // Valid suits
   public enum Suit
   {
      clubs, diamonds, hearts, spades
   }

   // Adding this array so we can know what values are valid
   public static char[] Value = {'A', '2', '3', '4', '5', '6', '7', '8',
         '9', 'T', 'J', 'Q', 'K'};

   private char value;
   private Suit suit;
   private boolean errorFlag;

   // Default Constructor
   public Card()
   {
      value = 'A';
      suit = Suit.spades;
      errorFlag = false;
   }

   // Overloaded Constructor
   public Card(char value, Suit suit)
   {
      errorFlag = !set(value, suit);
   }

   // Output message - invalid or display card
   public String toString()
   {
      if (errorFlag)
         return ("[ invalid ]");

      return (value + " of " + suit);
   }

   // Set and check the validity of the card
   public boolean set(char value, Suit suit)
   {
      if (isValid(value, suit))
      {
         this.value = value;
         this.suit = suit;
         return true;
      }
      return false;
   }

   // Accessors for suit, value, and error
   public Suit getSuit()
   {
      return suit;
   }

   public char getchar()
   {
      return value;
   }

   public boolean getErrorFlag()
   {
      return errorFlag;
   }

   // Both this value and suit objects are equal to passed in objects
   public boolean equals(Card card)
   {
      return card.value == value && card.suit == suit;
   }

   // Check if card has valid value and suit
   private boolean isValid(char value, Suit suit)
   {
      boolean valid = false;

      for (char v : Value)
      {
         if (value == v)
         {
            valid = true;
            break;
         }
      }

      if (valid)
      {
         for (Suit s : Suit.values())
         {
            if (suit == s)
               return true;
         }
      }
      return false;
   }
}

/*
   Hand class - Hand size, add cards to hand, and play cards from hands
 */
class Hand
{
   public static final int MAX_CARDS = 100; //Length of array

   private Card[] myCards;
   private int numCards;

   // Default constructor
   public Hand()
   {
      myCards = new Card[MAX_CARDS];   //Length
      numCards = 0;
   }

   // Remove all cards from the hand
   public void resetHand()
   {
      myCards = new Card[MAX_CARDS];
      numCards = 0;
   }

   // Adds a card to the next available position as an object copy
   public boolean takeCard(Card card)
   {
      if (numCards >= MAX_CARDS)
      {
         return false;
      } else
      {
         myCards[numCards] = card;
         numCards++;
         return true;
      }
   }

   // Returns and removes the card in the top occupied position
   public Card playCard()
   {
      Card card = myCards[numCards - 1];
      myCards[numCards - 1] = null;
      numCards--;
      return card;
   }

   // Output message
   public String toString()
   {
      String result = "Hand = ( ";
      if (numCards == 0)
      {
         result = result + ")";
      } else
      {
         for (int i = 0; i < numCards - 1; i++)
         {
            result = result + myCards[i] + ", ";
         }
         result = result + myCards[numCards - 1] + " )";
      }
      return result;
   }

   // Accessor for number of cards
   public int getNumCards()
   {
      return numCards;
   }

   // Accessor for each card
   public Card inspectCard(int k)
   {
      Card card;
      if (k > numCards)
      {
         card = new Card('y', Card.Suit.spades);
      } else
      {
         card = myCards[k];
      }
      return card;
   }
}

/*
   Deck class - Set size of deck, shuffle, and deal cards
*/

class Deck
{
   private static final int PACK_SIZE = 52;
   public final int MAX_CARDS = 6 * PACK_SIZE;
   private static Card[] masterPack = new Card[PACK_SIZE];
   public static boolean masterPackAllocated = false;

   private Card[] cards;

   private int topCard;
   private int numPacks;

   // Constructor for initial numPacks
   public Deck(int numPacks)
   {
      this.cards = new Card[numPacks * PACK_SIZE];
      this.numPacks = numPacks;
      this.topCard = numPacks * PACK_SIZE - 1;
      allocateMasterPack();
      init(numPacks);
   }

   // Overloaded Default Constructor
   public Deck()
   {
      this.numPacks = 1;
      this.cards = new Card[PACK_SIZE];
      this.topCard = PACK_SIZE - 1;
      allocateMasterPack();
      init(1);
   }

   // Private helper method called by Constructor to build masterPack only once
   private static void allocateMasterPack()
   {
      if (!masterPackAllocated)
      {
         int x = 0;
         for (Card.Suit suit : Card.Suit.values())
         {
            for (char value : Card.Value)
            {
               masterPack[x] = new Card(value, suit);
               x++;
            }
         }
         masterPackAllocated = true;
      }
   }

   //Initialize and Re-populate cards array
   public void init(int numPacks)
   {
      this.cards = new Card[numPacks * PACK_SIZE];
      this.numPacks = numPacks;
      this.topCard = numPacks * PACK_SIZE - 1;
      int cardNum = 0;
      while (cardNum < numPacks * PACK_SIZE)
      {
         for (int x = 0; x < numPacks; x++)
         {
            for (int y = 0; y < PACK_SIZE; y++)
            {
               cards[cardNum] = masterPack[y];
               cardNum++;
            }
         }
      }
   }

   // Mix up cards with random number generator
   public void shuffle()
   {
      Random rnd = new Random();
      for (int i = cards.length - 1; i > 0; i--)
      {
         int index = rnd.nextInt(i + 1);
         Card temp = cards[index];
         cards[index] = cards[i];
         cards[i] = temp;
      }
   }

   // Returns and removes the card  at the top position
   public Card dealCard()
   {
      int tCard = topCard;
      topCard--;
      return cards[tCard];
   }

   // Accessor for topCard
   public int getTopCard()
   {
      return topCard;
   }

   // Accessor for each card
   public Card inspectCard(int k)
   {
      Card testCard;
      if (k>cards.length || k>topCard){
          testCard = new Card('y', Card.Suit.spades);
      } else {
          testCard = cards[k];
      }
      return testCard;
   }
}

/********************** Test Run ***********************
** CARD TEST **
A of spades
[ invalid ]
J of spades
[ invalid ]

** HAND TEST **
Hand full
After deal
Hand = ( T of spades, K of clubs, 2 of diamonds, T of spades, K of clubs, 2 of diamonds, T of spades, K of clubs, 2 of diamonds, T of spades, K of clubs, 2 of diamonds, T of spades, K of clubs, 2 of diamonds, T of spades, K of clubs, 2 of diamonds, T of spades, K of clubs, 2 of diamonds, T of spades, K of clubs, 2 of diamonds, T of spades, K of clubs, 2 of diamonds, T of spades, K of clubs, 2 of diamonds, T of spades, K of clubs, 2 of diamonds, T of spades, K of clubs, 2 of diamonds, T of spades, K of clubs, 2 of diamonds, T of spades, K of clubs, 2 of diamonds, T of spades, K of clubs, 2 of diamonds, T of spades, K of clubs, 2 of diamonds, T of spades, K of clubs, 2 of diamonds, T of spades, K of clubs, 2 of diamonds, T of spades, K of clubs, 2 of diamonds, T of spades, K of clubs, 2 of diamonds, T of spades, K of clubs, 2 of diamonds, T of spades, K of clubs, 2 of diamonds, T of spades, K of clubs, 2 of diamonds, T of spades, K of clubs, 2 of diamonds, T of spades, K of clubs, 2 of diamonds, T of spades, K of clubs, 2 of diamonds, T of spades, K of clubs, 2 of diamonds, T of spades, K of clubs, 2 of diamonds, T of spades, K of clubs, 2 of diamonds, T of spades, K of clubs, 2 of diamonds, T of spades, K of clubs, 2 of diamonds, T of spades, K of clubs, 2 of diamonds, T of spades, K of clubs, 2 of diamonds, T of spades )

2 of diamonds
[ invalid ]
T of spades
[ invalid ]

Playing T of spades
Playing 2 of diamonds
Playing K of clubs
Playing T of spades
Playing 2 of diamonds
Playing K of clubs
Playing T of spades
Playing 2 of diamonds
Playing K of clubs
Playing T of spades
Playing 2 of diamonds
Playing K of clubs
Playing T of spades
Playing 2 of diamonds
Playing K of clubs
Playing T of spades
Playing 2 of diamonds
Playing K of clubs
Playing T of spades
Playing 2 of diamonds
Playing K of clubs
Playing T of spades
Playing 2 of diamonds
Playing K of clubs
Playing T of spades
Playing 2 of diamonds
Playing K of clubs
Playing T of spades
Playing 2 of diamonds
Playing K of clubs
Playing T of spades
Playing 2 of diamonds
Playing K of clubs
Playing T of spades
Playing 2 of diamonds
Playing K of clubs
Playing T of spades
Playing 2 of diamonds
Playing K of clubs
Playing T of spades
Playing 2 of diamonds
Playing K of clubs
Playing T of spades
Playing 2 of diamonds
Playing K of clubs
Playing T of spades
Playing 2 of diamonds
Playing K of clubs
Playing T of spades
Playing 2 of diamonds
Playing K of clubs
Playing T of spades
Playing 2 of diamonds
Playing K of clubs
Playing T of spades
Playing 2 of diamonds
Playing K of clubs
Playing T of spades
Playing 2 of diamonds
Playing K of clubs
Playing T of spades
Playing 2 of diamonds
Playing K of clubs
Playing T of spades
Playing 2 of diamonds
Playing K of clubs
Playing T of spades
Playing 2 of diamonds
Playing K of clubs
Playing T of spades
Playing 2 of diamonds
Playing K of clubs
Playing T of spades
Playing 2 of diamonds
Playing K of clubs
Playing T of spades
Playing 2 of diamonds
Playing K of clubs
Playing T of spades
Playing 2 of diamonds
Playing K of clubs
Playing T of spades
Playing 2 of diamonds
Playing K of clubs
Playing T of spades
Playing 2 of diamonds
Playing K of clubs
Playing T of spades
Playing 2 of diamonds
Playing K of clubs
Playing T of spades
Playing 2 of diamonds
Playing K of clubs
Playing T of spades
Playing 2 of diamonds
Playing K of clubs
Playing T of spades
Playing 2 of diamonds
Playing K of clubs
Playing T of spades

After playing all cards
Hand = ( )

** DECK TEST **
2 decks unshuffled
 / K of spades  / Q of spades  / J of spades  / T of spades  / 9 of spades  /
 / 8 of spades  / 7 of spades  / 6 of spades  / 5 of spades  / 4 of spades  /
 / 3 of spades  / 2 of spades  / A of spades  / K of hearts  / Q of hearts  /
 / J of hearts  / T of hearts  / 9 of hearts  / 8 of hearts  / 7 of hearts  /
 / 6 of hearts  / 5 of hearts  / 4 of hearts  / 3 of hearts  / 2 of hearts  /
 / A of hearts  / K of diamonds  / Q of diamonds  / J of diamonds  / T of diamonds  /
 / 9 of diamonds  / 8 of diamonds  / 7 of diamonds  / 6 of diamonds  / 5 of diamonds  /
 / 4 of diamonds  / 3 of diamonds  / 2 of diamonds  / A of diamonds  / K of clubs  /
 / Q of clubs  / J of clubs  / T of clubs  / 9 of clubs  / 8 of clubs  /
 / 7 of clubs  / 6 of clubs  / 5 of clubs  / 4 of clubs  / 3 of clubs  /
 / 2 of clubs  / A of clubs  /

 / K of spades  / Q of spades  / J of spades  / T of spades  / 9 of spades  /
 / 8 of spades  / 7 of spades  / 6 of spades  / 5 of spades  / 4 of spades  /
 / 3 of spades  / 2 of spades  / A of spades  / K of hearts  / Q of hearts  /
 / J of hearts  / T of hearts  / 9 of hearts  / 8 of hearts  / 7 of hearts  /
 / 6 of hearts  / 5 of hearts  / 4 of hearts  / 3 of hearts  / 2 of hearts  /
 / A of hearts  / K of diamonds  / Q of diamonds  / J of diamonds  / T of diamonds  /
 / 9 of diamonds  / 8 of diamonds  / 7 of diamonds  / 6 of diamonds  / 5 of diamonds  /
 / 4 of diamonds  / 3 of diamonds  / 2 of diamonds  / A of diamonds  / K of clubs  /
 / Q of clubs  / J of clubs  / T of clubs  / 9 of clubs  / 8 of clubs  /
 / 7 of clubs  / 6 of clubs  / 5 of clubs  / 4 of clubs  / 3 of clubs  /
 / 2 of clubs  / A of clubs  /

2 decks shuffled
 / 3 of spades  / 4 of hearts  / J of hearts  / K of spades  / T of diamonds  /
 / 5 of diamonds  / 9 of clubs  / Q of hearts  / K of clubs  / 2 of clubs  /
 / 9 of hearts  / 3 of diamonds  / 5 of diamonds  / J of clubs  / 6 of spades  /
 / A of diamonds  / J of diamonds  / 6 of clubs  / 7 of spades  / A of spades  /
 / K of hearts  / 9 of diamonds  / 2 of spades  / 9 of spades  / Q of spades  /
 / J of spades  / K of spades  / A of hearts  / K of diamonds  / Q of hearts  /
 / 3 of clubs  / 6 of hearts  / 4 of diamonds  / 7 of spades  / J of spades  /
 / 5 of spades  / 7 of diamonds  / 2 of diamonds  / 8 of spades  / 8 of clubs  /
 / 6 of diamonds  / J of clubs  / 6 of spades  / 5 of hearts  / 8 of hearts  /
 / 8 of diamonds  / 3 of diamonds  / 4 of spades  / 8 of hearts  / 7 of clubs  /
 / 3 of hearts  / 2 of spades  /

 / 6 of clubs  / T of hearts  / 5 of clubs  / T of hearts  / 3 of spades  /
 / J of diamonds  / 4 of clubs  / 5 of spades  / T of diamonds  / 7 of hearts  /
 / 5 of clubs  / J of hearts  / A of diamonds  / T of clubs  / 7 of diamonds  /
 / K of diamonds  / 4 of hearts  / Q of diamonds  / Q of clubs  / 2 of hearts  /
 / 4 of diamonds  / 8 of spades  / A of spades  / 6 of diamonds  / A of clubs  /
 / T of clubs  / 9 of hearts  / 6 of hearts  / 7 of hearts  / 8 of diamonds  /
 / 5 of hearts  / A of hearts  / 8 of clubs  / 3 of clubs  / Q of spades  /
 / K of hearts  / Q of diamonds  / T of spades  / T of spades  / 3 of hearts  /
 / Q of clubs  / A of clubs  / 2 of diamonds  / K of clubs  / 7 of clubs  /
 / 9 of spades  / 2 of clubs  / 9 of diamonds  / 9 of clubs  / 2 of hearts  /
 / 4 of clubs  / 4 of spades  /

1 deck unshuffled
 / K of spades  / Q of spades  / J of spades  / T of spades  / 9 of spades  /
 / 8 of spades  / 7 of spades  / 6 of spades  / 5 of spades  / 4 of spades  /
 / 3 of spades  / 2 of spades  / A of spades  / K of hearts  / Q of hearts  /
 / J of hearts  / T of hearts  / 9 of hearts  / 8 of hearts  / 7 of hearts  /
 / 6 of hearts  / 5 of hearts  / 4 of hearts  / 3 of hearts  / 2 of hearts  /
 / A of hearts  / K of diamonds  / Q of diamonds  / J of diamonds  / T of diamonds  /
 / 9 of diamonds  / 8 of diamonds  / 7 of diamonds  / 6 of diamonds  / 5 of diamonds  /
 / 4 of diamonds  / 3 of diamonds  / 2 of diamonds  / A of diamonds  / K of clubs  /
 / Q of clubs  / J of clubs  / T of clubs  / 9 of clubs  / 8 of clubs  /
 / 7 of clubs  / 6 of clubs  / 5 of clubs  / 4 of clubs  / 3 of clubs  /
 / 2 of clubs  / A of clubs  /

1 deck shuffled
 / 5 of hearts  / K of diamonds  / 8 of spades  / T of spades  / 9 of diamonds  /
 / Q of spades  / 7 of hearts  / 8 of diamonds  / 6 of hearts  / 9 of clubs  /
 / 3 of clubs  / T of clubs  / K of hearts  / 5 of clubs  / A of diamonds  /
 / J of hearts  / 7 of spades  / 7 of clubs  / 6 of clubs  / Q of clubs  /
 / 6 of spades  / 6 of diamonds  / 8 of clubs  / 2 of spades  / Q of diamonds  /
 / 7 of diamonds  / A of clubs  / 5 of diamonds  / A of hearts  / T of diamonds  /
 / K of clubs  / 4 of clubs  / Q of hearts  / 8 of hearts  / 4 of spades  /
 / J of diamonds  / 3 of diamonds  / 4 of diamonds  / 2 of hearts  / 2 of clubs  /
 / 3 of spades  / 4 of hearts  / 9 of spades  / J of clubs  / A of spades  /
 / K of spades  / T of hearts  / J of spades  / 9 of hearts  / 3 of hearts  /
 / 2 of diamonds  / 5 of spades  /



** DECK + HAND TEST **
How many hands? (1 - 10, please): 10
10

10 hands from unshuffled deck.
Hand = ( K of spades, 3 of spades, 6 of hearts, 9 of diamonds, Q of clubs, 2 of clubs )
Hand = ( Q of spades, 2 of spades, 5 of hearts, 8 of diamonds, J of clubs, A of clubs )
Hand = ( J of spades, A of spades, 4 of hearts, 7 of diamonds, T of clubs )
Hand = ( T of spades, K of hearts, 3 of hearts, 6 of diamonds, 9 of clubs )
Hand = ( 9 of spades, Q of hearts, 2 of hearts, 5 of diamonds, 8 of clubs )
Hand = ( 8 of spades, J of hearts, A of hearts, 4 of diamonds, 7 of clubs )
Hand = ( 7 of spades, T of hearts, K of diamonds, 3 of diamonds, 6 of clubs )
Hand = ( 6 of spades, 9 of hearts, Q of diamonds, 2 of diamonds, 5 of clubs )
Hand = ( 5 of spades, 8 of hearts, J of diamonds, A of diamonds, 4 of clubs )
Hand = ( 4 of spades, 7 of hearts, T of diamonds, K of clubs, 3 of clubs )

10 hands from shuffled deck.
Hand = ( A of spades, 7 of clubs, 3 of spades, Q of spades, Q of clubs, 8 of clubs )
Hand = ( 9 of diamonds, A of hearts, 6 of diamonds, 4 of diamonds, 2 of diamonds, 8 of spades )
Hand = ( 5 of clubs, 3 of clubs, J of hearts, 5 of hearts, Q of diamonds )
Hand = ( 9 of clubs, K of diamonds, J of spades, 3 of hearts, 2 of clubs )
Hand = ( 7 of diamonds, 9 of hearts, 7 of hearts, 7 of spades, 3 of diamonds )
Hand = ( T of spades, K of hearts, 5 of diamonds, 8 of diamonds, K of spades )
Hand = ( J of diamonds, 6 of hearts, A of diamonds, T of clubs, 4 of clubs )
Hand = ( 8 of hearts, T of hearts, 6 of clubs, 6 of spades, 5 of spades )
Hand = ( A of clubs, T of diamonds, Q of hearts, 2 of hearts, J of clubs )
Hand = ( 4 of hearts, 9 of spades, 2 of spades, K of clubs, 4 of spades )

 *******************************************************/
