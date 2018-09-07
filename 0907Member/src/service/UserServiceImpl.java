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

	
	//회원가입처리를 위한 메소드 구현 
	@Override
	public boolean registerMember(HttpServletRequest request) {
		
		//**검사코드 
		System.out.println("서비스도착");
		
		boolean result =false; 
		// 파라미터 전부 읽기
		try {
			request.setCharacterEncoding("utf-8");
		}catch(Exception e){
			e.printStackTrace();
		}
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String addr = request.getParameter("addr");
		
		//**검사코드 : 파라미터 출력 - null나오면 jsp에서 사용한 name과 파라미터이름 확인 
		System.out.println("email:"+email);
		System.out.println("pw:"+pw);
		System.out.println("name:"+name);
		System.out.println("phone:"+phone);
		System.out.println("addr:"+addr);
		
		
		//Dao 메소드의 파라미터 만들기 
		TMember member = new TMember();
		member.setEmail(email);
		member.setPw(pw);
		member.setName(name);
		member.setPhone(phone);
		member.setAddr(addr);
		
		//**검사코드 - 제대로 줬는지 검사 : 이렇게 묶어야 빠른확인이 가능하다! 
		System.out.println(member);
		
		//Dao메소드 호출 
		result = userDao.registerMember(member);		
		return result;
	}

	
	//이메일 중복체크를 위한 메소드 구현
	@Override
	public boolean emailCheck(HttpServletRequest request) {
		//파라미터 읽어오기
		String email = request.getParameter("email");
		//Dao의 메소드 호출 
		boolean result = userDao.emailCheck(email);
		return result;
	}
}
