package com.elearning.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.elearning.util.DBConnector;

public class MemberInfoDAO {
	DBConnector connector = new DBConnector();
	public List<String> selectAllMemberInfo(){
		List<String> lsResult = new ArrayList<String>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		try {
			con = connector.getConnection();
			
			stmt= con.createStatement();
			
			rset= stmt.executeQuery("SELECT `member_id`,`firt_name`,`last_name`,`user_name`,`password`,`dob`,`gender`,`user_role_id`,`course_id` FROM `member_info`");
			
			int count=0;
			while(rset.next()) {
				List<String> lsColumn = new ArrayList<String>();
				lsColumn.add(0,rset.getString("member_id"));
				lsColumn.add(1,rset.getString("firt_name"));
				lsColumn.add(2,rset.getString("last_name"));
				lsColumn.add(3,rset.getString("user_name"));
				lsColumn.add(4,rset.getString("password"));
				lsColumn.add(5,rset.getString("dob"));
				lsColumn.add(6,rset.getString("gender"));
				lsColumn.add(7,rset.getString("user_role_id"));
				lsColumn.add(8,rset.getString("course_id"));
				
				lsResult.add(count,lsColumn.toString());
				
				count++;
			}
			System.out.println("Total Number of Member Info is : "+count);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Select Member Info Error : "+e.getMessage());
		}
		
		return lsResult;
	}
	
	public List<String> selectMemberInfoByID(String strMemberID){
		List<String> lsResult = new ArrayList<String>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		try {
			con = connector.getConnection();
			
			stmt= con.createStatement();
			
			rset= stmt.executeQuery("SELECT `member_id`,`firt_name`,`last_name`,`user_name`,`password`,`dob`,`gender`,`user_role_id`,`course_id` FROM `member_info` where `member_id`='"+strMemberID+"'");
			
			int count=0;
			while(rset.next()) {
				List<String> lsColumn = new ArrayList<String>();
				lsColumn.add(0,rset.getString("member_id"));
				lsColumn.add(1,rset.getString("firt_name"));
				lsColumn.add(2,rset.getString("last_name"));
				lsColumn.add(3,rset.getString("user_name"));
				lsColumn.add(4,rset.getString("password"));
				lsColumn.add(5,rset.getString("dob"));
				lsColumn.add(6,rset.getString("gender"));
				lsColumn.add(7,rset.getString("user_role_id"));
				lsColumn.add(8,rset.getString("course_id"));
				
				lsResult.add(count,lsColumn.toString());
				
				count++;
			}
			System.out.println("Total Number of Member Info is : "+count);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Select Member Info By ID Error : "+e.getMessage());
		}
		
		return lsResult;
	} 
	
	public String insertMemberInfo(String strFirtName,String strLastName,String strUserName,String strPassword,String strDob,String strGender,String strUserRoleId,String strCourseId) {
		String message = "fail";
		Connection con = null;
		Statement stmt = null;
		
		try {
			con = connector.getConnection();
			stmt = con.createStatement();
			int rowSet = stmt.executeUpdate("Insert into `member_info`(`member_id`,`firt_name`,`last_name`,`user_name`,`password`,`dob`,`gender`,`user_role_id`,`course_id`) values(uuid(),'"+strFirtName+"','"+strLastName+"','"+strUserName+"','"+strPassword+"','"+strDob+"','"+strGender+"','"+strUserRoleId+"','"+strCourseId+"')");
			
			if(rowSet==1) {
				message="success";
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println("Insert Member Info Error : "+e.getMessage());
		}
		return message;
	}
	
	public String updateMemberInfo(String strMemberID,String strFirtName,String strLastName,String strPassword,String strDob,String strGender,String strUserRoleId,String strCourseId) {
		String message = "fail";
		Connection con = null;
		Statement stmt = null;
		
		try {
			con = connector.getConnection();
			stmt = con.createStatement();
			int rowSet = stmt.executeUpdate("Update member_info set `firt_name`='"+strFirtName+"',`last_name`='"+strLastName+"',`password`='"+strPassword+"',`dob`='"+strDob+"',`gender`='"+strGender+"',`user_role_id`='"+strUserRoleId+"',`course_id`='"+strCourseId+"' where `member_id`='"+strMemberID+"'");
			
			if(rowSet==1) {
				message="success";
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println("update Member Info Error : "+e.getMessage());
		}
		return message;
	}
	
	public String deleteMemberInfo(String strMemberID) {
		String message = "fail";
		Connection con = null;
		Statement stmt = null;
		
		try {
			con = connector.getConnection();
			stmt = con.createStatement();
			int rowSet = stmt.executeUpdate("Delete from `member_info` where `member_id`='"+strMemberID+"'");
			
			if(rowSet==1) {
				message="success";
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println("delete Member Info Error : "+e.getMessage());
		}
		return message;
	}
	
	public List<String> logInMember(String strUserName,String strPassword){
		List<String> lsResult = new ArrayList<String>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		try {
			con = connector.getConnection();
			
			stmt= con.createStatement();
			
			rset= stmt.executeQuery("SELECT `member_id`,`firt_name`,`last_name`,`user_name`,`password`,`dob`,`gender`,`user_role_id`,`course_id` FROM `member_info` where `user_name`='"+strUserName+"' and `password`='"+strPassword+"'");
			
			int count=0;
			while(rset.next()) {
				List<String> lsColumn = new ArrayList<String>();
				lsColumn.add(0,rset.getString("member_id"));
				lsColumn.add(1,rset.getString("firt_name"));
				lsColumn.add(2,rset.getString("last_name"));
				lsColumn.add(3,rset.getString("user_name"));
				lsColumn.add(4,rset.getString("password"));
				lsColumn.add(5,rset.getString("dob"));
				lsColumn.add(6,rset.getString("gender"));
				lsColumn.add(7,rset.getString("user_role_id"));
				lsColumn.add(8,rset.getString("course_id"));
				
				lsResult.add(count,lsColumn.toString());
				
				count++;
			}
			System.out.println("Total Number of Member Info is : "+count);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Select Member Info By ID Error : "+e.getMessage());
		}
		
		return lsResult;
	} 
}
