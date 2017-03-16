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
import org.mvc.conf.TableDesc;
import org.mvc.exception.InvaildPropertiesException;
import org.mvc.poet.PoetApply;
import org.mvc.util.JdbcUtil;
import org.mvc.util.StringUtils;

public class TableColumnHandler implements TableColumnApi {

	private Connection connection;
	private PropertyFactory factory;
	private DatabaseMetaData schemas;
	private List<String> tableNames = new ArrayList<String>();

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
		 List<TableDesc> tableDescs = new ArrayList<TableDesc>();
		 List<String> coulmns = new ArrayList<String>();
		try {
			ResultSet resultSet = schemas.getColumns(factory.getProperty("database.name"), null, table, "%");
			while (resultSet.next()) {
				coulmns.add(resultSet.getString(4));
			}
			tableDescs = parseColumnType(table);
			resolveColumn(table, coulmns,tableDescs);
			JdbcUtil.close(resultSet);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void resolveColumn(String table, List<String> coulmns,List<TableDesc> tableDescs) {
		if (StringUtils.isNotEmpty(table)) {
			table = StringUtils.letterUpper(table);
			PoetApply apply = new PoetApply(this.factory);
			apply.buildEntity(table, coulmns,tableDescs);
		}
	}

	@Override
	public List<TableDesc> parseColumnType(String table) {
		ResultSet resultSet = null;
		 List<TableDesc> tableDescs = new ArrayList<TableDesc>();
		try {
			StringBuilder builder = new StringBuilder();
			builder.append("SELECT * FROM `COLUMNS` WHERE TABLE_SCHEMA=").append("'").append(factory.getProperty("database.name"))
					.append("'").append(" AND TABLE_NAME=").append("'").append(table).append("';");
			PreparedStatement statement = connection.prepareStatement(builder.toString());
			statement.executeQuery();
			resultSet = statement.getResultSet();
			while (resultSet.next()) {
			TableDesc tableDesc =TableDesc.builder(resultSet.getString(4),resultSet.getString(8), resultSet.getString(16)).build();
			tableDescs.add(tableDesc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(resultSet);
		}
		return tableDescs;
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
