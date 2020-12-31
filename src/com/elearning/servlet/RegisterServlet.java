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

import com.elearning.dao.MemberInfoDAO;
import com.elearning.dao.UserRoleInfoDAO;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(description = "Register for Student and admin users", urlPatterns = { "/register" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		System.out.println("DoProcess Method is starting here");
		
		response.setContentType("text/html");
		PrintWriter output = response.getWriter();
		String[] strParameterValue = setParameterValue(request);
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
		
		output.write(openBodyGUI());
		
		if(request.getParameter("txtFirstName") == null && request.getParameter("txtLastName") == null && request.getParameter("txtUserName") == null && request.getParameter("txtPassword") == null && request.getParameter("txtRetypePassword") == null && request.getParameter("txtDOB") == null) {
			output.write(registerFormGUI("", "", "",  "", "",status));
		}else if(!strParameterValue[2].equals(strParameterValue[3])) {
			output.write(showMessage("fail"));
			output.write(registerFormGUI(userId, strParameterValue[0], strParameterValue[1],  strParameterValue[4], strParameterValue[5],"N"));
		}else {
			if(status.equals("N")) {
//				errorMessage = new MemberInfoDAO().insertMemberInfo(strParameterValue[0], strParameterValue[1], strParameterValue[2], strParameterValue[4],  strParameterValue[5],"1","1");
				output.write(showMessage("success"));
			}
			
			if(status.equals("U")) {
//				errorMessage = new MemberInfoDAO().updateMemberInfo(userId,strParameterValue[0], strParameterValue[1], strParameterValue[2], strParameterValue[4],  strParameterValue[5],"1","1");
				output.write(showMessage("success"));
			}
			
			responseURL(errorMessage,response);
		}
		
		if(request.getParameter("hidID") != null && request.getParameter("hidStatus") != null) {
			lsResult = new MemberInfoDAO().selectMemberInfoByID(userId);
			System.err.println("Result : "+lsResult.toString());
			if(lsResult.size()>0) {
				String strTempResult = lsResult.get(0).substring(1,lsResult.get(0).indexOf("]"));
				output.write(registerFormGUI(strTempResult.split(",")[0],strTempResult.split(",")[1], strTempResult.split(",")[2],  strTempResult.split(",")[4], strTempResult.split(",")[5],status));
			}
		}
		else{
			output.write(registerFormGUI( userId, strParameterValue[0], strParameterValue[1],  strParameterValue[4], strParameterValue[5],status));
		}
		
		if(status.equals("D")) {
			errorMessage = new MemberInfoDAO().deleteMemberInfo(userId);
			
			responseURL(errorMessage,response);
		}
		
		output.write(closeBodyGUI());
		
		output.flush();
		output.close();
		
		System.out.println("DoProcess Method is ending here");
	}
	

	private void responseURL(String message,HttpServletResponse response)  throws ServletException, IOException{
		if(message.equals("success")) 
			response.sendRedirect("http://localhost:8080/elearning/memberinfolist");
		else
			response.sendRedirect("http://localhost:8080/elearning/register");
	}
	
	private String[] setParameterValue(HttpServletRequest request) {
		String[] strParameterValue = new String[6];
		if(request.getParameter("txtFirstName") != null)
			strParameterValue[0] = request.getParameter("txtFirstName");
		if(request.getParameter("txtLastName") != null)
			strParameterValue[1] = request.getParameter("txtLastName");
		if(request.getParameter("txtPassword") != null)
			strParameterValue[2] = request.getParameter("txtPassword");
		if(request.getParameter("txtRetypePassword") != null)
			strParameterValue[3] = request.getParameter("txtRetypePassword");
		if(request.getParameter("txtDOB") != null)
			strParameterValue[4] = request.getParameter("txtDOB");
		if(request.getParameter("optGender") != null)
			strParameterValue[5] = request.getParameter("optGender");
		
		return strParameterValue;
	}
	
	private String openBodyGUI() {
		System.out.println("Open Body is starting here");
		
		String gui ="";
		gui += "<!DOCTYPE html>";
		gui += "<head><title>Register</title></head>";
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
	
	private String showMessage(String messageType) {
		String gui = "";
		if(messageType.equals("fail")) {
			gui += "<div style='position:fixed;top:20%;left:25%;'>";
			gui += "<div style='color:red;'>";
			gui += "<label>Password doesn't same</label>";
			gui += "</div></div>";
		}else if(messageType.equals("success")){
			gui += "<div style='position:fixed;top:20%;left:25%;'>";
			gui += "<div style='color:green;'>";
			gui += "<label>Register Successful</label>";
			gui += "</div></div>";
		}
		return gui;
	}
	
	private String registerFormGUI(String strUserID,String strFirstName,String strLastName, String strDOB,String strGender,String butValue) {
		System.out.println("registerFormGUI Method is starting here");
		String gui ="";
		String firstName = strFirstName==null?"":strFirstName;
		String lastName = strLastName==null?"":strLastName;
		gui += "<div style='position:fixed;top:25%;left:25%;'>";
		gui += "<form method='get'>";
		gui += "<div style='margin-bottom:2px;'>";
		gui += "<input type='text' name='txtFirstName' placeholder='First name' style='width: 200%;'  value='"+firstName+"'  required />";
		gui += "</div>";
		
		gui += "<div style='margin-bottom:2px;'>";
		gui += "<input type='text' name='txtLastName' placeholder='Last name' style='width: 200%;' value='"+lastName+"' required />";
		gui += "</div>";

		gui += "<div style='margin-bottom:2px;'>";
		gui += "<input type='password' name='txtPassword' placeholder='Password' style='width: 200%;' required />";
		gui += "</div>";
		
		gui += "<div style='margin-bottom:2px;'>";
		gui += "<input type='password' name='txtRetypePassword' placeholder='Retype Password' style='width: 200%;' required />";
		gui += "</div>";
		
		gui += "<div style='margin-bottom:2px;'>";
		gui += "<label for='txtDOB'>Date of Birth</label>";
		gui += "<input type='date' name='txtDOB' placeholder='dd/mm/yyyy' style='width: 200%;' value='"+strDOB+"' required />";
		gui += "</div>";
		
		gui += "<div style='margin-bottom:2px;'>";
		gui += "<label>Gender</label>";
		gui += "<select name='optGender' value='"+strGender+"'>";
		gui += "<option value='male'>Male</option>";
		gui += "<option value='female'>Female</option>";
		gui += "</select>";
		gui += "</div>";

		gui += "<div>";
		gui += "<center>";
		if(butValue.equals("N")) {
			gui += "<input type='submit' Value='Sign Up' style='width: 203%;background:gray;height:40%'>";
		}else {
			System.out.println(butValue);
			gui += "<input type='submit' Value='Update' style='width: 203%;background:gray;height:40%'>";
		}
		gui += "";
		gui += "</center>";
		gui += "</div>";
		

		gui += "<div><input type='hidden' name='hidID' value='"+strUserID+"' /></div>";
		gui += "<div><input type='hidden' name='hidStatus' value='"+butValue+"' /></div>";
		
		gui += "</form>";
		gui += "</div>";
		
		System.out.println("registerFormGUI Method is ending here");
		return gui;
	}
}
