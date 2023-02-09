package com.lec.lect;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex3_LifeCycle
 */
@WebServlet(name = "LifeCycle", urlPatterns = { "/LifeCycle" })
public class Ex3_LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	@PostConstruct
	private void postConstruct() {
		// 서블릿 객체 생성되자마자 실행
		System.out.println("Ex3_LifeCycle 서블릿 객체 생성될 때 수행 - 1");
	}
	public void init(ServletConfig config) throws ServletException {
		// 서블릿 객체가 생성될 때 실행
		System.out.println("Ex3_LifeCycle 서블릿 객체가 생성(메모리에 로드될 때)될 때 수행 - 2");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// 서블릿 객체가 소멸될 때 실행
		System.out.println("Ex3_LifeCycle 서블릿 객체가 소멸(메모리에서 사라질 때)될 때 수행 - 1");
	}
	@PreDestroy
	private void preDestroy() {
		// 서블릿 객체가 소멸되기 바로 전 실행
		System.out.println("Ex3_LifeCylce 서블릿 객체가 소멸되기 바로 전 수행 - 2");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// service 함수 : @override된 함수이며 doGet(), doPost() 실행되지 않고 service() 실행
//		response.setContentType("text/html; charset=utf-8");
//		response.getWriter().append("<h1>service() 수행</h1>");
//		System.out.println("service() 실행");
//	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().append("<h1>doGet() 수행</h1>");
		System.out.println("doGet() 실행");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().append("<h1>doPost() 수행</h1>");
		System.out.println("doPost() 실행");
	}

}
