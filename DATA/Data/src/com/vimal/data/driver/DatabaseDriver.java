package com.vimal.data.driver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseDriver {
	public static Connection connection;
	static Properties props =new Properties();
	
	public static Connection getConnection() throws IOException {
		FileInputStream fis =new FileInputStream("Config/database.properties");
		props.load(fis);
		if (connection == null) {
			String driverName = props.getProperty("drivername");
			String databaseURL = props.getProperty("url");
			String userName = props.getProperty("username");
			String password = props.getProperty("password");
			
			// step1 load the driver class
			try {
				Class.forName(driverName);

				// step2 create the connection object
				try {
					connection = DriverManager.getConnection(databaseURL,userName,
							password);
				} catch (SQLException e) {
					System.out.println("Exception in creating connection");
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				System.out.println("Exception in Classloader");
				e.printStackTrace();
			}

			return connection;
		}
		return connection;
	}

	public static void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println("Unable to close connection");
			e.printStackTrace();
		}
	}
}
