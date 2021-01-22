package command;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Time {
	public String getTime(HttpServletRequest request, HttpServletResponse response) {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat s1 = new SimpleDateFormat("a h:mm:ss");
		String time = s1.format(date);
		request.setAttribute("time", time);
		return "view/time.jsp";
	}
}
