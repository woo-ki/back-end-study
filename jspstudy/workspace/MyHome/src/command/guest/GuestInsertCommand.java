package command.guest;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.PathNRedirect;
import dao.GuestDao;
import dto.GuestDto;

public class GuestInsertCommand implements GuestCommand {

	@Override
	public PathNRedirect execute(HttpServletRequest request, HttpServletResponse response) {
		String directory = "storage";
		String realPath = request.getServletContext().getRealPath(directory);
		
		File dir = new File(realPath);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		MultipartRequest multipart = null;
		try {
			multipart = new MultipartRequest(
					request,
					realPath,
					1024 * 1024 * 30,
					"UTF-8",
					new DefaultFileRenamePolicy()
					);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String gTitle = multipart.getParameter("gTitle");
		String gWriter = multipart.getParameter("gWriter");
		String gPw = multipart.getParameter("gPw");
		String gFilename = "";
		if(multipart.getFile("gFilename") != null) {
			gFilename = multipart.getFilesystemName("gFilename");
		}
		String gContent = multipart.getParameter("gContent");
		
		GuestDto guestDto = new GuestDto();
		guestDto.setgTitle(gTitle);
		guestDto.setgWriter(gWriter);
		guestDto.setgPw(gPw);
		guestDto.setgFilename(gFilename);
		guestDto.setgContent(gContent);
		
		int result = GuestDao.getInstance().guestInsert(guestDto);
		
		PathNRedirect pathNRedirect = new PathNRedirect();
		pathNRedirect.setPath("guest/guestInsertResult.jsp?result=" + result);
		pathNRedirect.setRedirect(true);
		
		
		return pathNRedirect;
	}

}
