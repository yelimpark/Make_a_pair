package project;

import java.awt.event.*;
import javax.swing.*;

import project.Button;
import project.CardFrame;
import project.LevelFrame;

public class CardActionListner implements ActionListener
{
	// �ܺο��� �����ð� 
	private CardFrame view;
	
	//���ο����� ���°�
	private Button[] btn = new Button[2];  // ��ư �����ص� ����Ʈ
	private int num = 0; // ���ü�-1
	private int score = 0; //���� ī�� �� ���� 
	private boolean sameCard = false;
	
	CardActionListner(CardFrame v)
	{
		view = v;
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
			btn[num] = null;
		}
		else
		{
			btn[num].turnImage();
		   
			if (num == 1)
			{
				sameCard = btn[num].cardcheck(btn[0]);
			    if (sameCard)
			    {
			    	score++;
			    }
				else
				{
					Button tmp = new Button(null,null,null);
					tmp.turnCards(btn[0],btn[1]);
				}
				num = 0;
				btn[0] = null;
				btn[1] = null;
			}
			else
			{
				num++; // num ����
			}
			
			if (scorecheck())
			{
				view.Win(); 
			}
		}
	}
}
