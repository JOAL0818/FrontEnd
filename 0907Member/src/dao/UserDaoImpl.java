package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import vo.TMember;

public class UserDaoImpl implements UserDao {

	// 싱글톤패턴적용
	// 인스턴스 1개는 필요하므로 - 인스턴스 1개의 주소를 저장할 수 있는 변수를 생성
	// 1개만 써야하니 static으로 썼다.
	private static UserDao userDao;

	// 외부에서 인스턴스를 사용할 수 있도록 public으로 만들고
	// 인스턴스의 주소를 리턴해주는 메소드
	public static UserDao sharedInstance() {
		// 그냥 리턴하면 null이니까 처음한번만 인스턴스를 생성하도록 해주는 코드
		if (userDao == null) {
			userDao = new UserDaoImpl();
		}
		return userDao;
	}

	// 데이터베이스 연결을 위한 변수
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	// 외부에서 인스턴스 생성을 못하도록 생성자를 private으로 설정(밖에서 마음대로 인스턴스 생성불가)
	// connection pool하면서 코드제거함
	private UserDaoImpl() {}

	// 위에 UserDaoImpl에 에러 -> umimplement 메소드생성
	// 로그인 처리메소드를 구현
	// 이메소드 만드는 것은 중요하다 : return =null 도 지우고 만들어야한다.
	@Override
	public TMember login(TMember tmember) {

		// **검사코드
		// 넘어온 파라미터를 출력
		// email과 pw가 제대로 저장되었는지 확인
		// System.out.println("넘어온 데이터:"+tmember);

		TMember user = null;
		try {
			// 데이터베이스 접속

			// connection pool 하면서 코드교체
			// context.xml파일의 내용을 읽어오기
			Context init = new InitialContext();
			// 읽은 내용중에서 DBConn이라는 내용을 읽어서 데이터베이스 접속정보를 생성한다.
			DataSource ds = (DataSource) init.lookup("java:comp/env/DBConn");
			// 접속정보를 이용해서 커넥션 빌려오기
			con = ds.getConnection();

			// Statement 인스턴스를 생성하고 SQL실행
			// where절을 만들때 컬럼의 자료형이 char인 경우, 공백이 같이 와서 문제가 될수 있다 -> trim함수 이용!!
			pstmt = con.prepareStatement("select email,name from tmember where trim(email)=? and trim(pw)=?");

			// ?에 값 채우기
			pstmt.setString(1, tmember.getEmail().trim());
			pstmt.setString(2, tmember.getPw().trim());

			// SQL실행
			rs = pstmt.executeQuery();
			// 결과를 읽기
			// 읽은 데이터가 있는 경우에 user에 인스턴스를 생성해서 대입
			// 읽은 데이터가 없으면 user는 null
			if (rs.next()) {
				// 인스턴스를 생성하고결과를 저장
				user = new TMember();
				user.setEmail(rs.getString("email"));
				user.setName(rs.getString("name"));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}

		// **검사코드
		// System.out.println("리턴하는 데이터:"+user);

		// email과 pw가 일치하는 데이터가 없으면 null이 리턴되고
		// 일치하는 데이터가 있으면 인스턴스를 생성해서 리턴
		return user;
	}

	// 회원가입처리를 위한 메소드 구현
	@Override
	public boolean registerMember(TMember member) {
		boolean result = false;
		try {
			// 데이터베이스 접속

			// connection pool 하면서 코드교체
			// context.xml파일의 내용을 읽어오기
			Context init = new InitialContext();
			// 읽은 내용중에서 DBConn이라는 내용을 읽어서 데이터베이스 접속정보를 생성한다.
			DataSource ds = (DataSource) init.lookup("java:comp/env/DBConn");
			// 접속정보를 이용해서 커넥션 빌려오기
			con = ds.getConnection();

			// Statement 인스턴스를 생성하고 SQL실행
			pstmt = con.prepareStatement("insert into tmember(email, pw, name, phone, addr) values(?,?,?,?,?)");
			// ?에 값 바인딩
			pstmt.setString(1, member.getEmail());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getPhone());
			pstmt.setString(5, member.getAddr());
			// sql실행
			int r = pstmt.executeUpdate();
			if (r > 0)
				result = true;

		} catch (Exception e) {
			// 예외메시지 확인
			System.out.println(e.getMessage());
			// 예외를 역추적
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
			}
		}
		return result;
	}

	// 중복검사 메소드 구현
	@Override
	public boolean emailCheck(String email) {
		boolean result = false;
		try {
			// 데이터베이스 접속
			// connection pool 하면서 코드교체
			// context.xml파일의 내용을 읽어오기
			Context init = new InitialContext();
			// 읽은 내용중에서 DBConn이라는 내용을 읽어서 데이터베이스 접속정보를 생성한다.
			DataSource ds = (DataSource) init.lookup("java:comp/env/DBConn");
			// 접속정보를 이용해서 커넥션 빌려오기
			con = ds.getConnection();

			
			// Statement 인스턴스를 생성하고 SQL실행
			pstmt = con.prepareStatement("select email from tmember where email=?");
			// ?에 값 바인딩
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			// sql실행
			if (rs.next()) {
				result = true;
			}

		} catch (Exception e) {
			// 예외메시지 확인
			System.out.println(e.getMessage());
			// 예외를 역추적
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
			}
		}

		return result;
	}
}
