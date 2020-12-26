package com.lbq.genertor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ColumnInfo {

	private String columnName;
	private String dataType;
	private String typeName;
	private String columnSize;
	private String columnDef;
	private String isNullable;
	private String isAutoIncrement;
	private String remarks;
	
	public Map<Integer,String> getColumnMap(){
		Map<Integer,String> columnMap = new HashMap<Integer,String>();
		columnMap.put(0, columnName);
		typeName += columnSize != null && columnSize.length()>0 ? "(" + columnSize + ")" : "";
		columnMap.put(1, typeName);
		columnMap.put(2, columnDef);
		columnMap.put(3, isNullable);
		columnMap.put(4, isAutoIncrement);
		columnMap.put(5, remarks);
		return columnMap;
	}
	
	public List<String> getColumnList(){
		List<String> columnList = new ArrayList<String>();
		columnList.add(columnName);
		typeName += columnSize != null && columnSize.length()>0 ? "(" + columnSize + ")" : "";
		columnList.add(typeName);
		columnList.add(columnDef);
		columnList.add(isNullable);
		columnList.add(isAutoIncrement);
		columnList.add(remarks);
		return columnList;
	}
	
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getColumnSize() {
		return columnSize;
	}
	public void setColumnSize(String columnSize) {
		this.columnSize = columnSize;
	}
	public String getColumnDef() {
		return columnDef;
	}
	public void setColumnDef(String columnDef) {
		this.columnDef = columnDef;
	}
	public String getIsNullable() {
		return isNullable;
	}
	public void setIsNullable(String isNullable) {
		this.isNullable = isNullable;
	}
	public String getIsAutoIncrement() {
		return isAutoIncrement;
	}
	public void setIsAutoIncrement(String isAutoIncrement) {
		this.isAutoIncrement = isAutoIncrement;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
