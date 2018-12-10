package project;

// �α����� ���� ȸ�� ����
public class User //������ ����
{
	private String id,password; // ���� �̸�
	private int point; // ���� ����Ʈ
	
	public User () // �̸��� �⺻������ �ʱ�ȭ�ϸ� ���� ��ü ����
	{
		id = "";
		point = 0;
		password = "";
	}
	
	public User (String init_id, String init_password, int init_point) // ������ ���� : �̸��� �ʱ� ����Ʈ�� ����
	{
		id = init_id;
		point = init_point;
		password = init_password;
	}
	
	public String Getid() // ������ �̸��� ��ȯ
	{
		return id;
	}
	
	public int GetPoint() // ������ ����Ʈ�� ��ȯ
	{
		return point;
	}
	
	public String GetPassword()
	{
		return password;
	}
	
	public String[] ToArray() //��������Ʈ�� ���� �迭 �������� ��ȯ
	{
		String[] toarray = {id,password,String.valueOf(point)};
		return toarray;
	}
	
	public void ChangePoint (int amount) // ������ ����Ʈ�� amount��ŭ ������.
	{
		point += amount;
	}
	
}