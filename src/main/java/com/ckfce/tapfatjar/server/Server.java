package com.ckfce.tapfatjar.server;

import java.util.EnumSet;

import javax.servlet.DispatcherType;

import org.apache.tapestry5.TapestryFilter;
import org.eclipse.jetty.server.handler.ErrorHandler;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class Server {

	
	public static void main(String[] args) throws Exception {
		
		org.eclipse.jetty.server.Server server = new org.eclipse.jetty.server.Server(8080);
		
		final ErrorHandler errorHandler = new ErrorHandler();
        errorHandler.setServer(server);
        errorHandler.setShowStacks(false);
        server.addBean(errorHandler);
               
        server.setStopAtShutdown(true);
        server.setStopTimeout(30*1000l);
		        
        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);

        handler.setClassLoader(Thread.currentThread().getContextClassLoader());
        handler.setContextPath("/");
        handler.setInitParameter("tapestry.app-package", "com.ckfce.tapfatjar");
        
        FilterHolder filterHolder = new FilterHolder();
        filterHolder.setHeldClass(TapestryFilter.class);
        filterHolder.setName("app");
        
        handler.addFilter(filterHolder, "/*", EnumSet.of(DispatcherType.REQUEST));
        								
		server.setHandler(handler);
						 
        server.start();        
        server.join();
	}
}
