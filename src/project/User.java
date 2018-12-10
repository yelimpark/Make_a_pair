package project;

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
	
	public String[] ToArray() //유저리스트에 들어가는 배열 형식으로 반환
	{
		String[] toarray = {id,password,String.valueOf(point)};
		return toarray;
	}
	
	public void ChangePoint (int amount) // 유저의 포인트에 amount만큼 더해줌.
	{
		point += amount;
	}
	
}