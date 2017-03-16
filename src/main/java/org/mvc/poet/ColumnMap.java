package org.mvc.poet;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.JDBCType;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.mvc.conf.TableDesc;
import org.mvc.util.StringUtils;

public class ColumnMap {
	static Map<String, String> columnMap = new HashMap<String, String>();
	static {
		columnMap.put("array", JDBCType.ARRAY.getName());
	}

	public static Class<?> resolveColumnType(TableDesc tableDesc) {
		int len = StringUtils.cutSingure(tableDesc.getColumnLen());
		switch (tableDesc.getColumnType()) {
		case "bit":
			if (len > 1 && len <= 8) {
				return byte.class;
			} else if (len > 8 && len <= 16) {
				return short.class;
			} else if (len > 16 && len <= 32) {
				return Integer.class;
			} else if (len > 32 && len <= 64) {
				return long.class;
			} else {
				return boolean.class;
			}
		case "tinyint":
			if (len == 1) {
				return boolean.class;
			}
			return boolean.class;
		case "smallint":
			return short.class;
		case "int":
			if (len == 1) {
				return boolean.class;
			}
			return Integer.class;
		case "bigint":
			return long.class;
		case "float":
			return float.class;
		case "double":
			return double.class;
		case "decimal":
			return BigDecimal.class;
		case "numeric":
			return BigInteger.class;
		case "date":
			return Date.class;
		case "datetime":
			return Date.class;
		case "time":
			return Date.class;
		case "timestamp":
			return Date.class;
		default:
			return String.class;
		}
	}
}
