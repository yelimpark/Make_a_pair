package project;

import javax.swing.JOptionPane;
import java.io.*;
import java.util.*;
import project.UserFileReader;

public class UserList 
{
	private int userNum;
	private String[] tmpUser;
	private ArrayList<String[]> userlist;
	
	public UserList() // ��������Ʈ��ü ������ �������ϸ����� �̿��� ��������Ʈ�� ����.
	{
		String[] readUser = new String[3];	
		userlist = new ArrayList<String[]>();
		userlist.clear();
		
		UserFileReader reader = new UserFileReader();
		while(reader.getNextRecord()) 
		{
			readUser = reader.getTmpUser();
 			userlist.add(new String[]{readUser[0], readUser[1], readUser[2]});
	    }
		reader.close();
	}
	
	public ArrayList<String[]> Getuserlist() // ArrayList���� ��������Ʈ ��ȯ
	{
		return userlist;
	}
	
	public boolean LoginCheck (String id, String password) // �α��� Ȯ��
	{	
		for(int i=0; i<userlist.size(); i++)
		{	
			if (userlist.get(i)[0].equals(id))
			{
				if (userlist.get(i)[1].equals(password)) //�ش� ���������� ��ġ�ϴ� ���������� ã���� ��
				{
					userNum = i;
					tmpUser = userlist.get(userNum); //���������� �ӽ������� ����
					userlist.remove(userNum);
					JOptionPane.showMessageDialog(null,"�α��� �Ǿ����ϴ�.");
					return true;
				}
				else
				{
					JOptionPane.showMessageDialog(null,"��й�ȣ �Է��� �߸��Ǿ����ϴ�.");
					return false;
				}
			}
		}
		JOptionPane.showMessageDialog(null,"���� ���̵��Դϴ�.");
		return false;
	}
	
	public String[] GetTmpUser() // ã�� �ӽ������� ����
	{
		return tmpUser;
	}
	
	public boolean DuplicationCheck(String id) // ȸ�����Խ� ���̵� �ߺ� Ȯ��
	{
		for(int i=0; i<userlist.size(); i++)
		{	
			if (userlist.get(i)[0].equals(id))
			{
				JOptionPane.showMessageDialog(null,"�ߺ��� ���̵� �ֽ��ϴ�.");
				return false;
			}
		}
		JOptionPane.showMessageDialog(null,"ȸ������ �Ǿ����ϴ�.");
		return true;
	}
	
	public void Updateuserlist(String[] user) // ���ǻ� ������ ������ü�� �ƴ� ����Ʈ�� �޴°Ϳ� ����
	{
		boolean added = false; //������ ����Ʈ�� �������°�
		
		for(int i=0; i<userlist.size(); i++) //������ �� ������ ����Ʈ�� �����ϸ� ����
		{
			if (userlist.get(i)[0].equals(user[0]))
				userlist.remove(i);
		}
		
		for(int i=0; i<userlist.size(); i++) // ������ ���� ���� �����ֱ�
		{
			if(Integer.parseInt(user[2]) > Integer.parseInt(userlist.get(i)[2]))
			{
				added = true;
				userlist.add(i,user);
				break;
			}
		}
		
		if (!added) //������ �������� �ʾ����� �� ���� �߰� 
			userlist.add(user);
		
		try // ����Ʈ ������ �ڵ����� ���� �ٽþ���
		{
			UpdateUserFile();
		}
		catch (IOException e) 
		{
		    System.out.println("Error in update file : " + e.getMessage());
		}

	}
	
	public void UpdateUserFile() throws IOException //���� �ٽþ���
	{
		PrintWriter outfile = new PrintWriter(new FileWriter("userfile.txt"));
		for(int i=0;i<userlist.size(); i++)
		{
			outfile.println(userlist.get(i)[0] + "|" + userlist.get(i)[1] + "|" + userlist.get(i)[2]);
		}
		outfile.println("!");
		outfile.close();
	}
	
	public void ShowRanking() // ��ŷ �˾�â���� ����ֱ�
	{
		String ranking = "";
		
		for (int i=0; i<userlist.size(); i++)
		{
			ranking += "\n" + String.valueOf(i) + "�� | " + userlist.get(i)[0] + " " + userlist.get(i)[2] + "��";
		}
		JOptionPane.showMessageDialog(null,"��ŷ�� Ȯ���ϼ���." + ranking);
	}
	
	public static void main(String[] args)
	{
		// UserList ul = new UserList();
	}
	

}