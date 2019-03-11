package project;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import project.User;
import project.CardFrame;

public class LevelFrame extends JFrame
{
	private JLabel Lid, Lpoint, Ibox;
	private JButton Beasy, Bmiddle, Bhard, Bout, Branking;
	private ImageIcon Ititle;
	private User user = new User();
	private UserList UL = new UserList();

	public LevelFrame()
	{
		// â ����
		setTitle("MAKE A PAIR GAME");
		setSize(1000,750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setBackground(Color.WHITE);
		c.setLayout(null);
		
		//�� ��� ����, ��ġ
		Lid = new JLabel("ID");
		Lid.setBounds(55,30,80,30);
		Lpoint = new JLabel("0");
		Lpoint.setBounds(130,30,80,30);
		
		Beasy = new JButton("�ʱ�");
		Beasy.setBounds(390, 370, 200, 50);
		Bmiddle = new JButton("�߱�");
		Bmiddle.setBounds(390, 430, 200, 50);
		Bhard = new JButton("����");
		Bhard.setBounds(390, 490, 200, 50);
		
		Branking = new JButton("��ŷ");
		Branking.setBounds(55, 620, 80, 30);
		Bout = new JButton("������");
		Bout.setBounds(850, 620, 80, 30);
		
		Ititle = new ImageIcon("title.png");
		Ibox = new JLabel(Ititle);
		Ibox.setBounds(240, 130, 500, 200);
		
		//��� ȭ�鿡 �߰�
		c.add(Lid);
		c.add(Lpoint);
		c.add(Beasy);
		c.add(Bmiddle);
		c.add(Bhard);
		c.add(Branking);
		c.add(Bout);
		c.add(Ibox);
		
		//�׼� �����ʿ� ��ư �߰�
		LevelListner listner = new LevelListner();
		Beasy.addActionListener(listner);
		Bmiddle.addActionListener(listner);
		Bhard.addActionListener(listner);
		Branking.addActionListener(listner);
		Bout.addActionListener(listner);
	}
	
	public class LevelListner implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource()== Beasy) // ���̵� ������ ����â���� ���� ����
			{
				setVisible(false);
				CardFrame Fcard = new CardFrame();
				Fcard.BringData(user,UL,1);
				Fcard.setVisible(true);
				dispose();
			}
			else if (e.getSource()== Bmiddle)
			{
				setVisible(false);
				CardFrame Fcard = new CardFrame();
				Fcard.BringData(user,UL,2);
				Fcard.setVisible(true);
				dispose();
			}
			else if (e.getSource()== Bhard)
			{
				setVisible(false);
				CardFrame Fcard = new CardFrame();
				Fcard.BringData(user,UL,3);
				Fcard.setVisible(true);
				dispose();
			}
			else if (e.getSource()== Branking) // ��ŷ ������ ��������Ʈ ������Ʈ�ϰ� ��ŷ�����ֱ�
			{
				UL.Updateuserlist(user.ToArray());
				UL.ShowRanking();
			}
			else if (e.getSource()== Bout) // ������ ��ư ������ ������ ��������Ʈ ������Ʈ �� ������ ����
			{
				UL.Updateuserlist(user.ToArray());
				System.exit(0);
			}
		}
	}
	
	public void BringData(User arguser,UserList argUL) //�α���â���� �ʿ��� ���� ��������
	{
		user = arguser;
		UL = argUL;
		Lid.setText("ID : " + user.Getid());
		Lpoint.setText(String.valueOf("POINT : " + user.GetPoint()));
	}

}