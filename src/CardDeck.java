package project;

import java.util.ArrayList;
import java.util.Collections;
public class CardDeck 
{
	private Card[] deck = new Card[52];
	private int count=0;
	public int[] index = new int[52];
	
	private void createDeck(String suit) // ī�� 1~13���� ���� 
	{
		
		for(int i=0; i<13; i++)
		{
			deck[count] = new Card(suit, i+1);
			count++;
		}
	}
	
	public CardDeck() // ī�� �� ���� 
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
	
	public Card newCard() // ���ο� ī�� �̱� 
	{
		count--;
		Card card = deck[index[count]];
		return card;
	}
}