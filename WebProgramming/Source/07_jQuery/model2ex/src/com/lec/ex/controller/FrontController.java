package com.lec.ex.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.service.ALoginService;
import com.lec.ex.service.BoardContentService;
import com.lec.ex.service.BoardDeleteService;
import com.lec.ex.service.BoardListService;
import com.lec.ex.service.BoardModifyService;
import com.lec.ex.service.BoardModifyViewService;
import com.lec.ex.service.BoardReplyService;
import com.lec.ex.service.BoardReplyViewService;
import com.lec.ex.service.BoardWriteService;
import com.lec.ex.service.MAllViewService;
import com.lec.ex.service.MJoinService;
import com.lec.ex.service.MLoginService;
import com.lec.ex.service.MLogoutService;
import com.lec.ex.service.MModifyService;
import com.lec.ex.service.MWithdrawalService;
import com.lec.ex.service.MemailConfirmService;
import com.lec.ex.service.MidConfirmService;
import com.lec.ex.service.Service;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		String viewPage = null;
		Service service = null;
		if(command.equals("/main.do")) {	// 첫 화면
			viewPage = "main/main.jsp";
		// * * * * * * * * * * * * * * * * * * * * * * * 
		// * * * * * * * member 관련 요청 * * * * * * * * *
		// * * * * * * * * * * * * * * * * * * * * * * *
		}else if(command.equals("/joinView.do")) { // 회원가입 화면
			viewPage = "member/join.jsp";
		}else if(command.equals("/midConfirm.do")) {
			service = new MidConfirmService();
			service.execute(request, response);
			viewPage = "member/midConfirm.jsp";
		}else if(command.equals("/memailConfirm.do")) {
			service = new MemailConfirmService();
			service.execute(request, response);
			viewPage = "member/memailConfirm.jsp";
		}else if(command.equals("/join.do")) { // 회원가입 DB 처리
			service = new MJoinService(); // execute메소드 : mId중복체크 후 회원가입
			service.execute(request, response);
			viewPage = "member/login.jsp";
		}else if(command.equals("/loginView.do")) { // 로그인 화면
			viewPage = "member/login.jsp";
		}else if(command.equals("/login.do")) { // 로그인 DB 및 세션 처리
			service = new MLoginService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
		}else if(command.equals("/logout.do")) {//로그아웃 - 세션 날리기
			service = new MLogoutService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
		}else if(command.equals("/modifyView.do")) { // 정보 수정하기 위한 view
//			service = new MGetMemberService(); // 세션에 있는 mid로 수정할 dto 데이터를 가져오기
//			service.execute(request, response);
			viewPage = "member/modify.jsp";
		}else if(command.equals("/modify.do")) { // db에 정보 수정
			service = new MModifyService();
			service.execute(request, response);
			viewPage = "member/main.jsp";
		}else if(command.equals("/withdrawal.do")) { // 회원탈퇴
			service = new MWithdrawalService();
			service.execute(request, response);
			viewPage = "member/main.jsp";
		
		// * * * * * * * * * * * * * * * * * * * * * * * 
		// * * * * * * * admin 관련 요청   * * * * * * * * *
		// * * * * * * * * * * * * * * * * * * * * * * *
		}else if(command.equals("/adminLoginView.do")) { // 회원탈퇴
			viewPage = "admin/adminLogin.jsp";
		}else if(command.equals("/adminLogin.do")) { // 회원탈퇴
			service = new ALoginService();
			service.execute(request, response);
			viewPage = "allView.do";
		}else if(command.equals("/allView.do")) { // 회원목록 출력(페이징처리)
			service = new MAllViewService();
			service.execute(request, response);
			viewPage = "member/mAllView.jsp";
		// * * * * * * * * * * * * * * * * * * * * * * * 
		// * * * * * * * 파일첨부 게시판  관련 요청   * * * * * *
		// * * * * * * * * * * * * * * * * * * * * * * *
		}else if(command.equals("/boardWriteView.do")) { // 회원목록 출력(페이징처리)
			viewPage = "fileBoard/boardWrite.jsp";
		}else if(command.equals("/boardWrite.do")) { // 회원목록 출력(페이징처리)
			service = new BoardWriteService();
			service.execute(request, response);
			viewPage = "boardList.do";
		}else if(command.equals("/boardList.do")) { // 회원목록 출력(페이징처리)
			service = new BoardListService();
			service.execute(request, response);
			viewPage = "fileBoard/boardList.jsp";
		}else if(command.equals("/boardContent.do")) { // 회원목록 출력(페이징처리)
			service = new BoardContentService();
			service.execute(request, response);
			viewPage = "fileBoard/boardContent.jsp";
		}else if(command.equals("/boardModifyView.do")) { // 회원목록 출력(페이징처리)
			service = new BoardModifyViewService();
			service.execute(request, response);
			viewPage = "fileBoard/boardModify.jsp";
		}else if(command.equals("/boardModify.do")) { // 회원목록 출력(페이징처리)
			service = new BoardModifyService();
			service.execute(request, response);
			viewPage = "boardList.do";
		}else if(command.equals("/boardDelete.do")) { // 회원목록 출력(페이징처리)
			service = new BoardDeleteService();
			service.execute(request, response);
			viewPage = "boardList.do";
		}else if(command.equals("/boardReplyView.do")) { // 회원목록 출력(페이징처리)
			service = new BoardReplyViewService();
			service.execute(request, response);
			viewPage = "fileBoard/boardReply.jsp";
		}else if(command.equals("/boardReply.do")) { // 회원목록 출력(페이징처리)
			service = new BoardReplyService();
			service.execute(request, response);
			viewPage = "boardList.do";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
