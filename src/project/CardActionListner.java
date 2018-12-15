package project;

import java.awt.event.*;
import javax.swing.*;

import project.Button;
import project.CardFrame;
import project.LevelFrame;

public class CardActionListner implements ActionListener
{
	// 외부에서 가져올것 
	private CardFrame view;
	
	//내부에서만 ㅆ는것
	private Button[] btn = new Button[2];  // 버튼 저장해둘 리스트
	private int num = 0; // 선택수-1
	private int score = 0; //맞춘 카드 쌍 개수 
	private boolean sameCard = false;
	
	CardActionListner(CardFrame v)
	{
		view = v;
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
				num++; // num 증가
			}
			
			if (scorecheck())
			{
				view.Win(); 
			}
		}
	}
}
