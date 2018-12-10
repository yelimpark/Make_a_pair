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
	
	public UserList() // 유저리스트객체 생성시 유저파일리더를 이용해 유저리스트에 저장.
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
				if (userlist.get(i)[1].equals(password)) //해당 유저정보와 일치하는 유저정보를 찾았을 때
				{
					userNum = i;
					tmpUser = userlist.get(userNum); //유저정보를 임시유저에 저장
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
	
	public String[] GetTmpUser() // 찾은 임시유저를 리턴
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
	
	public void Updateuserlist(String[] user) // 편의상 유저를 유저객체가 아닌 리스트로 받는것에 주의
	{
		boolean added = false; //유저가 리스트에 더해졌는가
		
		for(int i=0; i<userlist.size(); i++) //유저의 전 정보가 리스트에 존재하면 삭제
		{
			if (userlist.get(i)[0].equals(user[0]))
				userlist.remove(i);
		}
		
		for(int i=0; i<userlist.size(); i++) // 적절한 곳에 유저 끼워넣기
		{
			if(Integer.parseInt(user[2]) > Integer.parseInt(userlist.get(i)[2]))
			{
				added = true;
				userlist.add(i,user);
				break;
			}
		}
		
		if (!added) //유저가 더해지지 않았으면 맨 끝에 추가 
			userlist.add(user);
		
		try // 리스트 수정시 자동으로 파일 다시쓰기
		{
			UpdateUserFile();
		}
		catch (IOException e) 
		{
		    System.out.println("Error in update file : " + e.getMessage());
		}

	}
	
	public void UpdateUserFile() throws IOException //파일 다시쓰기
	{
		PrintWriter outfile = new PrintWriter(new FileWriter("userfile.txt"));
		for(int i=0;i<userlist.size(); i++)
		{
			outfile.println(userlist.get(i)[0] + "|" + userlist.get(i)[1] + "|" + userlist.get(i)[2]);
		}
		outfile.println("!");
		outfile.close();
	}
	
	public void ShowRanking() // 랭킹 팝업창으로 띄워주기
	{
		String ranking = "";
		
		for (int i=0; i<userlist.size(); i++)
		{
			ranking += "\n" + String.valueOf(i) + "위 | " + userlist.get(i)[0] + " " + userlist.get(i)[2] + "점";
		}
		JOptionPane.showMessageDialog(null,"랭킹을 확인하세요." + ranking);
	}
	
	public static void main(String[] args)
	{
		// UserList ul = new UserList();
	}
	

}