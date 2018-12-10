package project;

import javax.swing.*;
import java.awt.*;

public class CardFrame extends JFrame
{
	private Button[][] button;
	public int level = 0; // !! ����(�ð� ������ ���)
	public User user = new User(); // !! ������ü �����ð�
	private JLabel id,point; // !! �ܺο��� ���̵�,����Ʈ�� �����Ϸ��� �Լ��� ���°� ���ϰ� �׷����� ������������ �ؼ�
	
	public CardFrame()
	{
		button = new Button[5][6];
		setLayout(null);
		JLabel time = new JLabel("�ð�"); // �ð� ��Ÿ���� 
		time.setBounds(50,20,80,30);
		add(time);
		// !! ��Ȱ��ȭ�޼ҵ� �����

		id = new JLabel("id"); // ����� �ƾƵ� ��Ÿ���� 
		id.setBounds(770,20,80,30);
		add(id);
		point = new JLabel("point"); //!! ����Ʈ �߰� (������ ��� �����ϸ� ������Ʈ �ִ��� �˷��ִ°� �����Ű���)
		add(point);
		point.setBounds(820,20,80,30);
		
		//!!�ӽ÷� �̹��� �߰�
		ImageIcon imsi = new ImageIcon("img.jpg");
		ImageIcon imsi2 = new ImageIcon("imgb.png");
		
		JPanel card = new JPanel(); // ī�� �迭 �гο� �߰� 
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
		JButton item_1 = new JButton("item"); // ������1
		item_1.setBounds(880,80,90,90);
		add(item_1);
		
		JButton item_2 = new JButton("item"); // ������1
		item_2.setBounds(880,200,90,90);
		add(item_2);
		
		JButton quit = new JButton("quit");  // ������ 
		quit.setBounds(880,650,90,50);
		add(quit);
		
		setSize(1000, 750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("test");
		
	}
	
	public void setLabelText() // ����â���� ���̵� �� ����Ʈ ��������
	{
		id.setText("ID : " + user.Getid());
		point.setText(String.valueOf("POINT : " + user.GetPoint()));
	}
	
	
	
	
	public static void main(String[] args)
	{
		CardFrame p = new CardFrame();
		p.setVisible(true); // !! ȭ���� �غ���Ŀ� ���̱� 
	}
}