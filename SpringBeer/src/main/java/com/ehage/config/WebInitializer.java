package com.ehage.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
	}
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { SpringRootConfiguration.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { SpringWebConfiguration.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };	
	}	
	
//	@Override
//	protected void customizeRegistration(Dynamic registration) {
//		registration.setMultipartConfig(
//				new MultipartConfigElement(
//						"/tmp/beerme/uploads",
//						2097152, 4194304, 0));		
//	}
//
//	@Override
//	protected Filter[] getServletFilters() {
//		// put filters in this array as "new MyFilter()"
//		//automatically mapped to DispatcherServlet
//		return new Filter[] {};
//	}
	
}
