package org.mvc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;

import org.mvc.api.TableColumnApi;
import org.mvc.conf.PropertyFactory;
import org.mvc.conf.handler.TableColumnHandler;

public class JdbcUtil {
	
	static Connection connection ;
	
	static private AtomicInteger atomic = new AtomicInteger(0);
	
	public static void initialize(PropertyFactory factory) {
		try {
			Class clazz = Class.forName(factory.getProperty("jdbc.driverClassName"));
			connection = DriverManager.getConnection(factory.getProperty("jdbc.url"), factory.getProperty("jdbc.username"),
					factory.getProperty("jdbc.password"));
			TableColumnApi columnApi = new TableColumnHandler();
			columnApi.parseSchema(connection,factory);
		} catch (ClassNotFoundException ce) {
			// TODO: handle exception
			ce.printStackTrace();
		} catch (Exception se) {
			se.printStackTrace();
		}finally {
			close(getConnection());
		}
	}

	public static Connection getConnection() {
		return connection;
		
	}
	public static void close(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void close(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
