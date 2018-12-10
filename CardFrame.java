import javax.swing.*;
import java.awt.*;

public class CardFrame extends JFrame
{
	Reset Game;
	int i;
	
	public CardFrame()
	{
		Game=new Reset();
		Button[] button = new Button[30];
		setLayout(null);
		
		JLabel time = new JLabel("시간"); // 시간 나타내기 
		time.setBounds(50,20,80,30);
		add(time);

		JLabel id = new JLabel("id"); // 사용자 아아디 나타내기 
		id.setBounds(820,20,80,30);
		add(id);
		
		JPanel cardb = new JPanel(); // 카드 배열 패널에 추가 
		cardb.setBounds(50,80,800,620);
		cardb.setLayout(new GridLayout(5,6));
		
		JPanel cardf = new JPanel();
		cardf.setBounds(50,80,800,620);
		cardf.setLayout(new GridLayout(5,6));
		for (int i=0; i<30; i++)
		{
			button[i] = new Button(Game.GetImage(i), Game.GetImage(30));
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



