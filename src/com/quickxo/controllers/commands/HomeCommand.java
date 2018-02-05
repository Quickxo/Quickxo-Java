/**
 * 
 */
package com.quickxo.controllers.commands;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.quickxo.controllers.commands.classes.DbCheckBean;
import com.quickxo.models.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author admin
 *
 */
public class HomeCommand implements Command {

	/* (non-Javadoc)
	 * @see com.quickxo.controllers.commands.Command#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher d = request.getRequestDispatcher("/homeView.jsp");
		
		Connection conn = Db.getInstance();
		if (conn != null)
		{
			try {				
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				DbCheckBean dBBean = new DbCheckBean();
				dBBean.setDbName(dm.getURL().substring(dm.getURL().lastIndexOf("/") + 1));
				dBBean.setDriverName(dm.getDriverName());
				dBBean.setDriverVersion(dm.getDriverVersion());
				dBBean.setDbUrl(dm.getURL());
				String sql = "SELECT tbl_name FROM sqlite_master WHERE type = 'table' order by tbl_name;";
				Statement stmt  = conn.createStatement();
				ResultSet rs    = stmt.executeQuery(sql);
				ArrayList<String> tableNames = new ArrayList<String>();			
	            while (rs.next()) {
	            	tableNames.add(rs.getString("tbl_name"));
	            }
	            String[] tableNamesArr = new String[tableNames.size()];
	            tableNamesArr = tableNames.toArray(tableNamesArr);
	            dBBean.setTableNames(tableNamesArr);
				Db.closeInstance();	
				request.setAttribute("dBBean", dBBean);  
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		else{
			System.out.println("Cannot connect to the database");
		}
		
		try {
			d.forward(request,response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
