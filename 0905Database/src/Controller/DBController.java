package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VO.Buy;


@WebServlet("*.db")
public class DBController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DBController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청주소에서 공통된 부분을 제외한 부분을 추출
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length()+1);
		
		//조건이 많을 때 분기문은 switch가 좋다. 
		switch(command) {
		case "mysql.db" :
			try {
				//드라이버클래스 로드
				Class.forName("com.mysql.jdbc.Driver");
				//데에터베이스 연결 
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/joal?characterEncoding=UTF-8&serverTimezone=UTC","root", "00000000");  
				System.out.println(con);
				con.close();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			break;
			
			
		case "oracle.db" : 
			try {
				//드라이버클래스 로드
				Class.forName("oracle.jdbc.driver.OracleDriver");
				//데에터베이스 연결 
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.101:1521:xe","user01", "user01");  
				System.out.println(con);
				con.close();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			break;
		
		
		case "insert.db":
			Connection con1 = null;
			PreparedStatement pstmt = null;			
			try {
				//드라이버클래스 로드
				Class.forName("com.mysql.jdbc.Driver");
				//데에터베이스 연결 
				con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/joal?characterEncoding=UTF-8&serverTimezone=UTC","root", "00000000");  
				pstmt = con1.prepareStatement("insert into usertbl(userid,name,birthyear, addr, mobile, mdate) values(?,?,?,?,?,?)");
				pstmt.setString(1, "joal");
				pstmt.setString(2, "조아라");
				pstmt.setInt(3, 1990);
				pstmt.setString(4, "서울");
				pstmt.setString(5, "010010");
				pstmt.setDate(6, new Date(5,11,3));
				
				//sql을 실행하고 결과 저장하기 
				int result = pstmt.executeUpdate();
				if(result>0) {
					System.out.println("삽입성공");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if(con1!=null)con1.close();
					if(pstmt!=null)pstmt.close();
				}catch(Exception e) { }
			}
			
			break;
			
			
		case "delete.db":
			Connection con2 = null;
			PreparedStatement pstmt2 = null;			
			try {
				//드라이버클래스 로드
				Class.forName("com.mysql.jdbc.Driver");
				//데에터베이스 연결 
				con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/joal?characterEncoding=UTF-8&serverTimezone=UTC","root", "00000000");  
				pstmt2 = con2.prepareStatement("delete from usertbl where userid=?");
				pstmt2.setString(1, "joal");
				
				//sql을 실행하고 결과 저장하기 
				int result2 = pstmt2.executeUpdate();
				if(result2>0) {
					System.out.println("삭제성공");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if(con2!=null)con2.close();
					if(pstmt2!=null)pstmt2.close();
				}catch(Exception e) { }
			}
			
			break;	
			
		
		case "selectlist.db":
			Connection con3 = null;
			PreparedStatement pstmt3 = null;
			
			//select할때 필요한 친구 
			ResultSet rs3 = null;
			//select구문은 결과를 저장할 변수가 필요 
			//list는 이렇게 바깥에 만들어야한다! 
			List<Buy> list = new ArrayList<Buy>();			
			try {
				//드라이버클래스 로드
				Class.forName("com.mysql.jdbc.Driver");
				//데에터베이스 연결 
				con3 = DriverManager.getConnection("jdbc:mysql://localhost:3306/joal?characterEncoding=UTF-8&serverTimezone=UTC","root", "00000000");  
				pstmt3 = con3.prepareStatement("select * from buytbl");
				
				//sql을 실행하고 결과 저장하기 
				rs3 = pstmt3.executeQuery();
				
				//리턴된 데이터를 읽어서 list에 저장 
				while(rs3.next()) {
					Buy buy = new Buy ();
					buy.setNum(rs3.getInt("num"));
					buy.setUserid(rs3.getString("userid"));
					buy.setProductname(rs3.getString("productname"));
					buy.setGroupname(rs3.getString("groupname"));
					buy.setPrice(rs3.getInt("price"));
					buy.setAmount(rs3.getInt("amount"));
					
					list.add(buy);				
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if(rs3!=null)rs3.close();
					if(con3!=null)con3.close();
					if(pstmt3!=null)pstmt3.close();
				}catch(Exception e) { }
			}
			//⌜데이터가 있는지 없는지만 알고 싶다면 이렇게 출력 
			//System.out.println(list); 
			//⌜이렇게 빠른열거를 사용하면 데이터 한개씩 가져올 수 있다. : 줄단위확
			for(Buy buy:list) {
				System.out.println(buy);
			}
			break;		
			
			
		case "selectone.db":
			Connection con4 = null;
			PreparedStatement pstmt4 = null;
			//select할때 필요한 친구 
			ResultSet rs4 = null;
			
			//데이터를 1개만 리턴하는 경우에는 인스턴스를 생성하지 말고 변수만 생성한다.
			Buy buy = null;
			try {
				//드라이버클래스 로드
				Class.forName("com.mysql.jdbc.Driver");
				//데에터베이스 연결 
				con4 = DriverManager.getConnection("jdbc:mysql://localhost:3306/joal?characterEncoding=UTF-8&serverTimezone=UTC","root", "00000000");  
				pstmt4 = con4.prepareStatement("select * from buytbl where num=?");
				
				//문자열을 정수로 변환해서 ?에 바인딩 
				//무조건 문자열로 읽어와야하고 넣을 때는 숫자로 넣어야한다. 
				String num = request.getParameter("num");
				pstmt4.setInt(1, Integer.parseInt(num));
				
				//sql을 실행하고 결과 저장하기 
				rs4 = pstmt4.executeQuery();
				
				//리턴된 데이터를 읽어서 list에 저장 
				if(rs4.next()) {
					buy = new Buy();
					buy.setNum(rs4.getInt("num"));
					buy.setUserid(rs4.getString("userid"));
					buy.setProductname(rs4.getString("productname"));
					buy.setGroupname(rs4.getString("groupname"));
					buy.setPrice(rs4.getInt("price"));
					buy.setAmount(rs4.getInt("amount"));
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if(rs4!=null)rs4.close();
					if(con4!=null)con4.close();
					if(pstmt4!=null)pstmt4.close();
				}catch(Exception e) { }
			}
			System.out.println(buy); 
			
			break;		
					
		}	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doGet(request, response);
	}

}
