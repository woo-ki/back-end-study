package command.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.PathNRedirect;
import dao.BoardDao;
import dto.BoardDto;

public class ReplyInsertCommand implements BoardCommand {

	@Override
	public PathNRedirect execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String page = request.getParameter("page");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		String mId = request.getParameter("mId");
		String bIp = request.getRemoteAddr();
		String strbNo = request.getParameter("bNo");
		int bNo = 0;
		if(strbNo != null && !strbNo.isEmpty()) {
			bNo = Integer.parseInt(strbNo);
		}
		
		// 댓글이 달릴 게시글의 정보 가져오기
		BoardDto boardDto = BoardDao.getInstance().boardView(bNo);

		BoardDao.getInstance().replyUpdatebGroupOrd(boardDto);
		
		// 댓글 만들기
		BoardDto replyDto = new BoardDto();
		replyDto.setbTitle(bTitle);
		replyDto.setbContent(bContent);
		replyDto.setmId(mId);
		replyDto.setbIp(bIp);
		replyDto.setbGroup(boardDto.getbGroup());
		replyDto.setbGroupOrd(boardDto.getbGroupOrd() + 1);
		replyDto.setbDepth(boardDto.getbDepth() + 1);
		
		// 댓글 삽입
		int result = BoardDao.getInstance().replyInsert(replyDto);
		
		// 기존에 달린 댓글들의 bGroupOrd 를 모두 1씩 증가시킨다.
		// (가장 먼저 달린 댓글의 bGroupOrd값이 가장 크다)
		// 기존에 달린 댓글: bGroup이 같고, bGroupOrd가 0이 아닌(bDepth가 0이 아닌) 게시글
		if (result > 0) {
		}
		
		PathNRedirect pathNRedirect = new PathNRedirect();
		pathNRedirect.setPath("board/replyInsertResult.jsp?result=" + result + "&page=" + page);
		pathNRedirect.setRedirect(true);
		return pathNRedirect;
	}

}
