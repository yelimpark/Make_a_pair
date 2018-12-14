package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import project.User;

/*
 * 구성은 아이디 // 입력창 // 비밀번호 // 입력창 // 로그인, 회원가입 버튼
 * 1. 로그인 버튼 눌렀을 때
 * 	입력받은 아이디와 비밀번호를 유저관리로 넘기기, 일치시 창닫기. 불일치시 잘못된 아이디 혹은 비밀번호입니다 창 띄우고 다시 입력받기.
 * 2. 회원가입 버튼 눌렀을 때
 * 	입력받은 아이디와 비밀번호 회원관리로 넘기기, 일치시 중복된 아이디입니다 창 띄우고 다시 입력받기, 불일치시 회원리스트에 추가하기.
 */

public class LoginFrame extends JFrame
{
	private JTextField EId;
	private JPasswordField EPassword;
	private JButton BLogin,BJoin;
	private JLabel LId,LPassword;
	private String id,password;
	private UserList UL;
	private User user;
	
	public LoginFrame()
	{
		setTitle("Login"); // 프레임의 타이틀 달기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //윈도우 닫기버튼으로 창닫기
		setSize(200,280);
		
		Container c = getContentPane(); // 컨텐트팬을 알아낸다
		c.setBackground(Color.WHITE); // 배경색
		c.setLayout(null); // 컨텐트팬에 FlowLayout 배치관리자 달기
		
		// 화면의 요소들 라벨 및 버튼 입력창
		LId = new JLabel("ID : ");
		LId.setBounds(80,20,40,10);
		LPassword = new JLabel("Password : ");
		LPassword.setBounds(60,80,80,10);
		
		BLogin = new JButton("로그인");
		BLogin.setBounds(35,140,120,30);
		BJoin = new JButton("회원가입");
		BJoin.setBounds(35,180,120,30);
		
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
		
		//사건 리스너 객체를 만들고 각각 버튼을 등록
        LoginListener listener = new LoginListener();
        BLogin.addActionListener(listener);
        BJoin.addActionListener(listener);
		
	}
	
    public class LoginListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
		{
			if (e.getSource()== BJoin) // 회원가입 버튼 누를때 
			{
				UL = new UserList();
				id = EId.getText();
				char[] pass = EPassword.getPassword();
				password = new String(pass);
				
				if(id == null || id.trim().isEmpty() || password == null || password.trim().isEmpty()) //빈칸입력시 다시받기
				{
					JOptionPane.showMessageDialog(null,"빈칸을 모두 채워주세요.");
					EId.requestFocus();
					EId.selectAll();
					EPassword.requestFocus();
					EPassword.selectAll();
				}
				else
				{
					boolean idcheck = UL.DuplicationCheck(id); //아이디 중복 확인
					if (idcheck == false) // 중복시 다시받음
					{
						EId.requestFocus();
						EId.selectAll();
						EPassword.requestFocus();
						EPassword.selectAll();
					}
					else // 중복아닐때 유저객체 생성 (나중에 게임 끝나고 유저리스트에 추가,정렬함)
					{
						user = new User(id,password,0);
						
						// 레벨창 띄우기
						setVisible(false);
						LevelFrame Flevel= new LevelFrame();
						Flevel.BringData(user,UL);
						Flevel.setVisible(true);
						dispose();
					}
				}
			}
            else if (e.getSource() == BLogin) // 로그인 버튼 눌렀을 때
			{
				UL = new UserList();
				id = EId.getText();
				char[] pass = EPassword.getPassword();
				password = new String(pass);
				
				if(id == "" || password == "") //빈칸입력시 다시받기
				{
					JOptionPane.showMessageDialog(null,"빈칸을 모두 채워주세요.");
					EId.requestFocus();
					EId.selectAll();
					EPassword.requestFocus();
					EPassword.selectAll();
				}
				
				boolean logincheck = UL.LoginCheck(id,password); // 로그인 정보 맞는지 확인
				if (logincheck == false)
				{
					EId.requestFocus();
					EId.selectAll();
					EPassword.requestFocus();
					EPassword.selectAll();
				}
				else // 맞으면 임시유저에 저장한거 불러와서 유저객체 생성
				{
					String[] tmpuser = UL.GetTmpUser();
					user = new User(tmpuser[0],tmpuser[1],Integer.parseInt(tmpuser[2]));
					
					//레벨창 띄우기
					setVisible(false);
					LevelFrame Flevel= new LevelFrame();
					Flevel.BringData(user,UL);
					Flevel.setVisible(true);
					dispose();
				}
			}
		}
    }
	
	public static void main (String[] args)
	{
		LoginFrame Flogin = new LoginFrame();
		Flogin.setVisible(true);
	}

}
