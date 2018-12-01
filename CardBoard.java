import java.util.ArrayList;
import java.util.Collections;
public class CardBoard 
{
    public Card[][] cardboard = new Card[5][6];
    
    public CardBoard()
    {
        ArrayList<Integer> index = new ArrayList<Integer>();
    	for(int j=0; j<30; j++)
    	{
    		index.add(j);
    	}
    	Collections.shuffle(index);
        CardDeck cd = new CardDeck();
        for(int i=0; i<15; i++)
        {
        	int row1 = (int)(index.get(i) / 6);
        	int col1 = index.get(i) % 6;
        	int row2 = (int)(index.get(i+15) / 6);
        	int col2 = index.get(i+15) % 6;
        	Card card = cd.newCard();
        	cardboard[row1][col1] = card;
        	cardboard[row2][col2] = card;
        }
    }
	
}
