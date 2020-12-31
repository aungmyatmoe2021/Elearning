package com.elearning.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elearning.dao.UserRoleInfoDAO;

/**
 * Servlet implementation class UserInfoListServlet
 */
@WebServlet(description = "User Info List", urlPatterns = { "/userinfolist" })
public class UserInfoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoListServlet() {
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
		
		output.write(userInfoListGUI(new UserRoleInfoDAO().selectAllUserRoleInfo()));
		
		output.flush();
		output.close();
	}

	
	private String userInfoListGUI(List<String> lsUserInfo) {
		String gui="";
		
		gui += "<!DOCTYPE html>";
		gui += "<html>";
		gui += "<head>";
		gui += "<title>User Info List</title>";
		gui += "<script type='text/javascript' src='http://localhost:8080/elearning/js/userinfo.js'></script>";
		gui += "</head>";
		gui += "<body>";
		gui += "<form method='get' name='frmUserInfoList'>";
		gui += "<table>";
		gui += "<tr><th>User Info ID</th><th>User Name</th><th>User Role</th><th colspan='2'>Action</th></tr>";
		
		for(int i=0;i<lsUserInfo.size();i++) {
			String strTempResult = lsUserInfo.get(i).substring(1, lsUserInfo.get(i).indexOf("]"));
			gui += "<tr>";
			gui += "<td>"+strTempResult.split(",")[0].trim()+"</td>";
			gui += "<td>"+strTempResult.split(",")[1].trim()+"</td>";
			gui += "<td>"+strTempResult.split(",")[2].trim()+"</td>";
			gui += "<td><input type='button' name='butUpdate' value='Update' onclick='location.href=\"/elearning/userinfoentry?hidID="+ strTempResult.split(",")[0].trim() +"&hidStatus=U\"'/></td>";
			gui += "<td><input type='button' name='butDelete' value='Delete' onclick='deleteUserInfo("+strTempResult.split(",")[0].trim()+")' /></td>";
			gui += "</tr>";
		}		
		gui += "<input type='hidden' name='hidID' />";
		gui += "<input type='hidden' name='hidStatus' />";
		
		gui += "</table>";
		gui += "</form>";
		gui += "</body>";
		gui += "</html>";
		
		return gui;
	}
}
