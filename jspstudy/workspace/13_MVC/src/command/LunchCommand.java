package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LunchCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("time", "점심");
		request.setAttribute("menu", "김치찌개");
		return "/view/output.jsp";
	}

}
