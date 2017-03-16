package org.mvc.conf;

public class TableDesc {

	private String schemaName;
	private String tableName;
	private String columnName;
	private String columnType;
	private String columnLen;
	private String coulmnDefault;
	private boolean nullable;
	private String comment;

	private TableDesc(Builder builder) {
		// TODO Auto-generated constructor stub
		this.schemaName = builder.schemaName;
		this.tableName = builder.tableName;
		this.columnName = builder.columnName;
		this.columnType = builder.columnType;
		this.columnLen = builder.columnLen;
		this.coulmnDefault =builder.couumnDefault;
		this.nullable = builder.nullable;
		this.comment = builder.comment;
	}

	public String getSchemaName() {
		return schemaName;
	}

	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getColumnType() {
		return columnType;
	}

	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}

	public String getColumnLen() {
		return columnLen;
	}

	public void setColumnLen(String columnLen) {
		this.columnLen = columnLen;
	}

	public String getCoulmnDefault() {
		return coulmnDefault;
	}

	public void setColumnDefault(String couumnDefault) {
		this.coulmnDefault = couumnDefault;
	}

	public boolean isNullable() {
		return nullable;
	}

	public void setNullable(boolean nullable) {
		this.nullable = nullable;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public static Builder builder(String columnName, String columnType, String columnLen) {
		return new Builder(columnName, columnType, columnLen);
	}

	public final static class Builder {
		private String schemaName;
		private String tableName;
		private String columnName;
		private String columnType;
		private String columnLen;
		private String couumnDefault;
		private boolean nullable;
		private String comment;

		private Builder(String columnName, String columnType, String columnLen) {
			this.columnName = columnName;
			this.columnType = columnType;
			this.columnLen = columnLen;
		}

		public Builder addSchemaName(String schemaName) {
			this.schemaName = schemaName;
			return this;
		}

		public Builder addCouumnDefault(String couumnDefault) {
			this.couumnDefault = couumnDefault;
			return this;
		}

		public Builder addNullable(boolean nullable) {
			this.nullable = nullable;
			return this;
		}

		public Builder addComment(String comment) {
			this.comment = comment;
			return this;
		}

		public TableDesc build() {
			return new TableDesc(this);
		}
	}
}
