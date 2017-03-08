package org.mvc.api;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import org.mvc.conf.PropertyFactory;
import org.mvc.conf.TableDesc;
import org.mvc.exception.InvaildPropertiesException;

public interface TableColumnApi {
		
	void parseTable() throws InvaildPropertiesException;
	
	void parseColumn(String table) ;
	
	List<TableDesc> parseColumnType(String table);
	
	void parseSchema(Connection connection,PropertyFactory factory);
	
}
