package com.koreait.mybatis3.command;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;

/*
	DownloadCommand는 sqlSession을 사용하지 않기 때문에,
	BoardCommand를 구현하지 않아도 상관 없습니다.
*/

public class DownloadCommand implements BoardCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpServletResponse response = (HttpServletResponse) map.get("response");
		
		String filename = request.getParameter("filename");
		String realPath = request.getServletContext().getRealPath("resources/storage");
		
		// 업로드 할 때 파일명이 변경된 상태로 업로드가 됩니다.
		// 다운로드 할 때는 우너상복구 해주겠습니다(선택)
		
		// 원래 파일명 : abcd.jpg
		// 업로드 파일명 : abcd_12345.jpg
		int posUnderBar = filename.lastIndexOf("_");
		int posDot = filename.lastIndexOf(".");
		
		// 확장자(.jpg) : 점을 포함해서 뺍니다.
		String extension = filename.substring(posDot);
		
		// 파일명(abcd)
		String baseFilename = filename.substring(0, posUnderBar);
		
		// 다운로드 할 파일명을 만듭니다.(조립)
		String realFilename = baseFilename + extension;
		
		// 다운로드 할 파일을 준비해 둡니다.
		File file = new File(realPath, filename);
		
		// 다운로드는 파일 복사의 개이므로
		// 바이트 기반의 입출력 스트림을 준비합니다.
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			// 다운로드의 개념
			// 요청한 곳으로 파일을 복사시켜주는 "응답"의 개념;
			response.setHeader("Content-Type", MediaType.APPLICATION_OCTET_STREAM_VALUE);
			// response.setHeader("Content-Type", M"application/x-msdownload");
			response.setHeader("Content-Disposition", "attachment; filename=" + new String(URLEncoder.encode(realFilename, "utf-8")));
			response.setHeader("Content-Length", file.length() + "");;
			
			// 입력 스트림 : 다운로드 할 파일을 읽어서,
			// 출력 스트림 : 응답한다.
			
			bis = new BufferedInputStream(new FileInputStream(file));
			bos = new BufferedOutputStream(response.getOutputStream());
			
			// bis로 모두 읽어서 bos로 보내면 된다.
			// FileCopyUtils 스프링 클래스를 쓰면 편리하다.
			FileCopyUtils.copy(bis, bos);
			
			// 혹시 남아있는 출력 데이터가 있다면 모두 보내 버립니다.
			bos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bos != null) { bos.close(); }
				if(bis != null) { bis.close(); }
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
