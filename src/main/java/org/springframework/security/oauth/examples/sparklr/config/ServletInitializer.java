package org.springframework.security.oauth.examples.sparklr.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.security.oauth.examples.sparklr.service.ServicesConfig;
import org.springframework.security.oauth.examples.sparklr.web.AuthServerConfig;
import org.springframework.security.oauth.examples.sparklr.web.SecurityConfig;
import org.springframework.security.oauth.examples.sparklr.web.WebConfig;
import org.springframework.util.ClassUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

public class ServletInitializer extends AbstractDispatcherServletInitializer {

	@Override
	protected WebApplicationContext createServletApplicationContext() {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.scan(ClassUtils.getPackageName(getClass()));
		Class<?>[] configClasses = getServletConfigClasses();
		context.register(configClasses);
		return context;
	}

	private Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfig.class, SecurityConfig.class, AuthServerConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected WebApplicationContext createRootApplicationContext() {
		Class<?>[] configClasses = getRootConfigClasses();
		AnnotationConfigWebApplicationContext rootAppContext = new AnnotationConfigWebApplicationContext();
		rootAppContext.register(configClasses);
		return rootAppContext;
	}

	private Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { ServicesConfig.class };
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
		registerProxyFilter(servletContext, "springSecurityFilterChain");
	}

	private void registerProxyFilter(ServletContext servletContext, String name) {
		DelegatingFilterProxy filter = new DelegatingFilterProxy(name);
		filter.setContextAttribute("org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcher");
		servletContext.addFilter(name, filter).addMappingForUrlPatterns(null, false, "/*");
	}
}
