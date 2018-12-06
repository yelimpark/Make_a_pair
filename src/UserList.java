package project;

import javax.swing.JOptionPane;
import java.io.*;
import java.util.*;
import project.UserFileReader;
import project.User;

/* 
 * 1. 회원 리스트 파일 불러오기
 * 2. 로그인프레임에서 입력받은 정보 대조, 일치 불일치 주기
 * 3. 로그인시 현재 유저 정보에 정보 기입
 * 4. 리스트에서 회원 삭제
 * 5. 게임 결과 포인트에 반영
 * 6. 리스트에서 맞는 자리(랭킹)에 끼워넣기
 * 7. 기존 텍스트파일에 새로운 랭킹 끼워넣기
*/

public class UserList 
{
	private int userNum;
	private String[] tmpUser;
	private ArrayList<String[]> userlist;
	
	public UserList()
	{
		userlist = new ArrayList<String[]>();
		UserFileReader reader = new UserFileReader();
		userlist.clear();
		while(reader.getNextRecord()) 
		{
			userlist.add(reader.getTmpUser());
	    }
		reader.close();
	}
	
	public ArrayList<String[]> Getuserlist() // ArrayList형의 유저리스트 반환
	{
		return userlist;
	}
	
	public boolean LoginCheck (String id, String password) // 로그인 확인
	{	
		for(int i=0; i<userlist.size(); i++)
		{	
			if (userlist.get(i)[0].equals(id))
			{
				if (userlist.get(i)[1].equals(password))
				{
					userNum = i;
					tmpUser = userlist.get(userNum);
					userlist.remove(userNum);
					JOptionPane.showMessageDialog(null,"로그인 되었습니다.");
					return true;
				}
				else
				{
					JOptionPane.showMessageDialog(null,"비밀번호 입력이 잘못되었습니다.");
					return false;
				}
			}
		}
		JOptionPane.showMessageDialog(null,"없는 아이디입니다.");
		return false;
	}
	
	public String[] GetTmpUser()
	{
		return tmpUser;
	}
	
	public boolean DuplicationCheck(String id) // 회원가입시 아이디 중복 확인
	{
		for(int i=0; i<userlist.size(); i++)
		{	
			if (userlist.get(i)[0].equals(id))
			{
				JOptionPane.showMessageDialog(null,"중복된 아이디가 있습니다.");
				return false;
			}
		}
		JOptionPane.showMessageDialog(null,"회원가입 되었습니다.");
		return true;
	}
	
	public void Updateuserlist(String[] user)
	{
		boolean added = false;
		for(int i=0; i<userlist.size(); i++)
		{
			System.out.println(userlist.get(i)[i]);
			if(Integer.parseInt(user[2]) > Integer.parseInt(userlist.get(i)[2]))
			{
				added = true;
				userlist.add(i,user);
				break;
			}
		}
		
		if (!added)
			userlist.add(user);
		
		try
		{
			UpdateUserFile();
		}
		catch (IOException e) 
		{
		    System.out.println("Error in update file : " + e.getMessage());
		}
	}
	
	public void UpdateUserFile() throws IOException
	{
		PrintWriter outfile = new PrintWriter(new FileWriter("userfile.txt"));
		for(int i=0;i<userlist.size(); i++)
		{
			outfile.println(userlist.get(i)[0] + "|" + userlist.get(i)[1] + "|" + userlist.get(i)[2]);
		}
		outfile.println("!");
		outfile.close();
	}
	
	public static void main(String[] args)
	{
		/*UserList ul = new UserList();
		ArrayList<String[]> aa = ul.Getuserlist();
		System.out.println(aa.get(0)[0]);*/
	}

}
