package ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Quiz01")
public class Quiz01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Quiz01() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		Date time = new Date(System.currentTimeMillis());
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String fTime = f.format(time);
		/*
			Calendar cal = Calendar.getInstance();
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH) + 1;
			int day = cal.get(Calendar.DATE);
			String time = year + "-" + month + "-" + day;
		*/
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>서블릿으로 만든 제목</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1 id=\"h1\">" + fTime + "</h1>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
