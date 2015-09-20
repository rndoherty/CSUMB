import java.util.*;


public class Deck{
    public final int MAX_CARDS = 6*52;
    private static final int PACK_SIZE=52;
    private static Card[] masterPack = new Card[PACK_SIZE];
    public static boolean masterPackAllocated=false;
    
    private Card[] cards;
    
    private int topCard;
    private int numPacks;
    
    public Deck(int numPacks){
        this.cards = new Card[numPacks*PACK_SIZE];
        this.numPacks=numPacks;
        this.topCard=numPacks*PACK_SIZE;
        allocateMasterPack();
        init(numPacks);
    }

    public Deck(){
        this.numPacks=1;
        this.cards = new Card[PACK_SIZE];
        this.topCard=PACK_SIZE;
        allocateMasterPack();
        init(1);
    }
    
    public static void allocateMasterPack(){
        if (!masterPackAllocated) {
                
            for (int x=0;x<PACK_SIZE;x++){
              //TODO: split this for suites & values
                masterPack[x]= new Card();
            }
            masterPackAllocated=true;
        }
    }
    
    public void init(int numPacks){
        int cardNum=0;
        while (cardNum<numPacks*PACK_SIZE){
            for (int x=0;x<numPacks;x++){
                //TODO: split this for suites & values
                for (int y=0;y<PACK_SIZE;y++){
                    cards[cardNum]=new Card();
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
        Card testCard = new Card();
        try {
            testCard=cards[k];
            //TODO: reconcile with Card class
            //testCard.errorFlag=false;
        } catch (Exception e){
            //testCard.errorFlag=true;
        }
        return testCard;
    }
    
    


}
