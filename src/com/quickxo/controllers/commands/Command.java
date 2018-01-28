/**
 * 
 */
package com.quickxo.controllers.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Gilles Dumoulin
 *
 */
public interface Command {
	
	public void execute(HttpServletRequest request, HttpServletResponse response);

}
