package org.mvc.api;

import java.sql.Connection;
import java.sql.ResultSet;

import org.mvc.conf.PropertyFactory;
import org.mvc.exception.InvaildPropertiesException;

public interface TableColumnApi {
		
	void parseTable() throws InvaildPropertiesException;
	
	void parseColumn(String table) ;
	
	void parseColumnType(String table);
	
	void parseSchema(Connection connection,PropertyFactory factory);
	
}
