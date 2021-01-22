package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Gugudan {
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		int startDan = Integer.parseInt(start);
		int endDan = Integer.parseInt(end);

		StringBuffer sb = new StringBuffer();
		for (int dan = startDan; dan <= endDan; dan++) {
			sb.append("<ul>");
			for(int n = 1; n <= 9; n++) {
				sb.append("<li>");
				sb.append(dan).append("*").append(n).append("=").append(dan*n);
				sb.append("</li>");
			}
			sb.append("</ul>");
		}
		request.setAttribute("result", sb.toString());
		return "view/gugudan.jsp";
	}
}
