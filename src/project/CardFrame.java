package project;

import javax.swing.*;
import java.awt.*;

public class CardFrame extends JFrame
{
	private Button[][] button;
	public int level = 0; // !! 레벨(시간 정해줄 요소)
	public User user = new User(); // !! 유저객체 가져올거
	private JLabel id,point; // !! 외부에서 아이디,포인트를 수정하려면 함수로 빼는게 편하고 그려려면 전역변수여야 해서
	
	public CardFrame()
	{
		button = new Button[5][6];
		setLayout(null);
		JLabel time = new JLabel("시간"); // 시간 나타내기 
		time.setBounds(50,20,80,30);
		add(time);
		// !! 비활성화메소드 지우기

		id = new JLabel("id"); // 사용자 아아디 나타내기 
		id.setBounds(770,20,80,30);
		add(id);
		point = new JLabel("point"); //!! 포인트 추가 (아이템 살걸 생각하면 몇포인트 있는지 알려주는게 좋을거같음)
		add(point);
		point.setBounds(820,20,80,30);
		
		//!!임시로 이미지 추가
		ImageIcon imsi = new ImageIcon("img.jpg");
		ImageIcon imsi2 = new ImageIcon("imgb.png");
		
		JPanel card = new JPanel(); // 카드 배열 패널에 추가 
		card.setBounds(50,80,800,620);
		card.setLayout(new GridLayout(5,6));
		for (int i=0; i<5; i++)
		{
			for(int j = 0; j<6; j++)
			{
				button[i][j] = new Button(imsi2,imsi);
				card.add(button[i][j]);
			}
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
		
	}
	
	public void setLabelText() // 레벨창에서 아이디 및 포인트 가져오기
	{
		id.setText("ID : " + user.Getid());
		point.setText(String.valueOf("POINT : " + user.GetPoint()));
	}
	
	
	
	
	public static void main(String[] args)
	{
		CardFrame p = new CardFrame();
		p.setVisible(true); // !! 화면이 준비된후에 보이기 
	}
}