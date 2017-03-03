package org.mvc.util;

import java.io.File;
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
	
	public static void main(String[] args) {
		String sql = "select * from sys_role where 1";
		PropertyFactory factory = new PropertyFactory();
		String root = System.getProperty("user.dir");
		File file = new File(root + "/src/main/java/baseconf.properties");
		try {
			factory.parseConfiguration(file);
			/*Properties properties = factory.getProperties();
			System.out.println(properties);
			Connection connection = getConnection();
			PreparedStatement pstmt = connection.prepareStatement(sql);
			DatabaseMetaData metaData = connection.getMetaData();			
			ResultSet resultSet = metaData.getColumns(properties.getProperty("database.name"), null, null, "%");
     		ResultSet resultSet = metaData.getTables(properties.getProperty("database.name"), null, "%", null);
			while(resultSet.next()) {
				System.out.println(resultSet.getString(3));
			}*/
			} catch (Exception e) {
			e.printStackTrace();
			}
	}

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
