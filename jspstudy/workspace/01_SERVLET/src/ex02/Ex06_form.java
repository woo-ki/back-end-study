package ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex06_form")
public class Ex06_form extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ex06_form() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// <form action="/01_SERVLET/Ex04_form"> 태그에 의해서
		// 폼 요소들이 request로 전달되는 곳이다.
		// <form method="get"> 이기 때문에 doGet() 메소드로 곧바로 온다.
		
		// resquest 처리하기
		request.setCharacterEncoding("UTF-8");
		// request로 전달된 파라미터 꺼내기
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String address = request.getParameter("address");
		//response 생성
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>제목</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>이름: " + name + "</h3>");
		out.println("<h3>나이: " + age + "</h3>");
		out.println("<h3>주소: " + address + "</h3>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
