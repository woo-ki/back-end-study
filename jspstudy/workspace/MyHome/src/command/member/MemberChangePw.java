package command.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import dto.MemberDto;

@WebServlet("/MemberChangePw")
public class MemberChangePw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberChangePw() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String mNo = request.getParameter("mNo");
		String mPw = request.getParameter("mPw");
		
		MemberDto memberDto = new MemberDto();
		memberDto.setmPw(mPw);
		memberDto.setmNo(Integer.parseInt(mNo));
		
		int result = MemberDao.getInstance().updatemPw(memberDto);
		
		String responseText = null;
		if(result > 0) {
			HttpSession session = request.getSession();
			if(session.getAttribute("loginDto") != null) {
				session.removeAttribute("loginDto");
				MemberDto loginDto = MemberDao.getInstance().selectBymNo(mNo);
				session.setAttribute("loginDto", loginDto);
			}
			responseText = "yes";
		} else {
			responseText = "no";
		}
		
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(responseText);
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
