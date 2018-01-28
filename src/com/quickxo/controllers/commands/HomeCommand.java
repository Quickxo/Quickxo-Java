/**
 * 
 */
package com.quickxo.controllers.commands;

import java.io.IOException;
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
		
		try {
			d.forward(request,response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
