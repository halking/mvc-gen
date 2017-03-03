package org.mvc.conf.handler;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.mvc.api.TableColumnApi;
import org.mvc.conf.PropertyFactory;
import org.mvc.exception.InvaildPropertiesException;
import org.mvc.poet.PoetApply;
import org.mvc.util.JdbcUtil;
import org.mvc.util.StringUtils;

public class TableColumnHandler implements TableColumnApi {

	private Connection connection;
	private PropertyFactory factory;
	private DatabaseMetaData schemas;
	private List<String> tableNames = new ArrayList<String>();
	private boolean tableFlag = true;

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public void parseTable() throws InvaildPropertiesException {
		if (factory.getProperties() == null) {
			throw new InvaildPropertiesException("properties must be not null!");
		}
		try {
			ResultSet resultSet = schemas.getTables(factory.getProperty("database.name"), null, "%", null);
			// get all the table name
			while (resultSet.next()) {
				tableNames.add(resultSet.getString(3));
			}
			for (Iterator iterator = tableNames.iterator(); iterator.hasNext();) {
				String table = (String) iterator.next();
				parseColumn(table);
			}
			JdbcUtil.close(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void parseColumn(String table) {
		try {
			ResultSet resultSet = schemas.getColumns(factory.getProperty("database.name"), null, table, "%");
			List<String> coulmns = new ArrayList<String>();
			while (resultSet.next()) {
				coulmns.add(resultSet.getString(4));
			}
			parseColumnType(table);
			resolveColumn(table,coulmns);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void resolveColumn(String table, List<String> coulmns) {
		if (StringUtils.isNotEmpty(table)) {
			table = StringUtils.letterUpper(table);
			PoetApply.buildEntity(table, coulmns);
		}
	}

	@Override
	public void parseColumnType(String table) {
		ResultSet resultSet =null;
		try {
			StringBuilder builder = new StringBuilder();
			builder.append("SELECT DATA_TYPE FROM `COLUMNS` WHERE TABLE_SCHEMA=").append("'").append(factory.getProperty("database.name"))
					.append("'").append(" AND TABLE_NAME=").append("'").append(table).append("';");
			PreparedStatement statement = connection.prepareStatement(builder.toString());
			statement.executeQuery();
			resultSet = statement.getResultSet();
			ResultSetMetaData metaData = resultSet.getMetaData();
			int total = metaData.getColumnCount();
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.close(resultSet);
		}
	}

	@Override
	public void parseSchema(Connection connection, PropertyFactory factory) {
		this.connection = connection;
		this.factory = factory;
		try {
			this.schemas = connection.getMetaData();
			parseTable();
		} catch (InvaildPropertiesException e) {
			e.printStackTrace();
		} catch (SQLException e) {

		}
	}

}
