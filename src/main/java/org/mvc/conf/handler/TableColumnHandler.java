package org.mvc.conf.handler;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.mvc.api.TableColumnApi;
import org.mvc.conf.PropertyFactory;
import org.mvc.exception.InvaildPropertiesException;
import org.mvc.poet.PoetApply;
import org.mvc.util.StringUtils;

public class TableColumnHandler implements TableColumnApi {

	private Connection connection;
	private PropertyFactory factory;
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
			DatabaseMetaData schemas = connection.getMetaData();
			ResultSet resultTable = schemas.getTables(factory.getProperty("database.name"), null, "%", null);
			// get all the table name
			while (resultTable.next()) {
				tableNames.add(resultTable.getString(3));
			}
			for (Iterator iterator = tableNames.iterator(); iterator.hasNext();) {
				String table = (String) iterator.next();
				parseColumn(table);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void parseColumn(String table) {
		try {
			DatabaseMetaData schemas = connection.getMetaData();
			ResultSet resultColumn = schemas.getColumns(null, null, "export", "%");
			 List<String> coulmns = new ArrayList<String>();
			while (resultColumn.next()) {
				 coulmns.add(resultColumn.getString(4));
				String column = resultColumn.getString(4);
//				System.out.println(resultColumn.getString(4));
//				System.out.println(resultColumn.getRow());
//				 resolveColumn(table,column);
			}
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
	public void parseColumnType() {

	}

	@Override
	public void parseSchema(Connection connection, PropertyFactory factory) {
		this.connection = connection;
		this.factory = factory;
		try {
			parseTable();
		} catch (InvaildPropertiesException e) {
			e.printStackTrace();
		}
	}

}
