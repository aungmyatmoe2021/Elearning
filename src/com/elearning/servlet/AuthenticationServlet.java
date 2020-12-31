package com.elearning.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elearning.dao.MemberInfoDAO;

/**
 * Servlet implementation class AuthenticationServlet
 */
@WebServlet("/login")
public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthenticationServlet() {
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
		// TODO Auto-generated method stub
		System.out.println("[Authentication Servlet]doPost is starting here.");
		doProcess(request, response);
		System.out.println("[Authentication Servlet]doPost is ending here.");
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[Authentication Servlet]doProcess is starting here.");
		String strUserName = "";
		String strPassword = "";
		List<String> record = new ArrayList<String>();
		HttpSession session = request.getSession();
		
		if(request.getParameter("txtUserName") != null)
			strUserName = request.getParameter("txtUserName").trim();
		if(request.getParameter("txtPassword") != null)
			strPassword = request.getParameter("txtPassword").trim();
		
		if((!(strUserName.equals(""))) && (!(strPassword.equals("")))) {
			record = new MemberInfoDAO().logInMember(strUserName, strPassword);
			if(record.size() == 1) {
				session.setAttribute("USER_NAME", strUserName);
				response.sendRedirect("/elearning/default.jsp");
			}else {
				response.sendRedirect("/elearning/default.jsp");
			}
		}
		System.out.println("[Authentication Servlet]doProcess is ending here.");
	}
}
