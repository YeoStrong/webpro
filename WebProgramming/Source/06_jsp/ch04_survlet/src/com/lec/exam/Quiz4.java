package com.lec.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Quiz4
 */
@WebServlet("/Quiz4")
public class Quiz4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Quiz4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8;");
		String[] colors = {"red", "orange", "yellow", "green", "blue", "navy", "purple"};
		String selColor = request.getParameter("color");
		String backColor = null;
		if(selColor=="purple") {
			backColor = "red";
		}else {
			for (int i=0 ; i<colors.length-1 ; i++) {
				if(colors[i]==selColor) {
					backColor = colors[i+1];
				}
			}
		}
		PrintWriter out = response.getWriter(); // 스트림 생성
		out.print("<html>");
		out.print("<head>");
		out.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/quiz3.css\">");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1>GET방식 요청입니다<br>글자색은" + selColor +" 배경색은 " + backColor + "</h1>");
		out.print("</body>");
		out.print("</html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8;");
		String[] colors = {"red", "orange", "yellow", "green", "blue", "navy", "purple"};
		String selColor = request.getParameter("color");
		String backColor = null;
		for (int i=0 ; i<colors.length ; i++) {
			if(colors[6]==selColor) {
				backColor = "red";
			}else if(colors[i]==selColor) {
				backColor = colors[i+1];
			}
		}
		PrintWriter out = response.getWriter(); // 스트림 생성
		out.print("<html>");
		out.print("<head>");
		out.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/quiz3.css\">");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1>POST방식 요청입니다<br>글자색은" + selColor +" 배경색은 " + backColor + "</h1>");
		out.print("</body>");
		out.print("</html>");
		out.close();
	}

}
