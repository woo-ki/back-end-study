package command.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.PathNRedirect;
import dao.MemberDao;
import dto.MemberDto;

public class MemberLoginCommand implements MemberCommand {

	@Override
	public PathNRedirect execute(HttpServletRequest request, HttpServletResponse response) {
		String mId = request.getParameter("mId");
		String mPw = request.getParameter("mPw");
		
		MemberDto memberDto = new MemberDto();
		memberDto.setmId(mId);
		memberDto.setmPw(mPw);
		
		// 로그인 한 회원 정보는 session에 올린다.
		MemberDto loginDto = MemberDao.getInstance().selectBymIdmPw(memberDto);
		HttpSession session = request.getSession();
		if(loginDto != null) {
			session.setAttribute("loginDto", loginDto);
		} else {
			session.setAttribute("loginDto", "");
		}

		PathNRedirect pathNRedirect = new PathNRedirect();
		pathNRedirect.setPath("member/loginResult.jsp");
		pathNRedirect.setRedirect(false);
 		return pathNRedirect;
	}

}
