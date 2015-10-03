/**
 * CST 338 - Fall 2015 Session A
 * Assignment 5, GUI Cards - High Card
 * Phase II
 * @author Robert Contreras
 * @author Ryan Doherty
 * @author Hyo Lee
 */

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Assignment5
{

    static int NUM_CARDS_PER_HAND = 7;
    static int  NUM_PLAYERS = 2;
    static JLabel[] computerLabels = new JLabel[NUM_CARDS_PER_HAND];
    static JLabel[] humanLabels = new JLabel[NUM_CARDS_PER_HAND];  
    static JLabel[] playedCardLabels  = new JLabel[NUM_PLAYERS]; 
    static JLabel[] playLabelText  = new JLabel[NUM_PLAYERS]; 
    
    static final int NUM_CARD_IMAGES = 56; // 52 + 4 jokers
    //static Icon[] icon = new ImageIcon[NUM_CARD_IMAGES];
    
    public static void main(String[] args)
    {
       int k;
       Icon tempIcon;
       //System.out.println(Arrays.asList(Card.Value).indexOf("A"));
       //System.out.println(Card.Value[0]);
       
       Deck myDeck = new Deck();
       
       GUICard cardGUI = new GUICard();
       
       // establish main frame in which program will run
       CardTable myCardTable 
          = new CardTable("CardTable", NUM_CARDS_PER_HAND, NUM_PLAYERS);
       myCardTable.setSize(800, 600);
       myCardTable.setLocationRelativeTo(null);
       myCardTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       // show everything to the user
       myCardTable.setVisible(true);

       // CREATE LABELS ----------------------------------------------------
       
       // prepare the image label arrays
       //computerLabels = new JLabel[NUM_CARDS_PER_HAND];
       
       
       for (k = 0; k < NUM_CARDS_PER_HAND; k++)
           computerLabels[k] = new JLabel(cardGUI.getBackCardIcon());
       
       //humanLabels = new JLabel[NUM_CARDS_PER_HAND];
       for (k = 0; k < NUM_CARDS_PER_HAND; k++)
           humanLabels[k] = new JLabel(cardGUI.getIcon(generateRandomCard(myDeck)));
   
       // ADD LABELS TO PANELS -----------------------------------------
       //code goes here ...
       
       for (k = 0; k < NUM_CARDS_PER_HAND; k++)
           myCardTable.pnlComputerHand.add(computerLabels[k]);
       
       for (k = 0; k < NUM_CARDS_PER_HAND; k++)
           myCardTable.pnlHumanHand.add(humanLabels[k]);
       // and two random cards in the play region (simulating a computer/hum ply)
       //code goes here ...

       // show everything to the user
       myCardTable.setVisible(true);
    }
    
    
 // static for the 57 icons and their corresponding labels
    // normally we would not have a separate label for each card, but
    // if we want to display all at once using labels, we need to.
    
    //static final int NUM_CARD_IMAGES = 57; // 52 + 4 jokers + 1 back-of-card image
    //static Icon[] icon = new ImageIcon[NUM_CARD_IMAGES];
       
    
    
    // a simple main to throw all the JLabels out there for the world to see
    //public static void main(String[] args)
    //{
     //  int k;
       
       // prepare the image icon array
       //loadCardIcons();
       
       // establish main frame in which program will run
       //JFrame frmMyWindow = new JFrame("Card Room");
       //frmMyWindow.setSize(1150, 650);
       //frmMyWindow.setLocationRelativeTo(null);
       //frmMyWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       // set up layout which will control placement of buttons, etc.
       //FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 5, 20);   
       //frmMyWindow.setLayout(layout);
       /*
       // prepare the image label array
       JLabel[] labels = new JLabel[NUM_CARD_IMAGES];
       for (k = 0; k < NUM_CARD_IMAGES; k++)
          labels[k] = new JLabel(icon[k]);
       
       // place your 3 controls into frame
       for (k = 0; k < NUM_CARD_IMAGES; k++)
          frmMyWindow.add(labels[k]);*/

       //CardTable cTable = new CardTable("Card Table", 56, 2);
       //cTable.setVisible(true);
       //frmMyWindow.add(cTable);
       // show everything to the user
       //frmMyWindow.setVisible(true);
       
       
    //}
    
    //TODO: make this random without dealing
    //remove deck param
    private static Card generateRandomCard(Deck testDeck){
        return testDeck.dealCard();
    }

}

