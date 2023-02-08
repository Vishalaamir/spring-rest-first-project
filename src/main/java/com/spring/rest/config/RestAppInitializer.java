package com.spring.rest.config;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class RestAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		Class [] config= {RestAppConfig.class};
		return config;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
		
	}
	

}
