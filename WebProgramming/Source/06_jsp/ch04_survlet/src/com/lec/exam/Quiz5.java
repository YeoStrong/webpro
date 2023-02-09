package com.lec.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Quiz5
 */
@WebServlet("/Quiz5")
public class Quiz5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Quiz5() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		PrintWriter out = response.getWriter(); // 스트림 생성
		out.print("<html>");
		out.print("<head>");
		out.print("<link href=\"css/quiz5.css\" rel=\"stylesheet\" type=\"text/css\" >");
		out.print("</head>");
		out.print("<body>");
		out.print("<table>");
		out.print("<tr>");
		out.print("<th colspan=\"2\">반갑습니다 " + writer + "님</th>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<th>글제목</th>");
		out.print("<td>" + title + "</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<th>글내용</th>");
		out.print("<td>" + content + "</td>");
		out.print("</tr>");
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
		out.close();
	}

}