class CardTable extends JFrame {
    static int MAX_CARDS_PER_HAND = 56;
    static int MAX_PLAYERS = 2;  // for now, we only allow 2 person games
    
    private int numCardsPerHand;
    private int numPlayers;

    public JPanel pnlComputerHand, pnlHumanHand, pnlPlayArea;
    
    public CardTable(String title, int numCardsPerHand, int numPlayers){
        super(title);
        if (!isValid(title, numCardsPerHand,numPlayers)) return;
        setSize(1150, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel mainPanel = new JPanel();
        pnlComputerHand = new JPanel();
        pnlHumanHand = new JPanel();
        pnlPlayArea = new JPanel();
        mainPanel.setLayout(new GridLayout(1,3));
        
        //TODO: remove background color after testing
        pnlComputerHand.setBackground(Color.GRAY);
        pnlHumanHand.setBackground(Color.WHITE);
        pnlPlayArea.setBackground(Color.BLUE);
        //-----
        
        mainPanel.add(pnlHumanHand);
        mainPanel.add(pnlPlayArea);
        mainPanel.add(pnlComputerHand);
        add(mainPanel, BorderLayout.CENTER);
    }
    
    private boolean isValid(String title, int numCardsPerHand, int numPlayers){
        if (title.length()<=0 || 
                numCardsPerHand<=0 || 
                numCardsPerHand>MAX_CARDS_PER_HAND || 
                numPlayers <=0 || 
                numPlayers >  MAX_PLAYERS) return false;
        return true;
    }
    
    public int getNumCardsPerHand(){
        return numCardsPerHand;
    }
    
    public int getNumPlayers(){
        return numPlayers;
    }
    
}

class GUICard {
    
    private static Icon[][] iconCards = new ImageIcon[14][4]; // 14 = A thru K + joker
    private static Icon iconBack;
    static boolean iconsLoaded = false;

    // Adding this array so we can know what values are valid
    //public static char[] cardValues = {'A', '2', '3', '4', '5', '6', '7', '8',
    //      '9', 'T', 'J', 'Q', 'K', 'X'};

    private static String[] cardSuites = new String[] {"C","D","H","S"};
    
    public GUICard(){
        loadCardIcons();
    }

    static void loadCardIcons() {
       if (!iconsLoaded) {
           // build the file names ("AC.gif", "2C.gif", "3C.gif", "TC.gif", etc.)
           // in a SHORT loop.  For each file name, read it in and use it to
           // instantiate each of the 57 Icons in the icon[] array.
            //int x = 0;
            //int y = 0;
            for (int x=0;x<cardSuites.length;x++){
                for (int y=0;y<Card.Value.length;y++){
                    iconCards[y][x]=new ImageIcon("images/" + Card.Value[y]+cardSuites[x] + ".gif");
                }
            }
            iconBack=new ImageIcon("images/BK.gif");
            iconsLoaded=true;
       }
    }

    // turns 0 - 13 into "A", "2", "3", ... "Q", "K", "X"
    static String turnIntIntoCardValue(int k)
    {
       // an idea for a helper method (do it differently if you wish)
        return String.valueOf(Card.Value[k]);
    }
    
    // turns 0 - 3 into "C", "D", "H", "S"
    static String turnIntIntoCardSuit(int j)
    {
       // an idea for another helper method (do it differently if you wish)
        return cardSuites[j];
    }
    
    private static int valueAsInt(Card card){
        //TODO: remove this after testing
        System.out.println(card.getchar());
        String values = new String(Card.Value);
        //return Arrays.asList(Card.Value).indexOf(card.getchar());
        return values.indexOf(card.getchar());
        
    }

    private static int suitAsInt(Card card){
        //String suite;
       return card.getSuit().ordinal();
        
    }
    
