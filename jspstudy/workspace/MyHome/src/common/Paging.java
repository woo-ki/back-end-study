package common;

public class Paging {
	
	// 매개변수들은 ListCommand에게서 받아오는 데이터이다
	// 1. String path;			// 어떤 게시판에서 사용할 페이징인가? 예) /MyHome/bbsListPage.bbs 또는 /MyHome/boardListPage.board 등
	// 2. int totalRecord;		// 전체 게시물의 개수
	// 3. int recordPerPage;	// 한 페이지당 표시될 게시물 개수 (게시판마다 한 페이지에 표기되는 게시글의 갯수를 다르게 설정하기 위해 받아온다)
	// 4. int page;				// 현재 페이지 번호
	
	public static String getPaging(String path, int totalRecord, int recordPerPage, int page) {
		
		// 게시물: record
		// 페이지: page
		// 블록  : block
		
		
		// 전체 페이지 개수는 받아오지 않고 스스로 계산한다.
		int totalPage;		// 전체 페이지의 개수
		totalPage = totalRecord / recordPerPage;
		if(totalRecord % recordPerPage != 0) {
			totalPage += 1;
		}
		totalPage = (totalPage > page) ? totalPage : page;
		
		/* ListCommand에서 필요하다 */
		/*
		int beginRecord = 0;	// 한 페이지에 표시되는 시작 게시물의 번호
		int endRecord = 0;		// 한 페이지에 표시되는 종료 게시물의 번호
		*/
		
		// 페이지 5개를 한 블록에 배치
		int pagePerBlock = 5;	// 한 블록당 페이지 5개
		int beginPage = 0;		// 한 블록에 표시되는 시작 페이지의 번호
		int endPage = 0;		// 한 블록에 표시되는 종료 페이지의 번호
		beginPage = ((page - 1) / pagePerBlock) * pagePerBlock + 1;
		endPage = beginPage + pagePerBlock - 1;
		endPage = endPage < totalPage ? endPage : totalPage;
		
		// 페이징 (< 1 2 3 4 5 >) 만들기
		StringBuffer sb = new StringBuffer();
		if(beginPage <= pagePerBlock) {
			sb.append("<i class=\"far fa-caret-square-left\"></i>&nbsp;");
		} else {
			if(path.indexOf("?") > 0) {	// 경로에 ?가 있을 떄 ( 파라미터가 있을 때)
				sb.append("<a href=\"" + path + "&page=" + (beginPage - 1) + "\"><i class=\"far fa-caret-square-left\"></i>&nbsp;</a>");
			} else { 	// 경로에 ?가 없을 떄 ( 파라미터가 없을 때)
				sb.append("<a href=\"" + path + "?page=" + (beginPage - 1) + "\"><i class=\"far fa-caret-square-left\"></i>&nbsp;</a>");
			}
		}
		for(int p = beginPage; p <= endPage; p++) {
			if(p == page) {
				sb.append("<span class=\"disable\">" + p + "&nbsp;</span>");
			} else {
				if(path.indexOf("?") > 0) {	// 경로에 ?가 있을 떄 ( 파라미터가 있을 때)
					sb.append("<a href=\"" + path + "&page=" + p + "\">" + p + "&nbsp;</a>");
				} else { 	// 경로에 ?가 없을 떄 ( 파라미터가 없을 때)
					sb.append("<a href=\"" + path + "?page=" + p + "\">" + p + "&nbsp;</a>");
				}
			}
		}
		if(endPage >= totalPage) {
			sb.append("<i class=\"far fa-caret-square-right\"></i>");
		} else {
			if(path.indexOf("?") > 0) {	// 경로에 ?가 있을 떄 ( 파라미터가 있을 때)
				sb.append("<a href=\"/" + path + "&page=" + (endPage + 1) + "\"><i class=\"far fa-caret-square-right\"></i></a>");
			} else { 	// 경로에 ?가 없을 떄 ( 파라미터가 없을 때)
				sb.append("<a href=\"/" + path + "?page=" + (endPage + 1) + "\"><i class=\"far fa-caret-square-right\"></i></a>");
			}
		}
		
		return sb.toString();
	}
	
}