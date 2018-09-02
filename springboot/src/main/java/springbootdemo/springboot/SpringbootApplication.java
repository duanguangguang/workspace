package springbootdemo.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;

@ServletComponentScan
@SpringBootApplication
@EnableCaching // 启用缓存注解
public class SpringbootApplication { //implements ServletContextInitializer {
    private static Logger logger = LoggerFactory.getLogger(SpringbootApplication.class);
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        servletContext.addServlet("customServlet", new CustomServlet()).addMapping("/dodd");
//        servletContext.addFilter("customFilter", new CustomFilter())
//                .addMappingForServletNames(EnumSet.of(DispatcherType.REQUEST), true, "customServlet");
//        servletContext.addListener(new CustomListener());
//    }


//    @Bean
//    public ServletRegistrationBean servletRegistrationBean() {
//        return new ServletRegistrationBean(new CustomServlet(), "/dodd");
//    }
//
//    @Bean
//    public FilterRegistrationBean filterRegistrationBean() {
//        // servletRegistrationBean 配置的拦截的路径
//        return new FilterRegistrationBean(new CustomFilter(), servletRegistrationBean());
//    }
//
//    @Bean
//    public ServletListenerRegistrationBean<CustomListener> servletListenerRegistrationBean() {
//        return new ServletListenerRegistrationBean<CustomListener>(new CustomListener());
//    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
        logger.info("SpringbootApplication start successed>>>");
    }
}
