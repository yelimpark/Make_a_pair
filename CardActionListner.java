package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import project.Button;
import project.CardFrame;
import project.LevelFrame;

public class CardActionListner implements ActionListener
{
	Button[] btn = new Button[2];  // 버튼 
	private int num = 0; // 선택수-1
	int score = 0; //맞춘 카드 쌍 개수 
	boolean sameCard = false;
	
	public boolean scorecheck()  //전부 맞췄는지 
	{
		if(score == 15)
			return true;
		else
			return false;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		btn[num] = (Button)e.getSource(); // 버튼의 num번째에 누른 버튼 넣기
		btn[num].turnImage();
		
		if (num == 1)
		{
			sameCard = btn[num].cardcheck(btn[0]);
			num = 0;
			btn = new Button[2];
		}
		
		if (sameCard)
			score++;
		
		if (scorecheck())
		{
			JOptionPane.showMessageDialog(null,"축하합니다! 승리하셨습니다!\n"
					+ "point +" + String.valueOf(price));
			setVisible(false);
		}
		num++; // num 증가
	}
	
}
