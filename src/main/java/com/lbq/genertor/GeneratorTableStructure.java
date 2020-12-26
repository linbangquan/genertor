package com.lbq.genertor;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class GeneratorTableStructure {

//	public static void main(String[] args) {
//		TableStructure table = new TableStructure();
//		List<ColumnInfo> columnInfoList = new ArrayList<ColumnInfo>();
//		ColumnInfo columnInfo = null;
//		Connection con;
//
//		String driver = "com.mysql.jdbc.Driver";
//		String url = "jdbc:mysql://localhost:3306/bsm?useSSL=false";
//		String user = "root";
//		String password = "TechSure12345";
//		try {
//			Class.forName(driver);
//			
//			con = DriverManager.getConnection(url,user,password);
//			if(!con.isClosed()) {
//				System.out.println("Successed connecting to the Database!");
//			}
//			DatabaseMetaData metaData = con.getMetaData();
//			ResultSet columns= metaData.getColumns(null, "bsm", "flow_user", "%");
//			table.setTableName("flow_user");
//			ResultSetMetaData rsmd= columns.getMetaData(); 
//			int count = rsmd.getColumnCount(); 
//			for(int i = 1; i<=count; i++) {
//				System.out.print(rsmd.getColumnName(i)); 
//				System.out.print("\t");
//			}
//			 
//			
//			while(columns.next()) {
//				columnInfo = new ColumnInfo();
//				columnInfo.setColumnName(columns.getString("COLUMN_NAME"));
//				columnInfo.setTypeName(columns.getString("TYPE_NAME"));
//				columnInfo.setDataType(columns.getString("DATA_TYPE"));
//				columnInfo.setColumnDef(columns.getString("COLUMN_DEF"));
//				columnInfo.setIsNullable(columns.getString("IS_NULLABLE"));
//				columnInfo.setColumnSize(columns.getString("COLUMN_SIZE"));
//				columnInfo.setIsAutoIncrement(columns.getString("IS_AUTOINCREMENT"));
//				columnInfo.setRemarks(columns.getString("REMARKS"));
//				columnInfoList.add(columnInfo);
//				StringBuilder sb = new StringBuilder();
//				for(int i = 1; i<=count; i++) {
//					sb.append(columns.getString(rsmd.getColumnName(i))).append("\t\t\t"); 
//				}
//				
//				System.out.println(sb.toString());
//			}
//			table.setColumnInfoList(columnInfoList);
//			List<TableStructure> tableList = new ArrayList<TableStructure>();
//			tableList.add(table);
//			Word.write2Docx(tableList);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	
	public static void main(String[] args) throws Exception {
		Connection con = getConnection();
		if(con != null) {
			long filename = System.currentTimeMillis();
			FileOutputStream out = new FileOutputStream("D:\\"+filename+".docx");
			List<TableStructure> tableList = new ArrayList<TableStructure>();
			List<String> tableNameList = new ArrayList<String>();
			tableNameList.add("flow_user");
			tableNameList.add("flowtask");
			tableNameList.add("component");
			TableStructure table = null;
			for(String tableName : tableNameList) {
				table = getTableStructure(con, tableName);
				tableList.add(table);
			}
			XWPFDocument document = Word.createWordDocx(tableList);
			document.write(out);
	        out.close();
		}
	}
	public static TableStructure getTableStructure(Connection con,String tableName) {
		TableStructure table = new TableStructure();
		try {
			DatabaseMetaData metaData = con.getMetaData();
			ResultSet columns= metaData.getColumns(null, "bsm", tableName, "%");
			table.setTableName(tableName);
			ResultSetMetaData rsmd= columns.getMetaData(); 
			int count = rsmd.getColumnCount(); 
			for(int i = 1; i<=count; i++) {
				System.out.print(rsmd.getColumnName(i)); 
				System.out.print("\t");
			}
			List<ColumnInfo> columnInfoList = new ArrayList<ColumnInfo>();
			ColumnInfo columnInfo = null; 		
			while(columns.next()) {
				columnInfo = new ColumnInfo();
				columnInfo.setColumnName(columns.getString("COLUMN_NAME"));
				columnInfo.setTypeName(columns.getString("TYPE_NAME"));
				columnInfo.setDataType(columns.getString("DATA_TYPE"));
				columnInfo.setColumnDef(columns.getString("COLUMN_DEF"));
				columnInfo.setIsNullable(columns.getString("IS_NULLABLE"));
				columnInfo.setColumnSize(columns.getString("COLUMN_SIZE"));
				columnInfo.setIsAutoIncrement(columns.getString("IS_AUTOINCREMENT"));
				columnInfo.setRemarks(columns.getString("REMARKS"));
				columnInfoList.add(columnInfo);
				
			}
			table.setColumnInfoList(columnInfoList);
		}catch(Exception e) {
			e.printStackTrace();
		}		
		return table;
	}
	
	public static Connection getConnection() {
		Connection con;

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/bsm?useSSL=false";
		String user = "root";
		String password = "TechSure12345";
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			con = DriverManager.getConnection(url,user,password);
			if(!con.isClosed()) {
				System.out.println("Successed connecting to the Database!");
				return con;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

}
