package com.elearning.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.elearning.util.DBConnector;

public class UserRoleInfoDAO {
	DBConnector connector = new DBConnector();
	public List<String> selectAllUserRoleInfo(){
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		List<String> lsUserInfo = new ArrayList<String>();
		
		try {
			con = connector.getConnection();
			
			stmt = con.createStatement();
			
			rset = stmt.executeQuery("select `user_role_id`,`user_role_name`,`user_role_desp` from `USER_ROLE_INFO`");
			
			int count = 0;
			while(rset.next()) {
				List<String> lsUserInfoColumn = new ArrayList<String>();
				lsUserInfoColumn.add(0, rset.getString("user_role_id"));
				lsUserInfoColumn.add(1, rset.getString("user_role_name"));
				lsUserInfoColumn.add(2, rset.getString("user_role_desp"));
				
				lsUserInfo.add(count,lsUserInfoColumn.toString());
				
				count++;
			}
			
			System.out.println("Total Record for User Role info : "+count);
			
			//Close All the Object here
			rset.close();
			stmt.close();
			con.close();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println("Select All User Role Info Error : "+e.getMessage());
		}
		
		return lsUserInfo;
	}
	
	public List<String> selectUserRoleInfoByID(String strUserRoleID){
		Connection con = null;
		Statement stmt = null;
		ResultSet rset = null;
		List<String> lsUserInfo = new ArrayList<String>();
		
		try {
			con = connector.getConnection();
			
			stmt = con.createStatement();
			
			rset = stmt.executeQuery("select `user_role_id`,`user_role_name`,`user_role_desp` from `USER_ROLE_INFO` where `user_role_id`='"+strUserRoleID+"'");
			
			int count = 0;
			while(rset.next()) {
				List<String> lsUserInfoColumn = new ArrayList<String>();
				lsUserInfoColumn.add(0, rset.getString("user_role_id"));
				lsUserInfoColumn.add(1, rset.getString("user_role_name"));
				lsUserInfoColumn.add(2, rset.getString("user_role_desp"));
				
				lsUserInfo.add(count,lsUserInfoColumn.toString());
				
				count++;
			}
			System.out.println("Total Record for User Role Info : "+count);
			
			//Close All the Object here
			rset.close();
			stmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
			System.err.println("Select User Role Info By ID Error : "+e.getMessage());
		}
		
		return lsUserInfo;
	}
	
	public String insertUserRoleInfo(String strUserRoleName,String strUserRoleDesp){
		Connection con = null;
		Statement stmt = null;
		String strMessage = "fail";
		
		try {
			con = connector.getConnection();
			
			stmt = con.createStatement();
			
			int rowSet = stmt.executeUpdate("Insert into `USER_ROLE_INFO`(`user_role_id`,`user_role_name`,`user_role_desp`) values (uuid(),'"+strUserRoleName+"','"+strUserRoleDesp+"')");
		
			if(rowSet == 1)
				strMessage = "success";
			
			stmt.close();
			con.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println("Insert User Role Info Error : "+e.getMessage());
		}
		
		return strMessage;
	}
	
	public String updateUserInfo(String strUserRoleId,String strUserRoleName,String strUserRoleDesp){
		Connection con = null;
		Statement stmt = null;
		String strMessage = "fail";
		
		try {
			con = connector.getConnection();
			
			stmt = con.createStatement();
			
			int rowSet = stmt.executeUpdate("Update `USER_ROLE_INFO` set `user_role_name`='"+strUserRoleName+"',`user_role_desp`='"+strUserRoleDesp+"' where `user_role_id`='"+strUserRoleId+"'");
			
			if(rowSet == 1)
				strMessage ="success";
			
			stmt.close();
			con.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println("Update User Role Info Error : "+e.getMessage());
		}
		
		return strMessage;
	}
	
	public String deleteUserInfo(String strUserRoleId){
		Connection con = null;
		Statement stmt = null;
		String strMessage = "fail";
		
		try {
			con = connector.getConnection();
			
			stmt = con.createStatement();
			
			int rowSet = stmt.executeUpdate("Delete from `USER_ROLE_INFO` where `user_role_id`='"+strUserRoleId+"'");
			
			if (rowSet==1)
					strMessage="success";
			
			stmt.close();
			con.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println("Delete User Role Info Error : "+e.getMessage());
		}
		
		return strMessage;
	}
}
