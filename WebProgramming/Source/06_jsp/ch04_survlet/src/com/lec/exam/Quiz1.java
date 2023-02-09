package com.lec.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Quiz1
 */
@WebServlet("/Quiz1")
public class Quiz1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Quiz1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8;");
		String[] suStr = request.getParameterValues("su");
		PrintWriter out = response.getWriter(); // 스트림 생성
		out.print("<html>");
		out.print("<head>");
		out.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/quiz1.css\">");
		out.print("</head>");
		out.print("<body>");
		for(int j=0 ; j<suStr.length ; j++) {
			out.println("<h2>"+ suStr[j] +"단 구구단</h2>");
			for(int i=1 ; i<=9 ; i++) {
				out.printf("<p>%s * %d = %d </p>", suStr[j], i, Integer.parseInt(suStr[j])*i);
			}
		}
		out.print("</body>");
		out.print("</html>");
		out.close();
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
