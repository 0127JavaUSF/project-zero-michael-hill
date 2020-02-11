package com.revature.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.account.Account;
import com.revature.utll.ConnectionUtll;
public class AccountDao {


	private Account extractAccount(ResultSet result) throws SQLException {
		int id = result.getInt("id");
		String buildName = result.getString("build_name");
		String apartmentNumber = result.getString("apartment_number");
		return new Account(id, buildName, apartmentNumber);
	}
	
	public Account getAccount(String username, String password) {
		try(Connection connection = ConnectionUtll.getConnection()) {
			String sql = "SELECT id, build_name, apartment_number FROM houses"
					+ " WHERE build_name  = ? and apartment_number = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, username);
			statement.setString(2, password);
			
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				int id = result.getInt("id");
				String buildName = result.getString("build_name");
				String apartmentNumber = result.getString("apartment_number");
				return new Account(id, buildName, apartmentNumber);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println();
			System.out.println();
		}
		return null;		
	}

	public Account createAccount(Account account) {
		try(Connection connection = ConnectionUtll.getConnection()) {
			String sql = "INSERT INTO houses (build_name, apartment_number) " +
					" VALUES (?, ?) RETURNING *";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, account.getUserName());
			statement.setString(2, account.getPassword());
			
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				return extractAccount(result);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	

	
}
