package project;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * 구성은 아이디 // 입력창 // 비밀번호 // 입력창 // 로그인, 회원가입 버튼
 * 1. 로그인 버튼 눌렀을 때
 * 	입력받은 아이디와 비밀번호를 유저관리로 넘기기, 일치시 창닫기. 불일치시 잘못된 아이디 혹은 비밀번호입니다 창 띄우고 다시 입력받기.
 * 2. 회원가입 버튼 눌렀을 때
 * 	입력받은 아이디와 비밀번호 회원관리로 넘기기, 일치시 중복된 아이디입니다 창 띄우고 다시 입력받기, 불일치시 회원리스트에 추가하기.
 */

public class LoginFrame extends JFrame implements ActionListener
{
	private JTextField EId;
	private JPasswordField EPassword;
	private JButton BLogin,BJoin;
	private JLabel LId,LPassword;
	private String id,password;
	
	public LoginFrame()
	{
		setTitle("Login"); // 프레임의 타이틀 달기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //윈도우 닫기버튼으로 창닫기
		
		Container c = getContentPane(); // 컨텐트팬을 알아낸다
		c.setBackground(Color.WHITE); // 배경색
		c.setLayout(null); // 컨텐트팬에 FlowLayout 배치관리자 달기
		
		// 화면의 요소들 라벨 및 버튼 입력창
		
		JLabel LId = new JLabel("ID : ");
		LId.setBounds(80,20,40,10);
		JLabel LPassword = new JLabel("Password : ");
		LPassword.setBounds(60,80,80,10);
		
		JButton BLogin = new JButton("로그인");
		BLogin.setBounds(35,140,120,30);
		BLogin.addActionListener(this);
		JButton BJoin = new JButton("회원가입");
		BJoin.setBounds(35,180,120,30);
		BJoin.addActionListener(this);
		
		EId = new JTextField(10);
		EId.setBounds(25,40,140,20);
		EPassword = new JPasswordField(10);
		EPassword.setBounds(25,100,140,20);
		
		// 요소들 추가하기
		c.add(LId);
		c.add(EId);
		c.add(LPassword);
		c.add(EPassword);
		c.add(BLogin);
		c.add(BJoin);
		
		// 화면창 보이는 설정
		setSize(200,280);
		setVisible(true);
		
	}
	
	public void ActionPeformed (ActionEvent e)
	{
		String id = EId.getText();
		char[] pass = EPassword.getPassword();
		String password = new String(pass);

	}
	
	public static void main (String[] args)
	{
		new LoginFrame();
		String[][] arr = {{"aaa","1234","12"},{"aaa","1234",""}};
		UserManagement.LoginCheck(arr,2,id,password);
	}

}

