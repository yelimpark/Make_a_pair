package project;

import java.lang.Integer;

// 로그인한 개인 회원 관리
public class User //유저의 계정
{
	private String id,password; // 유저 이름
	private int point; // 유저 포인트
	
	public User () // 이름을 기본값으로 초기화하며 유저 객체 생성
	{
		id = "";
		point = 0;
		password = "";
	}
	
	public User (String init_id, String init_password, int init_point) // 유저형 변수 : 이름과 초기 포인트를 대입
	{
		id = init_id;
		point = init_point;
		password = init_password;
	}
	
	public String Getid() // 유저의 이름을 반환
	{
		return id;
	}
	
	public int GetPoint() // 유저의 포인트를 반환
	{
		return point;
	}
	
	public String GetPassword()
	{
		return password;
	}
	
	public String ToString()
	{
		return "User id : " + id + ", point : " + point;
	}
	
	public String[] ToArray()
	{
		String[] toarray = {id,password,String.valueOf(point)};
		return toarray;
	}
	
	public void ChangePoint (int amount) // 유저의 포인트에 amount만큼 더해줌.
	{
		point += amount;
	}
	
}
