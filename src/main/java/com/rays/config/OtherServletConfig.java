package com.rays.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.rays.common.Log;

/**
 * 其他 servlet filter listener 等的配置
 * @author rays1
 *
 */
@Order(2)
public class OtherServletConfig implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        
//        DispatcherServlet ds = new DispatcherServlet();
//        ServletRegistration.Dynamic servlet = servletContext.addServlet("appServlet", ds);
//        
//        servlet.addMapping("/");
//        servlet.setMultipartConfig(new MultipartConfigElement("D:\\testDirectory\\app_upload"));
        
        Log.p("加载其他配置");
        
        FilterRegistration.Dynamic filter = servletContext.addFilter("CharacterEncodingFilter", CharacterEncodingFilter.class);
        filter.setInitParameter("encoding", "utf-8");
        filter.addMappingForUrlPatterns(null, false, "*");
        
    }

}
