/**
 * 
 */
package com.quickxo.controllers.commands.classes;

import java.sql.DatabaseMetaData;

/**
 * @author admin
 *
 */
public class DbCheckBean {
	
	private String dbName;	
	private String driverName;	
	private String driverVersion;	
	private String dbUrl;	
	private String[] tableNames;

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDriverVersion() {
		return driverVersion;
	}

	public void setDriverVersion(String driverVersion) {
		this.driverVersion = driverVersion;
	}

	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	public String[] getTableNames() {
		return tableNames;
	}

	public void setTableNames(String[] tableNames) {
		this.tableNames = tableNames;
	}
}
