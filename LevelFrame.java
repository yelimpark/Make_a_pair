package project;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import project.User;

public class LevelFrame extends JFrame
{
	private JLabel Lid, Lpoint;
	private JButton Beasy, Bmiddle, Bhard, Bout, Branking;
	private ImageIcon Ititle;
	public User user;

	public LevelFrame()
	{
		setTitle("MAKE A PAIR GAME");
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setBackground(Color.WHITE);
		c.setLayout(null);
		
		user = new User();
		Lid = new JLabel("아이디");
		Lid.setBounds(55,30,80,30);
		Lpoint = new JLabel("포인트");
		Lpoint.setBounds(130,30,80,30);
		
		Beasy = new JButton("초급");
		Beasy.setBounds(280, 230, 200, 50);
		Bmiddle = new JButton("중급");
		Bmiddle.setBounds(280, 300, 200, 50);
		Bhard = new JButton("고급");
		Bhard.setBounds(280, 370, 200, 50);
		
		Branking = new JButton("랭킹");
		Branking.setBounds(55, 500, 80, 30);
		Bout = new JButton("끝내기");
		Bout.setBounds(650, 500, 80, 30);
		
		c.add(Lid);
		c.add(Lpoint);
		c.add(Beasy);
		c.add(Bmiddle);
		c.add(Bhard);
		c.add(Branking);
		c.add(Bout);
		
		LevelListner listner = new LevelListner();
		Beasy.addActionListener(listner);
	}
	
	public class LevelListner implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
		}
	}
	
	public static void main(String[] args)
	{
		LevelFrame frame = new LevelFrame();
		frame.setVisible(true);
	}
}
