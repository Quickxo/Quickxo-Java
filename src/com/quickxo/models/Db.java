/**
 * 
 */
package com.quickxo.models;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author admin
 *
 */
public class Db {
	
	private static Connection instance = null;
	private static String user = null;
	private static String password = null;
	
	private Db(){
	}
	
    public static Connection getInstance(){
        if(instance == null){   
			try {
				Class.forName("org.sqlite.JDBC");
			} 
			catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			try {
				ClassLoader classloader = Thread.currentThread().getContextClassLoader();
				String fullPath = "";
				try {
					fullPath = URLDecoder.decode(classloader.getResource("").getPath(), "UTF-8");
				} 
				catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				if(user == null) {
					instance = DriverManager.getConnection("JDBC:sqlite:" + fullPath + "../db/Northwind.db");
				}
				else {
					instance = DriverManager.getConnection("JDBC:sqlite:" + fullPath + "../db/Northwind.db", user, password);
				}
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
        }
        return instance;
    }		
    
    public static void closeInstance(){
        if(instance != null){   
			try {
				instance.close();
				instance = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
    }    
    
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException(); 
    }    
}
