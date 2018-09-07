package service;

import javax.servlet.http.HttpServletRequest;

import dao.UserDao;
import dao.UserDaoImpl;
import vo.TMember;

public class UserServiceImpl implements UserService {
	// 싱글톤패톤적용
	// 인스턴스 1개는 필요하므로 - 인스턴스 1개의 주소를 저장할 수 있는 변수를 생성
	// 1개만 써야하니 static으로 썼다.
	private static UserService userService;
	// 외부에서 인스턴스를 사용할 수 있도록 public으로 만들고
	// 인스턴스의 주소를 리턴해주는 메소드
	public static UserService sharedInstance() {
		// 그냥 리턴하면 null이니까 처음한번만 인스턴스를 생성하도록 해주는 코드
		if (userService == null) {
			userService = new UserServiceImpl();
		}
		return userService;
	}

	
	
	private UserDao userDao;

	// 외부에서 인스턴스 생성을 못하도록 생성자를 private으로 설정(밖에서 마음대로 인스턴스 생성불가)
	private UserServiceImpl() {
		userDao = UserDaoImpl.sharedInstance();
	}

	@Override
	public TMember login(HttpServletRequest request) {
		// 파라미터 전부 읽기
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");

		// **검사코드
		// 이 메시지가 안나오는 경우는 Controller의 URL을 확인해보고 메소드 이름을 확인해야 한다.
		// 파라미터가 잘못나오는 경우는 jsp파일의 name과 getParameter의 이름을 화인
		// System.out.println("email"+email);
		// System.out.println("pw"+pw);

		// 수행할 연산이 있으면 연산을 수행

		// 호출할 Dao 메소드의 매개변수를 생성
		TMember member = new TMember();
		member.setEmail(email);
		member.setPw(pw);

		// Dao 메소드 호출
		TMember user = userDao.login(member);
		// 결과리턴
		return user;
	}
}
