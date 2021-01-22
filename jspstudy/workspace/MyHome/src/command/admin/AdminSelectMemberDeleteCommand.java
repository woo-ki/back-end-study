package command.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.PathNRedirect;
import dao.AdminDao;
import dao.MemberDao;

public class AdminSelectMemberDeleteCommand implements AdminCommand {

	@Override
	public PathNRedirect execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String target = request.getParameter("target");
		String[] mNoList = target.split(",");
		String[] mIdList = new String[mNoList.length];
		String page = request.getParameter("page");
		
		for(int i = 0; i < mNoList.length; i++) {
			mIdList[i] = MemberDao.getInstance().selectBymNo(mNoList[i]).getmId();
		}
		
		int result = 0;
		for(int i = 0; i < mNoList.length; i++) {
			AdminDao.getInstance().adminMemberBoardDelete(mIdList[i]);
			int mNo = Integer.parseInt(mNoList[i]);
			result += AdminDao.getInstance().adminMemberDelete(mNo);
		}
		
		
		PathNRedirect pathNRedirect = new PathNRedirect();
		pathNRedirect.setPath("admin/adminMemberDeleteResult.jsp?result=" + (result == mNoList.length) + "&page=" + page);
		pathNRedirect.setRedirect(true);
		return pathNRedirect;
	}

}
