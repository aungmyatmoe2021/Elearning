package com.elearning.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("[LogoutServlet]doGet is starting here.");
		doProcess(request, response);
		System.out.println("[LogoutServlet]doGet is ending here.");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("[LogoutServlet]doPost is starting here.");
		doProcess(request, response);
		System.out.println("[LogoutServlet]doPost is ending here.");
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[LogoutServlet]doProcess is starting here.");
		HttpSession session = request.getSession();
		if(session.getAttribute("USER_NAME") != null){
			session.setAttribute("USER_NAME", null);
			response.sendRedirect("/elearning/default.jsp");
		}
		System.out.println("[LogoutServlet]doProcess is ending here.");
	}
}
