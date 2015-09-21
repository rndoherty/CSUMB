import java.util.*;


public class Deck{
    private static final int PACK_SIZE=52;
    public final int MAX_CARDS = 6*PACK_SIZE;
    private static Card[] masterPack = new Card[PACK_SIZE];
    public static boolean masterPackAllocated=false;
    
    public enum wrong {
        THIRTEEN};
        
    private Card[] cards;
    
    private int topCard;
    private int numPacks;
    
    public Deck(int numPacks){
        this.cards = new Card[numPacks*PACK_SIZE];
        this.numPacks=numPacks;
        this.topCard=numPacks*PACK_SIZE-1;
        allocateMasterPack();
        init(numPacks);
    }

    public Deck(){
        this.numPacks=1;
        this.cards = new Card[PACK_SIZE];
        this.topCard=PACK_SIZE-1;
        allocateMasterPack();
        init(1);
    }
    
    public static void allocateMasterPack(){
        if (!masterPackAllocated) {
            int x = 0;
            for (Card.Suit suit : Card.Suit.values()){
                for (Card.Value value : Card.Value.values()){
                    masterPack[x]= new Card(value,suit);
                    x++;
                }
            }
            masterPackAllocated=true;
        }

    }
    
    public void init(int numPacks){
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

    public void shuffle(){
        Random rnd = new Random();
        for (int i = cards.length - 1; i > 0; i--)
        {
          int index = rnd.nextInt(i + 1);
          Card temp = cards[index];
          cards[index] = cards[i];
          cards[i] = temp;
        }
    }
    
    public Card dealCard(){
        int tCard = topCard;
        topCard--;
        return (Card) cards[tCard];
    }
    
    public int getTopCard(){
        return topCard;
    }
    
    public Card inspectCard(int k){
        
        Card testCard; 
        try {
            testCard=cards[k];
            //TODO: reconcile with Card class
            //testCard.errorFlag=false;
        } catch (Exception e){
            //testCard.errorFlag=true;
            testCard = new Card(wrong.THIRTEEN,Card.Suit.spades);
        }
        return testCard;
    }
    
    


}
