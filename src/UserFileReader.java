package project;
import java.io.*;
import java.util.*;

public class UserFileReader {
	private BufferedReader infile;
	private String EOF = "!";
	private String[] tmpUser = new String[3]; //유저 리스트에들어갈 유저 {이름(아이디), 비밀번호, 포인트}
	
	public UserFileReader()
	{
		try 
		{
  		    infile = new BufferedReader(new FileReader("userfile.txt"));
		}
		catch (IOException e) 
		{
		    System.out.println("Error in openning the file : " + e.getMessage());
		}
	}
	
	public String[] getTmpUser()
	{
		return tmpUser;
	}
	
	public void close() 
	{
		try
		{
			infile.close();
		}
		catch (IOException e)
		{
			System.out.println("Error in closing the file : " + e.getMessage());
		}
	}
	
	public boolean getNextRecord() 
	{
		boolean result = false;
		String line,word;
	
		try 
		{
			// 파일 읽을 준비가 되었는지 확인
			if(!infile.ready()) return false;
			
			// 한줄 읽고 토큰으로 나누기.
			line = infile.readLine();			
			StringTokenizer t = new StringTokenizer(line, "|");
			word = t.nextToken().trim();
			
			// 첫번째 단어가 파일의 끝이 아니고, 토큰이 두개인 경우에 임시유저에 저장.
			if (!word.equals(EOF))
			{
				if(t.countTokens() == 2) 
				{
					tmpUser[0] = word;
					tmpUser[1] = t.nextToken().trim();
					tmpUser[2] = t.nextToken().trim();
						
				    result = true;
				}
				else throw new RuntimeException(line);
			}
		}
		catch (IOException e) 
		{
		    System.out.println("Error in reading file : " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("getNextRecord : bad format : " + e.getMessage() + "skipping record");
			return getNextRecord();
		}
		return result;
	}

}
