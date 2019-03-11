package project;

import java.util.ArrayList;
import java.util.Collections;
public class CardDeck 
{
	private Card[] deck = new Card[52];
	private int count=0;
	public int[] index = new int[52];
	
	private void createDeck(String suit) // 카드 1~13까지 생성 
	{
		
		for(int i=0; i<13; i++)
		{
			deck[count] = new Card(suit, i+1);
			count++;
		}
	}
	
	public CardDeck() // 카드 덱 생성 
	{
		createDeck("spade");
		createDeck("heart");
		createDeck("diamond");
		createDeck("club");
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i=0; i<52; i++)
		{
			temp.add(i);
		}
		Collections.shuffle(temp);
		for(int j=0; j<52; j++)
		{
			index[j] = temp.get(j);
		}
	}
	
	public Card newCard() // 새로운 카드 뽑기 
	{
		count--;
		Card card = deck[index[count]];
		return card;
	}
}