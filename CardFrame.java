import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardFrame extends JFrame
{
	private int level = 0,price = level*2; //(ex / 쉬움 = 1, price =2)
	private User user = new User();
	private JLabel id,point; // 외부에서 지정
	private UserList UL = new UserList();
	private CardActionListner CA = new CardActionListner(this); //카드만 포함
	private JButton item,item_2,quit;
	private JLabel time = new JLabel();
	private timer timer = new timer(40, this); //40은 나중에 고칠 수 있음 레벨에 따라 다르게 나타나기 등으로 
	
	public CardFrame()
	{
		Button[] button = new Button[30];
		setLayout(null);
 
		time.setText("시간 : "+timer.gettime());  //시간 문구 바꾸
		time.setBounds(50,20,80,30); 
		add(time);

		id = new JLabel("id"); // 사용자 아아디 나타내기 
		id.setBounds(740,20,80,30);
		add(id);
		point = new JLabel("point");
		add(point);
		point.setBounds(820,20,80,30);
		
		JPanel cardf = new JPanel();
		cardf.setBounds(50,80,800,620);
		cardf.setLayout(new GridLayout(5,6,30,0));
		
		Reset Game = new Reset();
		for (int i=0; i<30; i++)  //버튼 넣기  
		{
			button[i] = new Button(Game.cardname(i), Game.GetImage(30), Game.GetImage(i));
			cardf.add(button[i]);
			button[i].addActionListener(CA);
		}
		add(cardf);
		
		CardFrameListner CFL = new CardFrameListner();
		
		item = new JButton("item"); // 아이템1
		item.setBounds(880,80,90,90);
		add(item);
		item.addActionListener(CFL);
		
		quit = new JButton("item");  // 나가기 
		quit.setBounds(880,650,90,50);
		add(quit);
		quit.addActionListener(CFL);
		
		setSize(1000, 750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("test");
	}
	
	public void update()
	{
		time.setText("시간 : "+timer.gettime());
	}
	
	
	public void BringData(User arguser,UserList argUL,int arglevel) //로그인창에서 필요한 정보 가져오기
	{
		level = arglevel;
		user = arguser;
		UL = argUL;
		id.setText("ID : " + user.Getid());
		point.setText(String.valueOf("POINT : " + user.GetPoint()));
		CA.BringData(user,UL,price);
	}
	
	public class CardFrameListner implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == item)
			{
				timer.timeadd(5);
			}
			else if (e.getSource() == item_2)
			{
				
			}
			else if (e.getSource() == quit)
			{
				JOptionPane.showMessageDialog(null,"게임을 종료하고 메인으로 돌아갑니다.");
				setVisible(false);
				LevelFrame Flevel= new LevelFrame();
				Flevel.BringData(user,UL);
				Flevel.setVisible(true);
				dispose();
			}
		}
	}
}