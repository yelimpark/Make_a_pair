package project;

import javax.swing.JOptionPane;

/* 
 * 1. 회원 리스트 파일 불러오기
 * 2. 로그인프레임에서 입력받은 정보 대조, 일치 불일치 주기
 * 3. 로그인시 현재 유저 정보에 정보 기입
 * 4. 리스트에서 회원 삭제
 * 5. 게임 결과 포인트에 반영
 * 6. 리스트에서 맞는 자리(랭킹)에 끼워넣기
 * 7. 기존 텍스트파일에 새로운 랭킹 끼워넣기
*/

public class UserManagement 
{
	public UserManagement()
	{
		// 유저 리스트로 가지고 있기
		// 삼중 리스트 [[이름(아이디)][비밀번호][포인트]]
	}
	
	
	
	public boolean LoginCheck (String[][] userlist, int ulSize, String id, String password)
	{
		for(int i=0; i<ulSize; i++)
		{
			if (userlist[i][0] == id)
			{
				if (userlist[i][1] == password)
				{
					JOptionPane.showMessageDialog(null,"로그인 되었습니다.");
					return true;
				}
				else
				{
					JOptionPane.showMessageDialog(null,"비밀번호 입력이 잘못되었습니다.");
					return false;
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null,"없는 아이디입니다.");
				return false;
			}
		}
	}
	
	public String[] GetUserList ()
	{
		
	}

}
