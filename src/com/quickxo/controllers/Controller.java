package com.quickxo.controllers;

import com.quickxo.controllers.commands.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
    }
    
    protected void Run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Command command = null;
	    String commandParameter = request.getParameter("command");
	    
	    if(commandParameter == null || commandParameter.isEmpty()){
	    	commandParameter = "Home";
	    }
	    commandParameter = commandParameter.replaceAll("[^a-zA-Z0-9]", "");
	    commandParameter = (commandParameter == "") ? "Home" : commandParameter;
	    commandParameter = commandParameter.substring(0, 1).toUpperCase() + commandParameter.substring(1);
		try {
			command = (Command)Class.forName("com.quickxo.controllers.commands." + commandParameter + "Command").getConstructor(new Class[0]).newInstance(new Object[0]);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			try {
				command = (Command)Class.forName("com.quickxo.controllers.commands.Error404Command").getConstructor(new Class[0]).newInstance(new Object[0]);
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| SecurityException | ClassNotFoundException | InvocationTargetException 
					| NoSuchMethodException e1) {
				e1.printStackTrace();
			}
		}
		
		if (command != null) {
			command.execute(request, response);
		}
    }    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Run(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Run(request, response);
	}

}
