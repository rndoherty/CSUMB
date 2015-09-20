import java.util.*;

public class Card
{
   public enum Suit { clubs, diamonds, hearts, spades }

   // Adding this array so we can know what values are valid
   public static char[] Value = {'A', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'J', 'Q', 'K'};

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
      if ( !set(value, suit) )
         throw new IllegalArgumentException();
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
         errorFlag = false;
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
      if (card.value == value && card.suit == suit)
         return true;
      return false;
   }

   private boolean isValid(char value, Suit suit)
   {
      Suit[] s = Suit.values();

      for ( int i = 0 ; i < Value.length; i++ )
      {
         if (Value[i] == this.value)
            return true;
      }

      for (int i = 0 ; i < s.length; i++)
      {
         if (suit == s[i])
            return true;
      }
      return false;
   }
}
