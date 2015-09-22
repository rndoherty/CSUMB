import java.util.*;

/*
   Deck class - Set size of deck, shuffle, and deal cards
 */
public class Deck {
    private static final int PACK_SIZE = 52;
    public final int MAX_CARDS = 6 * PACK_SIZE;
    private static Card[] masterPack = new Card[PACK_SIZE];
    public static boolean masterPackAllocated = false;
        
    private Card[] cards;
    
    private int topCard;
    private int numPacks;

    // Constructor for initial numPacks
    public Deck(int numPacks) {
        this.cards = new Card[numPacks * PACK_SIZE];
        this.numPacks = numPacks;
        this.topCard = numPacks * PACK_SIZE - 1;
        allocateMasterPack();
        init(numPacks);
    }

    // Overloaded Default Constructor
    public Deck() {
        this.numPacks = 1;
        this.cards = new Card[PACK_SIZE];
        this.topCard = PACK_SIZE - 1;
        allocateMasterPack();
        init(1);
    }

    // Private helper method called by Constructor to build masterPack only once
    private static void allocateMasterPack() {
        if (!masterPackAllocated) {
            int x = 0;
            for (Card.Suit suit : Card.Suit.values()){
                for (char value : Card.Value) {
                    masterPack[x] = new Card(value, suit);
                    x++;
                }
            }
            masterPackAllocated = true;
        }
    }

    //Initialize and Re-populate cards array
    public void init(int numPacks){
        this.cards = new Card[numPacks*PACK_SIZE];
        this.numPacks=numPacks;
        this.topCard=numPacks*PACK_SIZE-1;
        int cardNum=0;
        while (cardNum<numPacks*PACK_SIZE){
            for (int x=0;x<numPacks;x++){
                for (int y=0;y<PACK_SIZE;y++){
                    cards[cardNum]=masterPack[y];
                    cardNum++;
                }
            }
        }
    }

    // Mix up cards with random number generator
    public void shuffle() {
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
    public Card dealCard() {
        int tCard = topCard;
        topCard--;
        return (Card) cards[tCard];
    }

    // Accessor for topCard
    public int getTopCard() {
        return topCard;
    }

    // Accessor for each card
    public Card inspectCard(int k) {
        Card testCard; 
        try {
            testCard = cards[k];
        } catch (Exception e){
            testCard = new Card('y', Card.Suit.spades);
        }
        return testCard;
    }
}
