package project;
import java.io.*;
import java.util.*;

public class UserFileReader {
	private BufferedReader infile;
	private String EOF = "!";
	private String[] tmpUser = new String[3]; //���� ����Ʈ���� ���� {�̸�(���̵�), ��й�ȣ, ����Ʈ}
	
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
			// ���� ���� �غ� �Ǿ����� Ȯ��
			if(!infile.ready()) return false;
			
			// ���� �а� ��ū���� ������.
			line = infile.readLine();			
			StringTokenizer t = new StringTokenizer(line, "|");
			word = t.nextToken().trim();
			
			// ù��° �ܾ ������ ���� �ƴϰ�, ��ū�� �ΰ��� ��쿡 �ӽ������� ����.
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
