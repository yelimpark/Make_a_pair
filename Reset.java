import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;
public class Reset
{
	ImageIcon[] image;
	String suit;
	int value;
	int [] arr;
	
	public Reset() 
	{
		image = new ImageIcon[31];
	}
	
	public ImageIcon GetImage(int i) 
	{
		return image[i];
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
			Card card = cd.newCard();
			suit = card.getSuit();
			value = card.getValue();
			if(suit == "club")
			{
				switch (value)
				{
				case 1:
					image[index.get(i)] = new ImageIcon("./cards/cA");
					image[index.get(i+15)] = new ImageIcon("./cards/cA");
				break;
				case 2:
					image[index.get(i)] = new ImageIcon("./cards/c2");
					image[index.get(i+15)] = new ImageIcon("./cards/c2");
				break;
				case 3:
					image[index.get(i)] = new ImageIcon("./cards/c3");
					image[index.get(i+15)] = new ImageIcon("./cards/c3");
				break;
				case 4:
					image[index.get(i)] = new ImageIcon("./cards/c4");
					image[index.get(i+15)] = new ImageIcon("./cards/c4");
				break;
				case 5:
					image[index.get(i)] = new ImageIcon("./cards/c5");
					image[index.get(i+15)] = new ImageIcon("./cards/c5");
				break;
				case 6:
					image[index.get(i)] = new ImageIcon("./cards/c6");
					image[index.get(i+15)] = new ImageIcon("./cards/c6");
				break;
				case 7:
					image[index.get(i)] = new ImageIcon("./cards/c7");
					image[index.get(i+15)] = new ImageIcon("./cards/c7");
				break;
				case 8:
					image[index.get(i)] = new ImageIcon("./cards/c8");
					image[index.get(i+15)] = new ImageIcon("./cards/c8");
				break;
				case 9:
					image[index.get(i)] = new ImageIcon("./cards/c9");
					image[index.get(i+15)] = new ImageIcon("./cards/c9");
				break;
				case 10:
					image[index.get(i)] = new ImageIcon("./cards/c10");
					image[index.get(i+15)] = new ImageIcon("./cards/c10");
				break;
				case 11:
					image[index.get(i)] = new ImageIcon("./cards/cJ");
					image[index.get(i+15)] = new ImageIcon("./cards/cJ");
				break;
				case 12:
					image[index.get(i)] = new ImageIcon("./cards/cQ");
					image[index.get(i+15)] = new ImageIcon("./cards/cQ");
				break;
				case 13:
					image[index.get(i)] = new ImageIcon("./cards/cK");
					image[index.get(i+15)] = new ImageIcon("./cards/cK");
				break;
				}
			}
			else if(suit == "diamond")
			{
				switch (value)
				{
				case 1:
					image[index.get(i)] = new ImageIcon("./cards/dA");
					image[index.get(i+15)] = new ImageIcon("./cards/dA");
				break;
				case 2:
					image[index.get(i)] = new ImageIcon("./cards/d2");
					image[index.get(i+15)] = new ImageIcon("./cards/d2");
				break;
				case 3:
					image[index.get(i)] = new ImageIcon("./cards/d3");
					image[index.get(i+15)] = new ImageIcon("./cards/d3");
				break;
				case 4:
					image[index.get(i)] = new ImageIcon("./cards/d4");
					image[index.get(i+15)] = new ImageIcon("./cards/d4");
				break;
				case 5:
					image[index.get(i)] = new ImageIcon("./cards/d5");
					image[index.get(i+15)] = new ImageIcon("./cards/d5");
				break;
				case 6:
					image[index.get(i)] = new ImageIcon("./cards/d6");
					image[index.get(i+15)] = new ImageIcon("./cards/d6");
				break;
				case 7:
					image[index.get(i)] = new ImageIcon("./cards/d7");
					image[index.get(i+15)] = new ImageIcon("./cards/d7");
				break;
				case 8:
					image[index.get(i)] = new ImageIcon("./cards/d8");
					image[index.get(i+15)] = new ImageIcon("./cards/d8");
				break;
				case 9:
					image[index.get(i)] = new ImageIcon("./cards/d9");
					image[index.get(i+15)] = new ImageIcon("./cards/d9");
				break;
				case 10:
					image[index.get(i)] = new ImageIcon("./cards/d10");
					image[index.get(i+15)] = new ImageIcon("./cards/d10");
				break;
				case 11:
					image[index.get(i)] = new ImageIcon("./cards/dJ");
					image[index.get(i+15)] = new ImageIcon("./cards/dJ");
				break;
				case 12:
					image[index.get(i)] = new ImageIcon("./cards/dQ");
					image[index.get(i+15)] = new ImageIcon("./cards/dQ");
				break;
				case 13:
					image[index.get(i)] = new ImageIcon("./cards/dK");
					image[index.get(i+15)] = new ImageIcon("./cards/dK");
				break;
				}
			}
			else if(suit == "heart")
			{
				switch (value)
				{
				case 1:
					image[index.get(i)] = new ImageIcon("./cards/hA");
					image[index.get(i+15)] = new ImageIcon("./cards/hA");
				break;
				case 2:
					image[index.get(i)] = new ImageIcon("./cards/h2");
					image[index.get(i+15)] = new ImageIcon("./cards/h2");
				break;
				case 3:
					image[index.get(i)] = new ImageIcon("./cards/h3");
					image[index.get(i+15)] = new ImageIcon("./cards/h3");
				break;
				case 4:
					image[index.get(i)] = new ImageIcon("./cards/h4");
					image[index.get(i+15)] = new ImageIcon("./cards/h4");
				break;
				case 5:
					image[index.get(i)] = new ImageIcon("./cards/h5");
					image[index.get(i+15)] = new ImageIcon("./cards/h5");
				break;
				case 6:
					image[index.get(i)] = new ImageIcon("./cards/h6");
					image[index.get(i+15)] = new ImageIcon("./cards/h6");
				break;
				case 7:
					image[index.get(i)] = new ImageIcon("./cards/h7");
					image[index.get(i+15)] = new ImageIcon("./cards/h7");
				break;
				case 8:
					image[index.get(i)] = new ImageIcon("./cards/h8");
					image[index.get(i+15)] = new ImageIcon("./cards/h8");
				break;
				case 9:
					image[index.get(i)] = new ImageIcon("./cards/h9");
					image[index.get(i+15)] = new ImageIcon("./cards/h9");
				break;
				case 10:
					image[index.get(i)] = new ImageIcon("./cards/h10");
					image[index.get(i+15)] = new ImageIcon("./cards/h10");
				break;
				case 11:
					image[index.get(i)] = new ImageIcon("./cards/hJ");
					image[index.get(i+15)] = new ImageIcon("./cards/hJ");
				break;
				case 12:
					image[index.get(i)] = new ImageIcon("./cards/hQ");
					image[index.get(i+15)] = new ImageIcon("./cards/hQ");
				break;
				case 13:
					image[index.get(i)] = new ImageIcon("./cards/hK");
					image[index.get(i+15)] = new ImageIcon("./cards/hK");
				break;
				}
			}
			else
			{
				switch (value)
				{
				case 1:
					image[index.get(i)] = new ImageIcon("./cards/sA");
					image[index.get(i+15)] = new ImageIcon("./cards/sA");
				break;
				case 2:
					image[index.get(i)] = new ImageIcon("./cards/s2");
					image[index.get(i+15)] = new ImageIcon("./cards/s2");
				break;
				case 3:
					image[index.get(i)] = new ImageIcon("./cards/s3");
					image[index.get(i+15)] = new ImageIcon("./cards/s3");
				break;
				case 4:
					image[index.get(i)] = new ImageIcon("./cards/s4");
					image[index.get(i+15)] = new ImageIcon("./cards/s4");
				break;
				case 5:
					image[index.get(i)] = new ImageIcon("./cards/s5");
					image[index.get(i+15)] = new ImageIcon("./cards/s5");
				break;
				case 6:
					image[index.get(i)] = new ImageIcon("./cards/s6");
					image[index.get(i+15)] = new ImageIcon("./cards/s6");
				break;
				case 7:
					image[index.get(i)] = new ImageIcon("./cards/s7");
					image[index.get(i+15)] = new ImageIcon("./cards/s7");
				break;
				case 8:
					image[index.get(i)] = new ImageIcon("./cards/s8");
					image[index.get(i+15)] = new ImageIcon("./cards/s8");
				break;
				case 9:
					image[index.get(i)] = new ImageIcon("./cards/s9");
					image[index.get(i+15)] = new ImageIcon("./cards/s9");
				break;
				case 10:
					image[index.get(i)] = new ImageIcon("./cards/s10");
					image[index.get(i+15)] = new ImageIcon("./cards/s10");
				break;
				case 11:
					image[index.get(i)] = new ImageIcon("./cards/sJ");
					image[index.get(i+15)] = new ImageIcon("./cards/sJ");
				break;
				case 12:
					image[index.get(i)] = new ImageIcon("./cards/sQ");
					image[index.get(i+15)] = new ImageIcon("./cards/sQ");
				break;
				case 13:
					image[index.get(i)] = new ImageIcon("./cards/sK");
					image[index.get(i+15)] = new ImageIcon("./cards/sK");
				break;
				}
			}
		}
		image[30] = new ImageIcon("./cards/back");
	}	
}
