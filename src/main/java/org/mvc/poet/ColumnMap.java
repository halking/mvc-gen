package org.mvc.poet;

import java.sql.JDBCType;
import java.util.HashMap;
import java.util.Map;

public class ColumnMap {
	static	Map<String,String> columnMap = new  HashMap<String,String>();
	static{
		columnMap.put("array", JDBCType.ARRAY.getName());
	}
	public static Class<?> resolveColumnType(String type){
		switch (type) {
		    case "char":
		    	return String.class;	
		default:
			return String.class;
		}
	} 
}
