package com.lbq.genertor;

import java.util.ArrayList;
import java.util.List;

public class TableStructure {
	
	private String tableName;
	private List<String> tableHead;
	private List<ColumnInfo>  columnInfoList;
	public TableStructure() {
		tableHead = new ArrayList<String>();
		tableHead.add("字段名");
		tableHead.add("数据类型");
		tableHead.add("默认值");
		tableHead.add("允许为空");
		tableHead.add("自增");
		tableHead.add("备注");
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public List<ColumnInfo> getColumnInfoList() {
		return columnInfoList;
	}
	public void setColumnInfoList(List<ColumnInfo> columnInfoList) {
		this.columnInfoList = columnInfoList;
	}
	public List<String> getTableHead() {
		return tableHead;
	}
	public void setTableHead(List<String> tableHead) {
		this.tableHead = tableHead;
	}
}
