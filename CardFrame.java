import javax.swing.*;
import java.awt.*;

public class CardFrame extends JFrame
{
	Reset Game;
	
	public CardFrame()
	{
		Game=new Reset();
		Button[] button = new Button[30];
		setLayout(null);
		JLabel time = new JLabel("시간"); // 시간 나타내기 
		time.setBounds(50,20,80,30);
		add(time);
		time.setEnabled(false);

		JLabel id = new JLabel("id"); // 사용자 아아디 나타내기 
		id.setBounds(820,20,80,30);
		add(id);
		id.setEnabled(false);
		
		JPanel card = new JPanel(); // 카드 배열 패널에 추가 
		card.setBounds(50,80,800,620);
		card.setLayout(new GridLayout(5,6));
		for (int i=0; i<30; i++)
		{
			button[i] = new Button(Game.GetImage(i), Game.GetImage(30));
			card.add(button[i]);
		}
		add(card);
		JButton item_1 = new JButton("item"); // 아이템1
		item_1.setBounds(880,80,90,90);
		add(item_1);
		
		JButton item_2 = new JButton("item"); // 아이템1
		item_2.setBounds(880,200,90,90);
		add(item_2);
		
		JButton quit = new JButton("quit");  // 나가기 
		quit.setBounds(880,650,90,50);
		add(quit);
		
		setSize(1000, 750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("test");
		setVisible(true);
		
	}
	public static void main(String[] args)
	{
		CardFrame p = new CardFrame();
	}
}



