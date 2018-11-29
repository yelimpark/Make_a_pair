package project;

// 로그인한 개인 회원 관리
public class User //유저의 계정
{
	private String name; // 유저 이름
	private int point,password; // 유저 포인트
	
	public User () // 이름을 기본값으로 초기화하며 유저 객체 생성
	{
		name = "";
		point = 0;
		password = 0;
	}
	
	public User (String init_name, int init_point, int init_password) // 유저형 변수 : 이름과 초기 포인트를 대입
	{
		name = init_name;
		point = init_point;
		password = init_password;
	}
	
	public String GetName() // 유저의 이름을 반환
	{
		return name;
	}
	
	public int GetPoint() // 유저의 포인트를 반환
	{
		return point;
	}
	
	public int GetPassword()
	{
		return password;
	}
	
	public String ToString()
	{
		return "User name : " + name + ", point : " + point + ", password : " + password;
	}
	
	public void ChangePoint (int amount) // 유저의 포인트에 amount만큼 더해줌.
	{
		point += amount;
	}
	
}
