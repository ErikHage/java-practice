package com.tfr.scli;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.support.ErrorPageFilter;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootCliExampleApplication extends SpringBootServletInitializer {

	private static final Logger logger =
            LoggerFactory.getLogger(SpringBootCliExampleApplication.class);

    public static void main(String[] args) {
        try {
            SpringApplication.run(SpringBootCliExampleApplication.class, args);
        } catch(Exception ex) {
            logger.error("Exception occurred during execution", ex);
            throw new RuntimeException(ex);
        }
    }

//    @Bean
//    ErrorPageFilter errorPageFilter() {
//        return new ErrorPageFilter();
//    }
//
//    @Bean
//    public FilterRegistrationBean disableSpringBootErrorFilter(ErrorPageFilter filter) {
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(filter);
//        filterRegistrationBean.setEnabled(false);
//        return filterRegistrationBean;
//    }


}
