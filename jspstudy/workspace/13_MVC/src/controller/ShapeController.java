package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import command.RectangleCommand;
import command.TriangleCommand;

//			/*.do 가 아님에 주의
@WebServlet("*.do")	// suffix가 .do인 모든 요청을 처리하는 controller
public class ShapeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShapeController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// JSP의 요청을 확인한다. (triangle.do인지 rectangle.do인지 확인한다.)
		// 1. 전체 요청 URI를 확인한다.	/contextPath/*.do
		// 2. 컨텍스트패스를 확인한다.	/contextPath
		// 3. 1에서 2를 뺀다.			/*.do
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String cmd = requestURI.substring(contextPath.length() + 1);
		Command command = null;
		switch(cmd) {
		case "triangle.do":
			command = new TriangleCommand();
			break;
		case "rectangle.do":
			command = new RectangleCommand();
			break;
		}
		String path = command.execute(request, response);
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
