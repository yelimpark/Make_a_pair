package project;

import java.awt.event.*;
import javax.swing.JOptionPane;

import project.Button;
import project.CardFrame;
import project.LevelFrame;

public class CardActionListner implements ActionListener
{
	// �ܺο��� �����ð� 
	private CardFrame view;
	private User user;
	private UserList UL;
	private int price;
	
	//���ο����� ���°�
	private Button[] btn = new Button[2];  // ��ư �����ص� ����Ʈ
	private int num = 0; // ���ü�-1
	private int score = 0; //���� ī�� �� ���� 
	private boolean sameCard = false;
	
	CardActionListner(CardFrame v)
	{
		view = v;
	}
	
	public void BringData(CardFrame v, User u, UserList ul,int p) //�ʿ��� ���� ��������
	{
		view = v;
		user = u;
		UL = ul;
		price = p;
	}
	
	public boolean scorecheck()  //���� ������� �˻�
	{
		if(score == 15)
			return true;
		else
			return false;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		btn[num] = (Button)e.getSource(); // ��ư�� num��°�� ���� ��ư �ֱ�
		
		if (!btn[num].getBackcheck()) // ���� ��ư�� �ո��϶�
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
				JOptionPane.showMessageDialog(null,"�����մϴ�! �¸��ϼ̽��ϴ�!\n"
						+ "point +" + String.valueOf(price));
				user.ChangePoint(price);
				view.setVisible(false);
				LevelFrame Flevel= new LevelFrame();
				Flevel.BringData(user,UL);
				Flevel.setVisible(true);
				view.dispose();
			}
			
			num++; // num ����
		}
	}
	
}
