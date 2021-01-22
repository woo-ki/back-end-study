package ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex07_form")
public class Ex07_form extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ex07_form() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request 에서  파라미터 꺼내기
		request.setCharacterEncoding("UTF-8");
		// radio는 하나의 value만 전송된다.
		String choice = request.getParameter("choice");
		// checkbox는 여러 value가 전송됩니다. 배열을 준비합니다.
		String[] interest = request.getParameterValues("interest");
		// <select>태그는 기본적으로 하나의 value만 전송됩니다.
		String alpha = request.getParameter("alpha");
		// <select multiple>태그는 여러 option의 선택이 가능하므로 여러 value가 전달됩니다. 배열을 준비합니다.
		String[] hangul = request.getParameterValues("hangul");
		// <input>태그와 <datalist>태그는 <input>태그처럼 처리합니다. <datalist>태그를 따로 보내지 않습니다.
		String romans = request.getParameter("roman");
		// 같은 name을 가진 서로 다른 태그가 존재하는 경우 서버에서는 배열로 인식됩니다.
		String[] address = request.getParameterValues("address");
		// hidden은 서버로 데이터를 보내는것이 목적이므로 잊지 말고 잘 챙겨줍니다.
		String hidden = request.getParameter("invisible");
		// <textarea>태그는 하나의 value만 보냅니다.
		String memo = request.getParameter("memo");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>제목</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>선택: " + choice + "</h3>");
		out.println("<h3>관심사: ");
		for(String i : interest) {
			out.print(i + " ");
		}
		out.println("</h3>");
		out.println("<h3>영문: " + alpha + "</h3>");
		out.println("<h3>한글: " + Arrays.toString(hangul) + "</h3>");
		out.println("<h3>로마자: " + romans + "</h3>");
		String fullAddr = address[0] + " " + address[1];
		out.println("<h3>주소: " + fullAddr + "</h3>");
		out.println("<h3>히든: " + hidden + "</h3>");
		out.println("<h3>textarea<br/><pre>" + memo + "</pre></h3>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
