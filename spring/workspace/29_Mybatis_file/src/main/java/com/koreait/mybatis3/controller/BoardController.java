package com.koreait.mybatis3.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.koreait.mybatis3.command.BoardDeleteCommand;
import com.koreait.mybatis3.command.BoardInsertCommand;
import com.koreait.mybatis3.command.BoardListCommand;
import com.koreait.mybatis3.command.BoardViewCommand;
import com.koreait.mybatis3.command.DownloadCommand;
import com.koreait.mybatis3.command.EmailAuthCommand;

@Controller
public class BoardController {
	private SqlSession sqlSession;
	private DownloadCommand downloadCommand;
	private BoardListCommand boardListCommand;
	private BoardViewCommand boardViewCommand;
	private EmailAuthCommand emailAuthCommand;
	private BoardInsertCommand boardInsertCommand;
	private BoardDeleteCommand boardDeleteCommand;
	
	@Autowired
	public void setAll(
			SqlSession sqlSession,
			DownloadCommand downloadCommand,
			BoardListCommand boardListCommand,
			BoardViewCommand boardViewCommand,
			EmailAuthCommand emailAuthCommand,
			BoardInsertCommand boardInsertCommand,
			BoardDeleteCommand boardDeleteCommand) {
		this.sqlSession = sqlSession;
		this.downloadCommand = downloadCommand;
		this.boardListCommand = boardListCommand;
		this.boardViewCommand = boardViewCommand;
		this.emailAuthCommand = emailAuthCommand;
		this.boardInsertCommand = boardInsertCommand;
		this.boardDeleteCommand = boardDeleteCommand;
	};
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(value="boardListPage.do", method=RequestMethod.GET)
	public String boardListPage(Model model) {
		boardListCommand.execute(sqlSession, model);
		return "board/boardListPage";
	}
	
	@RequestMapping(value="boardInsertPage.do", method=RequestMethod.GET)
	public String boardInsertPage() {
		return "board/boardInsertPage";
	}

	@RequestMapping(value="boardInsert.do", method=RequestMethod.POST)
	public String boardInsert(
			MultipartHttpServletRequest multipartRequest,
			Model model) {
		// 첨부가 없을 때 파라미터 : HttpServletRequest request
		// 첨부가 있을 때 파라미터 : MultipartHttpServletRequest multipartRequest
		model.addAttribute("multipartRequest", multipartRequest);
		boardInsertCommand.execute(sqlSession, model);
		return "redirect:boardListPage.do";
	}

	@RequestMapping(value="boardViewPage.do", method=RequestMethod.GET)
	public String boardView(
			@ModelAttribute("no") int no,
			Model model) {
		boardViewCommand.execute(sqlSession, model);
		return "board/boardViewPage";
	}
	
	@RequestMapping(value="download.do", method=RequestMethod.GET)
	public void download(
			HttpServletRequest request,
			HttpServletResponse response,	// 다운로드는 response가 필요하다.
			Model model) {
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		downloadCommand.execute(sqlSession, model);
	}
	@RequestMapping(value="boardDelete.do", method=RequestMethod.POST)
	public String boardDelete(
			HttpServletRequest request,
			Model model) {
		model.addAttribute("request", request);
		boardDeleteCommand.execute(sqlSession, model);
		return "redirect:boardListPage.do";
	}
	
	// 이메일 인증
	@Autowired
	private JavaMailSender mailSender;
	
	@PostMapping(value="emailAuth.do")
	public String emailAuth(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		model.addAttribute("mailSender", mailSender);
		emailAuthCommand.execute(sqlSession, model);
		return "board/emailAuthConfirm";
	}
}