    static public Icon getIcon(Card card) {
        System.out.println(valueAsInt(card) + " " + suitAsInt(card));
        return (Icon) iconCards[valueAsInt(card)][suitAsInt(card)];
    }
    
    static public Icon getBackCardIcon(){
        return (Icon) iconBack;
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
         '9', 'T', 'J', 'Q', 'K', 'X'};
   
   public static char[] valueRanks  = {'A', '2', '3', '4', '5', '6', '7', '8',
       '9', 'T', 'J', 'Q', 'K', 'X'};
   
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
   
   static void arraySort(Card[] cards, int arraySize){
       int j;
       boolean swap = true;   // set flag to true to begin first pass
       Card temp;   //holding variable

       while ( swap ) {
           swap = false;    //set flag to false awaiting a possible swap
              for( j=0;  j < arraySize -1;  j++ ) {
                     if ( (Arrays.asList(valueRanks).indexOf(cards[ j ].getchar())) >
                          (Arrays.asList(valueRanks).indexOf(cards[ j+1 ].getchar())) ) {
                             temp = cards[ j ];   //swap elements
                             cards[ j ] = cards[ j+1 ];
                             cards[ j+1 ] = temp;
                             swap = true;    //shows a swap occurred  
                    } 
              } 
        } 
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
      }
      else
      {
         Card newCard = new Card(card.getchar(), card.getSuit());
         myCards[numCards] = newCard;
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
      }
      else
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
      if (k > numCards || k<0)
      {
         card = new Card('y', Card.Suit.spades);
      }
      else
      {
         card = myCards[k];
      }
      return card;
   }
   
   public void sort(){
       Card.arraySort(myCards, myCards.length);
   }
   
}

/*
   Deck class - Set size of deck, shuffle, and deal cards
*/

class Deck
{
   private static final int PACK_SIZE = 56;
   public final int MAX_DECKS = 6;
   public final int MAX_CARDS = MAX_DECKS * PACK_SIZE;
   private static Card[] masterPack = new Card[PACK_SIZE];
   public static boolean masterPackAllocated = false;

   private Card[] cards;

   private int topCard;
   private int numPacks;

   // Constructor for initial numPacks
   public Deck(int numPacks)
   {
      //if numPacks is passed an invalid value,
      //default it to 1
      if (numPacks<0 || numPacks>MAX_DECKS) numPacks=1;
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

       //if numPacks is passed an invalid value,
       //default it to 1
      if (numPacks<0 || numPacks>MAX_DECKS) numPacks=1;
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
      if (k>topCard || k<0)
      {
          testCard = new Card('y', Card.Suit.spades);
      }
      else
      {
          testCard = cards[k];
      }
      return testCard;
   }
   
   //make sure that there are not too many instances of the card in the deck if you add it.
   //Return false if there will be too many.  It should put the card on the top of the deck.
   public boolean addCard(Card card){
       if (Arrays.asList(cards).indexOf(card)>0){
           int openElement=0;
           for (int x=0;x<cards.length;x++){
               if (cards[x] == null){
                   openElement=x;
                   break;
               }
           }
           cards[openElement]=card;
           topCard=openElement;
           return true;
       }
       return false;
   }
   
   
   //you are looking to remove a specific card from the deck.
   //Put the current top card into its place.
   //Be sure the card you need is actually still in the deck, if not return false.
   public boolean removeCard(Card card) {
       int index=Arrays.asList(cards).indexOf(card);
       if (index>0){
           Card cardCopy = new Card(cards[topCard].getchar(), cards[topCard].getSuit());
           cards[index]=cardCopy;
           cards[topCard]=null;
           topCard--;
           return true;
       }
       return false;
   }
   
   //put all of the cards in the deck back into the right order according to their values.
   //Is there another method somewhere that already does this that you could refer to?
   public void sort(){
       Card.arraySort(cards, cards.length);
   }
   
   //return the number of cards remaining in the deck
   public int getNumCards(){
       int numCards=0;
       for (int x=0;x<cards.length;x++){
           if (cards[x] != null){
               numCards++;
           }
       }
       return numCards;
   }
   
   
   
   
}





