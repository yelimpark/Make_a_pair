package project;

import javax.swing.*;

import project.Button;
import project.Reset;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardFrame extends JFrame
{
	private int level = 0,price = level*2; //(ex / ���� = 1, price =2)
	private User user = new User();
	private JLabel id,point; // �ܺο��� ����
	private UserList UL = new UserList();
	private CardActionListner CA = new CardActionListner(this); //ī�常 ����
	private JButton item,quit;
	private JLabel time = new JLabel();
	private timer timer = new timer(40, this); //40�� ���߿� ��ĥ �� ���� ������ ���� �ٸ��� ��Ÿ���� ������ 
	private int CurrentTime = 0;
	
	public CardFrame()
	{
		Button[] button = new Button[30];
		setLayout(null);
		
		time.setText("�ð� : "+timer.gettime());  //�ð� ���� �ٲ�
		time.setBounds(50,20,80,30); 
		add(time);

		id = new JLabel("id"); // ����� �ƾƵ� ��Ÿ���� 
		id.setBounds(740,20,80,30);
		add(id);
		point = new JLabel("point");
		add(point);
		point.setBounds(820,20,80,30);
		
		JPanel cardf = new JPanel();
		cardf.setBounds(50,80,800,620);
		cardf.setLayout(new GridLayout(5,6,30,0));
		
		Reset Game = new Reset();
		for (int i=0; i<30; i++)
		{
			button[i] = new Button(Game.cardname(i), Game.GetImage(i), Game.GetImage(30));
			cardf.add(button[i]);
			button[i].addActionListener(CA);
		}
		add(cardf);
		
		for (int i=0; i<30; i++)
		{
			button[i].turnImage();
			button[i].firstLook(button[i]);
		}
		
		CardFrameListner CFL = new CardFrameListner();
		
		item = new JButton("+5sec"); // ������1
		item.setBounds(880,80,90,90);
		add(item);
		item.addActionListener(CFL);
		JLabel Litem = new JLabel("<1 point>");
		Litem.setBounds(895,180,90,10);
		add(Litem);
		
		quit = new JButton("to main");  // ������ 
		quit.setBounds(880,650,90,50);
		add(quit);
		quit.addActionListener(CFL);
		
		setSize(1000, 750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("playing game...");
		
	}
	
	public void BringData(User arguser,UserList argUL,int arglevel) //�α���â���� �ʿ��� ���� ��������
	{
		level = arglevel;
		price = level*2;
		user = arguser;
		UL = argUL;
		id.setText("ID : " + user.Getid());
		point.setText(String.valueOf("POINT : " + user.GetPoint()));
		CA.BringData(user,UL,price);
	}
	
	public void update()
	{
		CurrentTime = timer.gettime();
		time.setText("�ð� : "+CurrentTime);
	}
	
	public class CardFrameListner implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == item)
			{
				timer.timeadd(5);
				user.ChangePoint(-1);
				point.setText(String.valueOf("POINT : " + user.GetPoint()));
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
	  //  CardFrame f = new CardFrame();
	 //   f.setVisible(true);
	}
}