package project;

import java.awt.event.*;
import javax.swing.JOptionPane;

import project.Button;
import project.CardFrame;
import project.LevelFrame;

public class CardActionListner implements ActionListener
{
	// 외부에서 가져올것 
	private CardFrame view;
	private User user;
	private UserList UL;
	private int price;
	
	//내부에서만 ㅆ는것
	private Button[] btn = new Button[2];  // 버튼 저장해둘 리스트
	private int num = 0; // 선택수-1
	private int score = 0; //맞춘 카드 쌍 개수 
	private boolean sameCard = false;
	
	CardActionListner(CardFrame v)
	{
		view = v;
	}
	
	public void BringData(CardFrame v, User u, UserList ul,int p) //필요한 정보 가져오기
	{
		view = v;
		user = u;
		UL = ul;
		price = p;
	}
	
	public boolean scorecheck()  //전부 맞췄는지 검사
	{
		if(score == 15)
			return true;
		else
			return false;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		btn[num] = (Button)e.getSource(); // 버튼의 num번째에 누른 버튼 넣기
		
		if (!btn[num].getBackcheck()) // 누른 버튼이 앞면일때
		{
			btn = new Button[2];
		}
		else
		{
			btn[num].turnImage();
			
			if (num == 1)
			{
				sameCard = btn[num].cardcheck(btn[0]);
				num = 0;
				btn = new Button[2];
			}
			
			if (sameCard)
				score++;
			else
			{
				btn[0].turnImage();
				btn[1].turnImage();
			}
			
			if (scorecheck())
			{
				JOptionPane.showMessageDialog(null,"축하합니다! 승리하셨습니다!\n"
						+ "point +" + String.valueOf(price));
				user.ChangePoint(price);
				view.setVisible(false);
				LevelFrame Flevel= new LevelFrame();
				Flevel.BringData(user,UL);
				Flevel.setVisible(true);
				view.dispose();
			}
			
			num++; // num 증가
		}
	}
	
}
