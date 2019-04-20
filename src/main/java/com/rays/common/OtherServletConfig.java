package com.rays.common;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.filter.CharacterEncodingFilter;

/**
 * 其他 servlet filter listener 等的配置
 * @author rays1
 *
 */
public class OtherServletConfig implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        
        // 
        servletContext.addListener(ContextLoaderListener.class);
        
        FilterRegistration.Dynamic filter = servletContext.addFilter("", CharacterEncodingFilter.class);
        filter.setInitParameter("encoding", "utf-8");
        filter.addMappingForUrlPatterns(null, false, "/param");
        

    }

}
