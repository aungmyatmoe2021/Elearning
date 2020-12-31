package com.elearning.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elearning.dao.UserRoleInfoDAO;

/**
 * Servlet implementation class UserInfoEntryServlet
 */
@WebServlet(description = "User Info Entry", urlPatterns = { "/userinfoentry" })
public class UserInfoEntryServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoEntryServlet() {
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
		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter output = response.getWriter();
		
		String userRoleName = "";
		String userRole = "";
		String errorMessage = "";
		String userId = "";
		String status = "N";
		List<String> lsResult = new ArrayList<String>();
		
		if(request.getParameter("hidID") != null) {
			userId = request.getParameter("hidID");
		}
		if(request.getParameter("hidStatus") != null) {
			status = request.getParameter("hidStatus");
		}
		
		if(request.getParameter("txtUserRoleName") != null && request.getParameter("txtUserRole") != null) {
			userRoleName = request.getParameter("txtUserRoleName");
			userRole = request.getParameter("txtUserRole");
			
			if(status.equals("N")) {
				errorMessage = new UserRoleInfoDAO().insertUserRoleInfo(userRoleName,userRole);
			}
			
			if(status.equals("U")) {
				errorMessage = new UserRoleInfoDAO().updateUserInfo(userId,userRoleName,userRole);
			}
			
			responseURL(errorMessage,response);
		}
		
		if(request.getParameter("hidID") != null && request.getParameter("hidStatus") != null) {
			lsResult = new UserRoleInfoDAO().selectUserRoleInfoByID(userId);
			if(lsResult.size()>0) {
				String strTempResult = lsResult.get(0).substring(1,lsResult.get(0).indexOf("]"));
				output.write(userInfoEntryGUI(userId,strTempResult.split(",")[1].trim(),strTempResult.split(",")[2].trim(),status));
			}
		}
		else{
			output.write(userInfoEntryGUI(userId,userRoleName,userRole,status));
		}
		
		if(status.equals("D")) {
			errorMessage = new UserRoleInfoDAO().deleteUserInfo(userId);
			
			responseURL(errorMessage,response);
		}
		
		output.flush();
		output.close();
	}
	
	private void responseURL(String message,HttpServletResponse response)  throws ServletException, IOException{
		if(message.equals("success")) 
			response.sendRedirect("http://localhost:8080/elearning/userinfolist");
		else
			response.sendRedirect("http://localhost:8080/elearning/userinfoentry");
	}

	private String userInfoEntryGUI(String strUserRoleID,String strUserRoleName, String strUserRole,String butValue) {
		String gui = "";
		
		gui += "<!DOCTYPE html>";
		gui += "<html>";
		gui += "<head><title>User Info List</title></head>";
		gui += "<body>";

		gui += "<div style='position:fixed;top:25%;left:25%;'>";
		gui += "<form method='get'>";
		gui += "<div style='width: 100%;margin-bottom:5px;'>";
		gui += "<label for='txtUserRoleName'>User Role Name</label>";
		gui += "</div>";

		gui += "<div style='width: 100%;margin-bottom:5px;'>";
		gui += "<input type='text' name='txtUserRoleName' id='txtUserRoleName' value='"+strUserRoleName+"'/>";
		gui += "</div>";

		gui += "<div style='width: 100%;margin-bottom:5px;'>";
		gui += "<label for='txtUserRole'>User Role</label>";
		gui += "</div>";

		gui += "<div style='width: 100%;margin-bottom:5px;'>";
		gui += "<input type='text' name='txtUserRole' id='txtUserRole' value='"+strUserRole+"'/>";
		gui += "</div>";

		gui += "<div style='width: 100%;margin-bottom:5px;'>";
		if(butValue.equals("N")) {
			System.out.println(butValue);
			gui += "<input type='submit' name='butSubmit' Value='New'>";
		}else {
			System.out.println(butValue);
			gui += "<input type='submit' name='butSubmit' Value='Update'>";
		}
		gui += "<input type='reset' Value='Cancel'>";
		gui += "</div>";
		gui += "<div><input type='hidden' name='hidID' value='"+strUserRoleID+"' /></div>";
		gui += "<div><input type='hidden' name='hidStatus' value='"+butValue+"' /></div>";
		gui += "</form>";
		gui += "</div>";
		
		gui += "</body>";
		gui += "</html>";
		
		return gui;
	}
}
