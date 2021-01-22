package ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Quiz03")
public class Quiz03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Quiz03() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		double kor = Double.parseDouble(request.getParameter("kor"));
		double eng = Double.parseDouble(request.getParameter("eng"));
		double mat = Double.parseDouble(request.getParameter("mat"));
		double pastAvg = Double.parseDouble(request.getParameter("pastAvg"));
		double avg = (kor + eng + mat) / 3;
		String grade = "";
		if(avg >= 90) {
			grade = "A";
		} else if(avg >= 80) {
			grade = "B";
		} else if(avg >= 70) {
			grade = "C";
		} else if(avg >= 60) {
			grade = "D";
		} else {
			grade = "F";
		}
		double avgDiff = 0.0;
		if(avg >= pastAvg) {
			avgDiff = avg - pastAvg;
		} else {
			avgDiff = pastAvg - avg;
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>제목</title>");
		out.println("</head>");
		out.println("<body>");
		out.println(name + "의 평균은 " + avg + "점이고, 학점은 " + grade + "학점이다.<br/>");
		out.println("지난 시험의 평균은 " + pastAvg + "점으로 이번 평균과 " + avgDiff + "점의 차이가 있다.");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
