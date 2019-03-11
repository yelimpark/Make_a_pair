package project;

public class Card {

	public static final int suit_size = 13;
	public static final int A = 1;
	public static final int J = 11;
	public static final int Q = 12;
	public static final int K = 13;
	public String suit;
	public int value;
	
	public Card(String s, int v)
	{
		suit = s;
		value = v;
	}
	
	public String getSuit()
	{
		return suit;
	}
	
	public int getValue()
	{
		return value;
	}
	
	
}