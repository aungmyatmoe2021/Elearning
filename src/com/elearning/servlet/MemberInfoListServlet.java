package com.elearning.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elearning.dao.MemberInfoDAO;
import com.elearning.dao.UserRoleInfoDAO;

/**
 * Servlet implementation class MemberInfoListServlet
 */
@WebServlet(description = "Member Info List", urlPatterns = { "/memberinfolist" })
public class MemberInfoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInfoListServlet() {
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
		
		output.write(memberInfoListGUI(new MemberInfoDAO().selectAllMemberInfo()));
		
		output.flush();
		output.close();
	}

	
	private String memberInfoListGUI(List<String> lsMemberInfo) {
		String gui="";
		
		gui += "<!DOCTYPE html>";
		gui += "<html>";
		gui += "<head>";
		gui += "<title>User Info List</title>";
		gui += "<script type='text/javascript' src='http://localhost:8080/elearning/js/memberinfo.js'></script>";
		gui += "</head>";
		gui += "<body>";
		gui += "<form method='get' name='frmMemberInfoList'>";
		gui += "<table>";
		gui += "<tr><th>Member ID</th><th>First Name</th><th>Last Name</th><th>Password</th><th>DOB</th><th>Gender</th><th>User Role ID</th><th>Course ID</th><th colspan='2'>Action</th></tr>";
		
		for(int i=0;i<lsMemberInfo.size();i++) {
			System.out.println(lsMemberInfo.get(i));
			String strTempResult = lsMemberInfo.get(i).substring(1, lsMemberInfo.get(i).indexOf("]"));
			gui += "<tr>";
			gui += "<td>"+strTempResult.split(",")[0].trim()+"</td>";
			gui += "<td>"+strTempResult.split(",")[1].trim()+"</td>";
			gui += "<td>"+strTempResult.split(",")[2].trim()+"</td>";
			gui += "<td>"+strTempResult.split(",")[3].trim()+"</td>";
			gui += "<td>"+strTempResult.split(",")[4].trim()+"</td>";
			gui += "<td>"+strTempResult.split(",")[5].trim()+"</td>";
			gui += "<td>"+strTempResult.split(",")[6].trim()+"</td>";
			gui += "<td>"+strTempResult.split(",")[7].trim()+"</td>";
			gui += "<td><input type='button' name='butUpdate' value='Update' onclick='location.href=\"/elearning/register?hidID="+ strTempResult.split(",")[0].trim() +"&hidStatus=U\"'/></td>";
			gui += "<td><input type='button' name='butDelete' value='Delete' onclick='deleteMemberInfo("+strTempResult.split(",")[0].trim()+")' /></td>";
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
