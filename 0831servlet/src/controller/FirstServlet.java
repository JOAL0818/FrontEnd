package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//URL과 Serblet클래스를 매핑시켜주는 어노테이션 - ""안의 부분을 바꿔도 매핑이바뀐다. 
//@WebServlet("/FirstServlet") //index가 없어서 프로젝트로 실행하면 주소를 써줘야한다.
//@WebServlet("/*")	//프로젝트만 실행시켜도 실행된다. 
//@WebServlet("*.do") //확장자가 do로 끝나는 것만 처리할 수 있다. 예)네이버 
@WebServlet("/park/*")

public class FirstServlet extends HttpServlet {
	//Serializable 인터페이스를 implements한 경우, 구분하기 위한 코드 - 없으면 경고 발생 
	private static final long serialVersionUID = 1L; 
       
    //생성자 
    public FirstServlet() {
        super();
    }

	//doGet메소드 : get방식으로 요청했을 때, 호출되는 메소드 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//출력할 타입을 설정 
		response.setContentType("text/html; charset=UTF-8");
		//출력 객체 만들기 
		PrintWriter out = response.getWriter();
		out.println("<html><head>");
		out.println("<title>서블릿</title></head>");
		out.println("<body>처음만드는 서블릿</body></html>");
	}

	//doPost메소드 : post방식으로 요청했을 때, 호출되는 메소드 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//처리를 doGet에 위임(delegate)
		doGet(request, response);
	}
}
