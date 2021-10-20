package com.rajwork.BootMVCDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.boot.builder.SpringApplicationBuilder; 
/*@SpringBootApplication
public class BootMvcdbApplication extends SpringBootServletInitializer  {

	@Override  
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application)   
	{  
	return application.sources(BootMvcdbApplication.class);  
	}  
	public static void main(String[] args) {
		SpringApplication.run(BootMvcdbApplication.class, args);
	}

}
*/
@SpringBootApplication
public class BootMvcdbApplication   {
	
	public static void main(String[] args) {
		SpringApplication.run(BootMvcdbApplication.class, args);
	}
	
	
	  @Bean public MessageSource messageSource() {
	  ReloadableResourceBundleMessageSource messageSource = new  ReloadableResourceBundleMessageSource();
	 messageSource.setBasename("classpath:messages");
	 messageSource.setDefaultEncoding("UTF-8"); return messageSource; }
	 

}