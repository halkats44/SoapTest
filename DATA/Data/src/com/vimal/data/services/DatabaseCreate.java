package com.vimal.data.services;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.vimal.data.driver.DatabaseDriver;

public class DatabaseCreate {
	public static void main(String args[]) {
		try {
			Connection connection = DatabaseDriver.getConnection();
			PreparedStatement stmt = connection.prepareStatement("insert into employee values(?, ?, ?, ?)");
			stmt.setInt(1,101);
			stmt.setString(2, "Bhatt");
			stmt.setString(3, "Delhi");
			stmt.setInt(4,4545);
			boolean recs = stmt.execute();

			System.out.println("Table Created Successfully" + recs);

		} catch (Exception e) {
			System.out.println("This is the error : "+e);
		} finally {
			DatabaseDriver.closeConnection();
		}
	}

}
