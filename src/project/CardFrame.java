package project;

import javax.swing.*;

import project.Button;
import project.Reset;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardFrame extends JFrame
{
	//Reset Game;
	private int level = 0,price = level*2; //(ex / ���� = 1, price =2)
	private User user = new User();
	private JLabel id,point; // �ܺο��� ����
	private UserList UL = new UserList();
	private CardActionListner CA = new CardActionListner(this); //ī�常 ����
	private JButton item_1,item_2,quit;
	
	public CardFrame()
	{
		//Game=new Reset();
		Button[] button = new Button[30];
		setLayout(null);
		
		JLabel time = new JLabel("�ð�"); // �ð� ��Ÿ���� 
		time.setBounds(50,20,80,30);
		add(time);

		id = new JLabel("id"); // ����� �ƾƵ� ��Ÿ���� 
		id.setBounds(770,20,80,30);
		add(id);
		point = new JLabel("point");
		add(point);
		point.setBounds(820,20,80,30);
		
		JPanel cardf = new JPanel();
		cardf.setBounds(50,80,800,620);
		cardf.setLayout(new GridLayout(5,6,30,0));
		
		ImageIcon img1 = new ImageIcon("img.jpg");
		ImageIcon img2 = new ImageIcon("title.png");
		//Reset Game = new Reset();
		for (int i=0; i<30; i++)
		{
			//button[i] = new Button(Game.cardname(i), Game.GetImage(30), Game.GetImage(i));
			button[i] = new Button(Integer.toString((i+2)/2),img1,img2);
			cardf.add(button[i]);
			button[i].addActionListener(CA);
		}
		add(cardf);
		
		CardFrameListner CFL = new CardFrameListner();
		
		item_1 = new JButton(); // ������1
		item_1.setBounds(880,80,90,90);
		add(item_1);
		item_1.addActionListener(CFL);
		
		item_2 = new JButton("item"); // ������1
		item_2.setBounds(880,200,90,90);
		add(item_2);
		item_2.addActionListener(CFL);
		
		quit = new JButton("item");  // ������ 
		quit.setBounds(880,650,90,50);
		add(quit);
		quit.addActionListener(CFL);
		
		setSize(1000, 750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("test");
		
	}
	
	public void BringData(User arguser,UserList argUL,int arglevel) //�α���â���� �ʿ��� ���� ��������
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
			if (e.getSource() == item_1)
			{
				
			}
			else if (e.getSource() == item_2)
			{
				
			}
			else if (e.getSource() == quit)
			{
				JOptionPane.showMessageDialog(null,"������ �����ϰ� �������� ���ư��ϴ�.");
				setVisible(false);
				LevelFrame Flevel= new LevelFrame();
				Flevel.BringData(user,UL);
				Flevel.setVisible(true);
				dispose();
			}
		}
	}
	
	public static void main(String[] args)
	{
	    //CardFrame f = new CardFrame();
	    //f.setVisible(true);
	}
}