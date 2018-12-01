import java.util.ArrayList;
import java.util.Collections;
public class CardDeck 
{
	private Card[] deck = new Card[4*Card.suit_size];
	
	private void createDeck(String suit) 
	{
		for(int i=0; i<Card.suit_size; i++)
		{
			deck[i] = new Card(suit, i+1);
		}
	}
	
	public CardDeck() // carddeck 만들기
	{
		createDeck("spade");
		createDeck("heart");
		createDeck("diamond");
		createDeck("club");
	}
	
	public Card newCard() // card 랜덤으로 뽑기
	{
		ArrayList<Integer> index = new ArrayList<Integer>();
		for(int i=0; i<104; i++)
		{
			index.add(i);
		}
		Collections.shuffle(index);
		Card card = null;
		card = deck[index.get(0)];
		index.remove(0);
		for(int i=1; i<104; i++)
		{
			deck[i-1] = deck [i];
		}
		return card;
	}
}
