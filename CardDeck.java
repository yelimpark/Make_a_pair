import java.util.ArrayList;
import java.util.Collections;
public class CardDeck 
{
	private Card[] deck = new Card[4*Card.suit_size];
	
	private void createDeck(String suit) // 카드 1~13까지 생성 
	{
		for(int i=0; i<Card.suit_size; i++)
		{
			deck[i] = new Card(suit, i+1);
		}
	}
	
	public CardDeck() // 카드 덱 생성 
	{
		createDeck("spade");
		createDeck("heart");
		createDeck("diamond");
		createDeck("club");
	}
	
	public Card newCard() // 새로운 카드 뽑기 
	{
		ArrayList<Integer> index = new ArrayList<Integer>();
		for(int i=0; i<52; i++)
		{
			index.add(i);
		}
		Collections.shuffle(index);
		Card card = null;
		card = deck[index.get(0)];
		index.remove(0);
		for(int i=1; i<52; i++)
		{
			deck[i-1] = deck [i];
		}
		return card;
	}
}
