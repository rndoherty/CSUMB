import java.util.*;

public class Card
{
   public enum Suit { clubs, diamonds, hearts, spades }
   public enum Value { A, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE,
      J, Q, K }

   private Value value;
   private Suit suit;
   private boolean errorFlag;

   public Card()
   {
      value = Value.A;
      suit = Suit.spades;
      errorFlag = false;
   }

   public Card(Value value, Suit suit)
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

   public boolean set(Value value, Suit suit)
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

   public Value getValue()
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

   private boolean isValid(Value value, Suit suit)
   {
      Value[] v = Value.values();
      Suit[] s = Suit.values();
      for (int i = 0 ; i < v.length; i++)
      {
         if (value == v[i])
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
