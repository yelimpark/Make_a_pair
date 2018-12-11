import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;
public class Reset
{
	ImageIcon[] image;
	String suit;
	int value;
	Card[] deck;
	int imagenum;
	
	public Reset() 
	{
		image = new ImageIcon[31];
		deck = new Card[15];
		getimage();
	}
	
	public ImageIcon GetImage(int i) 
	{
		return image[i];
	}
	
	public String cardname(int i)
	{
		Card card = deck[i];
		String Suit = card.getSuit();
		int Value = card.getValue();
		String name = Suit + Integer.toString(Value);
		return name;
	}

	public void getimage()
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
			Card card = new Card(" ",0);
            card = cd.newCard();
			suit = card.getSuit();
			value = card.getValue();
			deck[i] = card;
			if(suit == "club")
			{
				switch (value)
				{
				case 1:
					image[index.get(i)] = new ImageIcon("cards/cA.png");
					image[index.get(i+15)] = new ImageIcon("cards/cA.png");
				break;
				case 2:
					image[index.get(i)] = new ImageIcon("cards/c2.png");
					image[index.get(i+15)] = new ImageIcon("cards/c2.png");
				break;
				case 3:
					image[index.get(i)] = new ImageIcon("cards/c3.png");
					image[index.get(i+15)] = new ImageIcon("cards/c3.png");
				break;
				case 4:
					image[index.get(i)] = new ImageIcon("cards/c4.png");
					image[index.get(i+15)] = new ImageIcon("cards/c4.png");
				break;
				case 5:
					image[index.get(i)] = new ImageIcon("cards/c5.png");
					image[index.get(i+15)] = new ImageIcon("cards/c5.png");
				break;
				case 6:
					image[index.get(i)] = new ImageIcon("cards/c6.png");
					image[index.get(i+15)] = new ImageIcon("cards/c6.png");
				break;
				case 7:
					image[index.get(i)] = new ImageIcon("cards/c7.png");
					image[index.get(i+15)] = new ImageIcon("cards/c7.png");
				break;
				case 8:
					image[index.get(i)] = new ImageIcon("cards/c8.png");
					image[index.get(i+15)] = new ImageIcon("cards/c8.png");
				break;
				case 9:
					image[index.get(i)] = new ImageIcon("cards/c9.png");
					image[index.get(i+15)] = new ImageIcon("cards/c9.png");
				break;
				case 10:
					image[index.get(i)] = new ImageIcon("cards/c10.png");
					image[index.get(i+15)] = new ImageIcon("cards/c10.png");
				break;
				case 11:
					image[index.get(i)] = new ImageIcon("cards/cJ.png");
					image[index.get(i+15)] = new ImageIcon("cards/cJ.png");
				break;
				case 12:
					image[index.get(i)] = new ImageIcon("cards/cQ.png");
					image[index.get(i+15)] = new ImageIcon("cards/cQ.png");
				break;
				case 13:
					image[index.get(i)] = new ImageIcon("cards/cK.png");
					image[index.get(i+15)] = new ImageIcon("cards/cK.png");
				break;
				}
			}
			else if(suit == "diamond")
			{
				switch (value)
				{
				case 1:
					image[index.get(i)] = new ImageIcon("cards/dA.png");
					image[index.get(i+15)] = new ImageIcon("cards/dA.png");
				break;
				case 2:
					image[index.get(i)] = new ImageIcon("cards/d2.png");
					image[index.get(i+15)] = new ImageIcon("cards/d2.png");
				break;
				case 3:
					image[index.get(i)] = new ImageIcon("cards/d3.png");
					image[index.get(i+15)] = new ImageIcon("cards/d3.png");
				break;
				case 4:
					image[index.get(i)] = new ImageIcon("cards/d4.png");
					image[index.get(i+15)] = new ImageIcon("cards/d4.png");
				break;
				case 5:
					image[index.get(i)] = new ImageIcon("cards/d5.png");
					image[index.get(i+15)] = new ImageIcon("cards/d5.png");
				break;
				case 6:
					image[index.get(i)] = new ImageIcon("cards/d6.png");
					image[index.get(i+15)] = new ImageIcon("cards/d6.png");
				break;
				case 7:
					image[index.get(i)] = new ImageIcon("cards/d7.png");
					image[index.get(i+15)] = new ImageIcon("cards/d7.png");
				break;
				case 8:
					image[index.get(i)] = new ImageIcon("cards/d8.png");
					image[index.get(i+15)] = new ImageIcon("cards/d8.png");
				break;
				case 9:
					image[index.get(i)] = new ImageIcon("cards/d9.png");
					image[index.get(i+15)] = new ImageIcon("cards/d9.png");
				break;
				case 10:
					image[index.get(i)] = new ImageIcon("cards/d10.png");
					image[index.get(i+15)] = new ImageIcon("cards/d10.png");
				break;
				case 11:
					image[index.get(i)] = new ImageIcon("cards/dJ.png");
					image[index.get(i+15)] = new ImageIcon("cards/dJ.png");
				break;
				case 12:
					image[index.get(i)] = new ImageIcon("cards/dQ.png");
					image[index.get(i+15)] = new ImageIcon("cards/dQ.png");
				break;
				case 13:
					image[index.get(i)] = new ImageIcon("cards/dK.png");
					image[index.get(i+15)] = new ImageIcon("cards/dK.png");
				break;
				}
			}
			else if(suit == "heart")
			{
				switch (value)
				{
				case 1:
					image[index.get(i)] = new ImageIcon("cards/hA.png");
					image[index.get(i+15)] = new ImageIcon("cards/hA.png");
				break;
				case 2:
					image[index.get(i)] = new ImageIcon("cards/h2.png");
					image[index.get(i+15)] = new ImageIcon("cards/h2.png");
				break;
				case 3:
					image[index.get(i)] = new ImageIcon("cards/h3.png");
					image[index.get(i+15)] = new ImageIcon("cards/h3.png");
				break;
				case 4:
					image[index.get(i)] = new ImageIcon("cards/h4.png");
					image[index.get(i+15)] = new ImageIcon("cards/h4.png");
				break;
				case 5:
					image[index.get(i)] = new ImageIcon("cards/h5.png");
					image[index.get(i+15)] = new ImageIcon("cards/h5.png");
				break;
				case 6:
					image[index.get(i)] = new ImageIcon("cards/h6.png");
					image[index.get(i+15)] = new ImageIcon("cards/h6.png");
				break;
				case 7:
					image[index.get(i)] = new ImageIcon("cards/h7.png");
					image[index.get(i+15)] = new ImageIcon("cards/h7.png");
				break;
				case 8:
					image[index.get(i)] = new ImageIcon("cards/h8.png");
					image[index.get(i+15)] = new ImageIcon("cards/h8.png");
				break;
				case 9:
					image[index.get(i)] = new ImageIcon("cards/h9.png");
					image[index.get(i+15)] = new ImageIcon("cards/h9.png");
				break;
				case 10:
					image[index.get(i)] = new ImageIcon("cards/h10.png");
					image[index.get(i+15)] = new ImageIcon("cards/h10.png");
				break;
				case 11:
					image[index.get(i)] = new ImageIcon("cards/hJ.png");
					image[index.get(i+15)] = new ImageIcon("cards/hJ.png");
				break;
				case 12:
					image[index.get(i)] = new ImageIcon("cards/hQ.png");
					image[index.get(i+15)] = new ImageIcon("cards/hQ.png");
				break;
				case 13:
					image[index.get(i)] = new ImageIcon("cards/hK.png");
					image[index.get(i+15)] = new ImageIcon("cards/hK.png");
				break;
				}
			}
			else
			{
				switch (value)
				{
				case 1:
					image[index.get(i)] = new ImageIcon("cards/sA.png");
					image[index.get(i+15)] = new ImageIcon("cards/sA.png");
				break;
				case 2:
					image[index.get(i)] = new ImageIcon("cards/s2.png");
					image[index.get(i+15)] = new ImageIcon("cards/s2.png");
				break;
				case 3:
					image[index.get(i)] = new ImageIcon("cards/s3.png");
					image[index.get(i+15)] = new ImageIcon("cards/s3.png");
				break;
				case 4:
					image[index.get(i)] = new ImageIcon("cards/s4.png");
					image[index.get(i+15)] = new ImageIcon("cards/s4.png");
				break;
				case 5:
					image[index.get(i)] = new ImageIcon("cards/s5.png");
					image[index.get(i+15)] = new ImageIcon("cards/s5.png");
				break;
				case 6:
					image[index.get(i)] = new ImageIcon("cards/s6.png");
					image[index.get(i+15)] = new ImageIcon("cards/s6.png");
				break;
				case 7:
					image[index.get(i)] = new ImageIcon("cards/s7.png");
					image[index.get(i+15)] = new ImageIcon("cards/s7.png");
				break;
				case 8:
					image[index.get(i)] = new ImageIcon("cards/s8.png");
					image[index.get(i+15)] = new ImageIcon("cards/s8.png");
				break;
				case 9:
					image[index.get(i)] = new ImageIcon("cards/s9.png");
					image[index.get(i+15)] = new ImageIcon("cards/s9.png");
				break;
				case 10:
					image[index.get(i)] = new ImageIcon("cards/s10.png");
					image[index.get(i+15)] = new ImageIcon("cards/s10.png");
				break;
				case 11:
					image[index.get(i)] = new ImageIcon("cards/sJ.png");
					image[index.get(i+15)] = new ImageIcon("cards/sJ.png");
				break;
				case 12:
					image[index.get(i)] = new ImageIcon("cards/sQ.png");
					image[index.get(i+15)] = new ImageIcon("cards/sQ.png");
				break;
				case 13:
					image[index.get(i)] = new ImageIcon("cards/sK.png");
					image[index.get(i+15)] = new ImageIcon("cards/sK.png");
				break;
				}
			}
		}
		image[30] = new ImageIcon("cards/back.png");
	}	
}
