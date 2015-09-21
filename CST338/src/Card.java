public class Card
{
   public enum Suit { clubs, diamonds, hearts, spades }

   // Adding this array so we can know what values are valid
   public static char[] Value = {'A', '2', '3', '4', '5', '6', '7', '8',
      '9', 'T', 'J', 'Q', 'K'};

   private char value;
   private Suit suit;
   private boolean errorFlag;

   public Card()
   {
      value = 'A';
      suit = Suit.spades;
      errorFlag = false;
   }

   public Card(char value, Suit suit)
   {
      errorFlag = !set(value, suit);
   }

   public String toString()
   {
      if (errorFlag)
         return("[ invalid ]");

      return(value + " of " + suit);
   }

   public boolean set(char value, Suit suit)
   {
      if ( isValid( value, suit) )
      {
         this.value = value;
         this.suit = suit;
         return true;
      }
      return false;
   }

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

   public boolean equals(Card card)
   {
      return card.value == value && card.suit == suit;
   }

   private boolean isValid(char value, Suit suit)
   {
      boolean valid = false;

      for ( char v : Value )
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
