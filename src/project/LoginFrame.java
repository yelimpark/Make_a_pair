package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import project.User;

/*
 * ������ ���̵� // �Է�â // ��й�ȣ // �Է�â // �α���, ȸ������ ��ư
 * 1. �α��� ��ư ������ ��
 * 	�Է¹��� ���̵�� ��й�ȣ�� ���������� �ѱ��, ��ġ�� â�ݱ�. ����ġ�� �߸��� ���̵� Ȥ�� ��й�ȣ�Դϴ� â ���� �ٽ� �Է¹ޱ�.
 * 2. ȸ������ ��ư ������ ��
 * 	�Է¹��� ���̵�� ��й�ȣ ȸ�������� �ѱ��, ��ġ�� �ߺ��� ���̵��Դϴ� â ���� �ٽ� �Է¹ޱ�, ����ġ�� ȸ������Ʈ�� �߰��ϱ�.
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
		setTitle("Login"); // �������� Ÿ��Ʋ �ޱ�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //������ �ݱ��ư���� â�ݱ�
		setSize(200,280);
		
		Container c = getContentPane(); // ����Ʈ���� �˾Ƴ���
		c.setBackground(Color.WHITE); // ����
		c.setLayout(null); // ����Ʈ�ҿ� FlowLayout ��ġ������ �ޱ�
		
		// ȭ���� ��ҵ� �� �� ��ư �Է�â
		LId = new JLabel("ID : ");
		LId.setBounds(80,20,40,10);
		LPassword = new JLabel("Password : ");
		LPassword.setBounds(60,80,80,10);
		
		BLogin = new JButton("�α���");
		BLogin.setBounds(35,140,120,30);
		BJoin = new JButton("ȸ������");
		BJoin.setBounds(35,180,120,30);
		
		EId = new JTextField(10);
		EId.setBounds(25,40,140,20);
		EPassword = new JPasswordField(10);
		EPassword.setBounds(25,100,140,20);
		
		// ��ҵ� �߰��ϱ�
		c.add(LId);
		c.add(EId);
		c.add(LPassword);
		c.add(EPassword);
		c.add(BLogin);
		c.add(BJoin);
		
		//��� ������ ��ü�� ����� ���� ��ư�� ���
        LoginListener listener = new LoginListener();
        BLogin.addActionListener(listener);
        BJoin.addActionListener(listener);
		
	}
	
    public class LoginListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
		{
			if (e.getSource()== BJoin) // ȸ������ ��ư ������ 
			{
				UL = new UserList();
				id = EId.getText();
				char[] pass = EPassword.getPassword();
				password = new String(pass);
				
				if(id == null || id.trim().isEmpty() || password == null || password.trim().isEmpty()) //��ĭ�Է½� �ٽùޱ�
				{
					JOptionPane.showMessageDialog(null,"��ĭ�� ��� ä���ּ���.");
					EId.requestFocus();
					EId.selectAll();
					EPassword.requestFocus();
					EPassword.selectAll();
				}
				else
				{
					boolean idcheck = UL.DuplicationCheck(id); //���̵� �ߺ� Ȯ��
					if (idcheck == false) // �ߺ��� �ٽù���
					{
						EId.requestFocus();
						EId.selectAll();
						EPassword.requestFocus();
						EPassword.selectAll();
					}
					else // �ߺ��ƴҶ� ������ü ���� (���߿� ���� ������ ��������Ʈ�� �߰�,������)
					{
						user = new User(id,password,0);
						
						// ����â ����
						setVisible(false);
						LevelFrame Flevel= new LevelFrame();
						Flevel.BringData(user,UL);
						Flevel.setVisible(true);
						dispose();
					}
				}
			}
            else if (e.getSource() == BLogin) // �α��� ��ư ������ ��
			{
				UL = new UserList();
				id = EId.getText();
				char[] pass = EPassword.getPassword();
				password = new String(pass);
				
				if(id == "" || password == "") //��ĭ�Է½� �ٽùޱ�
				{
					JOptionPane.showMessageDialog(null,"��ĭ�� ��� ä���ּ���.");
					EId.requestFocus();
					EId.selectAll();
					EPassword.requestFocus();
					EPassword.selectAll();
				}
				
				boolean logincheck = UL.LoginCheck(id,password); // �α��� ���� �´��� Ȯ��
				if (logincheck == false)
				{
					EId.requestFocus();
					EId.selectAll();
					EPassword.requestFocus();
					EPassword.selectAll();
				}
				else // ������ �ӽ������� �����Ѱ� �ҷ��ͼ� ������ü ����
				{
					String[] tmpuser = UL.GetTmpUser();
					user = new User(tmpuser[0],tmpuser[1],Integer.parseInt(tmpuser[2]));
					
					//����â ����
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
