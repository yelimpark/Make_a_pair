package project;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.io.*;
import java.util.*;


public class FrameTest extends JFrame
{

	public FrameTest() 
	{
		setSize(1000, 750);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("test");
		
		setLayout(null);
		JLabel time = new JLabel("�ð�"); // �ð� ��Ÿ���� 
		time.setBounds(50,20,80,30);
		add(time);
		
		JLabel id = new JLabel("id"); // ����� �ƾƵ� ��Ÿ���� 
		id.setBounds(820,20,80,30);
		add(id);
		
		JPanel card = new JPanel(); // ī�� �迭 �гο� �߰� 
		card.setBounds(50,80,800,620);
		card.setLayout(new GridLayout(5,6));
	}
	
	
	public static void main(String[] argv)
	{
		FrameTest ft = new FrameTest();
		ft.setVisible(true);
	}
}