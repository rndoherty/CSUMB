import java.util.*;


public class Deck {
    //private static Card[] cards;
    private static List<Card> cards = new ArrayList<Card>();
    
    public Deck(){
        
    }
    
    /*
    public boolean setDeckSize(int size){
        try {
            this.cards = new Card[size];
        } catch (Exception e){
            System.err.println("There was a problem setting the Deck Size: " + e.getMessage());
            return false;
        }
        return true;
    }*/
    

    public boolean addCard(Card newCard){
        try {
            this.cards.add(newCard);
        } catch (Exception e){
            System.err.println("There was a problem adding a card: " + e.getMessage());
            return false;
        }
        return true;
    }
    

}
