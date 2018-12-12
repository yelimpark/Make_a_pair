package game;
import javax.swing.*;
import java.awt.*;

public class CardFrame extends JFrame
{
	Reset Game;
	timer time;
	
	public CardFrame()
	{
		Game = new Reset();
		time = new timer(40);
		Button[] button = new Button[30];
		setLayout(null);
		
		JLabel timer = new JLabel("시간 : "+time.gettime()); // 시간 나타내기 
		timer.setBounds(50,20,80,30);
		add(timer);

		JLabel id = new JLabel("id"); // 사용자 아아디 나타내기 
		id.setBounds(820,20,80,30);
		add(id);
		
		JPanel cardb = new JPanel(); // 카드 배열 패널에 추가 
		cardb.setBounds(50,80,800,620);
		cardb.setLayout(new GridLayout(5,6,30,0));
		for (int i=0; i<30; i++)
		{
			button[i] = new Button(Game.cardname(i), Game.GetImage(i), Game.GetImage(30));
			cardb.add(button[i]);
			
		}
		add(cardb);
		
		JButton item_1 = new JButton(); // 아이템1
		item_1.setBounds(880,80,90,90);
		add(item_1);
		
		JButton item_2 = new JButton("item"); // 아이템1
		item_2.setBounds(880,200,90,90);
		add(item_2);
		
		JButton quit = new JButton("item");  // 나가기 
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



