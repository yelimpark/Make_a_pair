import javax.swing.*;
import java.awt.*;

public class CardFrame extends JFrame
{
	Reset Game;
	int i;
	int level = 0,price = level*2; //(ex / 쉬움 = 1, price =2)
	public User user = new User();
	private JLabel id,point; // 외부에서 지정
	
	public CardFrame()
	{
		Game=new Reset();
		Button[] button = new Button[30];
		setLayout(null);
		
		JLabel time = new JLabel("시간"); // 시간 나타내기 
		time.setBounds(50,20,80,30);
		add(time);

		id = new JLabel("id"); // 사용자 아아디 나타내기 
		id.setBounds(770,20,80,30);
		add(id);
		point = new JLabel("point"); //!! 포인트 추가 (아이템 살걸 생각하면 몇포인트 있는지 알려주는게 좋을거같음)
		add(point);
		point.setBounds(820,20,80,30);
		
		JPanel cardb = new JPanel(); // 카드 배열 패널에 추가 
		cardb.setBounds(50,80,800,620);
		cardb.setLayout(new GridLayout(5,6));
		
		JPanel cardf = new JPanel();
		cardf.setBounds(50,80,800,620);
		cardf.setLayout(new GridLayout(5,6));
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
	
	public void setLabelText() // 입력된 유저정보로 라벨 바꿔주기 (창객체를 생성하고 거기에 유저를 넣어주는 거라 필요)
	{
		id.setText("ID : " + user.Getid());
		point.setText(String.valueOf("POINT : " + user.GetPoint()));
	}
	
	public static void main(String[] args)
	{
		CardFrame p = new CardFrame();
	}
}



