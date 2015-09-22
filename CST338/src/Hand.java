/*
   Hand class - Hand size, add cards to hand, and play cards from hands
 */
class Hand {
   public static final int MAX_CARDS = 50; //Length of array

   private Card[] myCards;
   private int numCards;

   // Default constructor
   public Hand() {
      myCards = new Card[MAX_CARDS];   //Length
      numCards = 0;
   }

   // Remove all cards from the hand
   public void resetHand() {
      myCards = new Card[MAX_CARDS];
      numCards = 0;
   }

   // Adds a card to the next available position as an object copy
   public boolean takeCard(Card card) {
      if (numCards >= MAX_CARDS) {
         return false;
      } else {
         myCards[numCards] = card;
         numCards++;
         return true;
      }
   }

   // Returns and removes the card in the top occupied position
   public Card playCard() {
      Card card = myCards[numCards - 1];
      myCards[numCards -1] = null;
      numCards--;
      return card;
   }

   // Output message
   public String toString() {
      String result = "Hand = ( ";
      if (numCards == 0) {
         result = result + ")";
      } else {
         for (int i = 0; i < numCards - 1; i++) {
            result = result + myCards[i] + ",";
         }
         result = result + myCards[numCards -1] + ")";
      }
      return result;
   }

   // Accessor for number of cards
   public int getNumCards() {
      return numCards;
   }

   // Accessor for each card
   public Card inspectCard(int k) {
      Card card;
      if (k <= numCards) {
         card = new Card('y', Card.Suit.spades);
      } else {
         card = myCards[k - 1];
      }
      return card;
   }
}