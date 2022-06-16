package com.synectiks.json.filter.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.simple.JSONObject;

import com.synectiks.json.filter.JsonFilter;

public class DbOperation {
	private static String dbUrl = "jdbc:postgresql://localhost:5432/cloudassetdb";
	private static String dbUser = "postgres"; 
	private static String dbPassword= "postgres";
	
	public static Connection getConnection(){
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            return con;
        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        return null;
    }
    
	public static void closeConnection(Connection con) {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void getData() {
		String sql="select * from catalogue ";
		PreparedStatement p = null;
		ResultSet rs = null;
		Connection con = null;
		
		try {
			con = getConnection() ;
			p =con.prepareStatement(sql);
			rs = p.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String dt = rs.getString("details");
				System.out.println(dt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(p != null) {
					p.close();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			closeConnection(con);
		}
		
	}
	
	public static void updateData(String jsonText) {
		String sql="update catalogue set details = ?::JSON ";
		PreparedStatement p = null;
		Connection con = null;
		
		try {
			con = getConnection() ;
			p =con.prepareStatement(sql);
			p.setObject(1, jsonText);
			p.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(p != null) {
					p.close();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			closeConnection(con);
		}
		
	}
	
	public static void testUpdateDb() {
		String x = "{\"test\":\"app\"}";
		JSONObject obj = JsonFilter.parseJson(x);
		updateData(obj.toJSONString());
		getData();
		
	}
}
