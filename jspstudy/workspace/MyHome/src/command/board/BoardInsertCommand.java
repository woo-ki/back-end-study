package command.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.PathNRedirect;
import dao.BoardDao;
import dto.BoardDto;

public class BoardInsertCommand implements BoardCommand {

	@Override
	public PathNRedirect execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String mId = request.getParameter("mId");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		String bIp = request.getRemoteAddr();
		
		BoardDto boardDto = new BoardDto();
		boardDto.setmId(mId);
		boardDto.setbTitle(bTitle);
		boardDto.setbContent(bContent);
		boardDto.setbIp(bIp);
		
		int result = BoardDao.getInstance().boardInsert(boardDto);
		
		PathNRedirect pathNRedirect = new PathNRedirect();
		pathNRedirect.setPath("board/boardInsertResult.jsp?result=" + result);
		pathNRedirect.setRedirect(true);
		return pathNRedirect;
	}

}
