package com.elearning.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginservlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter output = response.getWriter();

		String[] strParameterValue = setParameterValue(request);
		
		openBodyGUI();
		
		// Check the user name and password is blank or null once the page load in firsttime
		if(request.getParameter("txtUserName") == null && request.getParameter("txtPassword") == null) {
			output.write(loginFormGUI( "", ""));
		}else {
			if(strParameterValue[0].equals("aungmyatmoe2021@gmail.com")) {
				if(strParameterValue[1].equals("adminace")) {
					output.write(showMessage("successful"));
				}else {
					output.write(showMessage("fail"));
					output.write(loginFormGUI(strParameterValue[0], strParameterValue[1]));
				}
			}else {
				output.write(showMessage("fail"));
				output.write(loginFormGUI(strParameterValue[0], strParameterValue[1]));
			}
		}
		
		closeBodyGUI();
		
		output.flush();
		output.close();
	}
	
	private String[] setParameterValue(HttpServletRequest request) {
		String[] strParameterValue = new String[2];
		if(request.getParameter("txtUserName") != null)
			strParameterValue[0] = request.getParameter("txtUserName");
		if(request.getParameter("txtPassword") != null)
			strParameterValue[1] = request.getParameter("txtPassword");
		
		return strParameterValue;
	}
	

	private String showMessage(String messageType) {
		String gui = "";
		if(messageType.equals("successful")) {
			System.out.println("Successful");
			gui += "<div style='position:fixed;top:20%;left:25%;'>";
			gui += "<div style='color:green;'>";
			gui += "<label>Log In Successful</label>";
			gui += "</div></div>";
		}else if(messageType.equals("fail")){
			gui += "<div style='position:fixed;top:20%;left:25%;'>";
			gui += "<div style='color:red;'>";
			gui += "<label>User Name & Password is incorrect!</label>";
			gui += "</div></div>";
		}
		return gui;
	}
	
	private String openBodyGUI() {
		System.out.println("Open Body is starting here");
		
		String gui ="";
		gui += "<!DOCTYPE html>";
		gui += "<head><title>Log In</title></head>";
		gui += "<body>";
		
		System.out.println("Open Body is ending here");
		return gui;
	}
	
	private String closeBodyGUI() {
		System.out.println("Close Body is starting here");
		
		String gui ="";
		gui += "</body>";
		gui += "</html>";
		
		System.out.println("Close Body is ending here");
		return gui;
	}
	
	// For UI Only
	private String loginFormGUI(String strUserName, String strPassword) {
		System.out.println("Login GUI method start here");
		String gui = "";
		
		gui += "<div style='position:fixed;top:25%;left:25%;'>";
		gui += "<form method='get'>";
		gui += "<div style='width: 100%;margin-bottom:5px;'>";
		gui += "<label for='txtUserName'>User Name</label>";
		gui += "</div>";

		gui += "<div style='width: 100%;margin-bottom:5px;'>";
		gui += "<input type='text' name='txtUserName' id='txtUserName' value='"+strUserName+"'/>";
		gui += "</div>";

		gui += "<div style='width: 100%;margin-bottom:5px;'>";
		gui += "<label for='txtPassword'>Password</label>";
		gui += "</div>";

		gui += "<div style='width: 100%;margin-bottom:5px;'>";
		gui += "<input type='password' name='txtPassword' id='txtPassword' value='"+strPassword+"'/>";
		gui += "</div>";

		gui += "<div style='width: 100%;margin-bottom:5px;'>";
		gui += "<input type='submit' Value='Log In'>";
		gui += "<input type='reset' Value='Cancel'>";
		gui += "</div>";
		
		gui += "</form>";
		gui += "</div>";
		System.out.println("Login GUI method end here");
		
		return gui;
	}

}
