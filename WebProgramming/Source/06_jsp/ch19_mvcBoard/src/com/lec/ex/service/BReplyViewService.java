package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.BoardDao;
import com.lec.ex.dto.BoardDto;

public class BReplyViewService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int bid = Integer.parseInt(request.getParameter("bid")); // 원글의 글번호
		BoardDao bDao = new BoardDao();
		request.setAttribute("replyBoard", bDao.modifyView_replyView(bid)); // 원글 dto
	}

}
