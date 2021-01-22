package ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Quiz02")
public class Quiz02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Quiz02() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String gender = request.getParameter("gender");
		String[] hobbies = request.getParameterValues("hobbies");
		String country = request.getParameter("country");
		String[] jobs = request.getParameterValues("jobs");
		String memo = request.getParameter("memo");
		String height = request.getParameter("height");
		String weight = request.getParameter("weight");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>제목</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<ul>");
		out.println("<li>아이디: " + id + "</li>");
		out.println("<li>비밀번호: " + pw + "</li>");
		out.println("<li>성별: " + gender + "</li>");
		out.println("<li>취미: " + Arrays.toString(hobbies) + "</li>");
		out.println("<li>주소: " + country + "</li>");
		out.println("<li>직업: " + Arrays.toString(jobs) + "</li>");
		out.println("<li><pre>메모: " + memo + "</pre></li>");
		out.println("<li>키: " + height + "</li>");
		out.println("<li>몸무게: " + weight + "</li>");
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
