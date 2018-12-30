package com.narayan.test.init;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.narayan.test.queue.service.ConsumerService;

@SpringBootApplication

@ComponentScan(basePackages = {"com.narayan.test"})
@EnableAutoConfiguration
//@EnableJpaRepositories

@EntityScan("com.narayan.test.data")
public class QueueDBUpdateApplication extends SpringBootServletInitializer  {

	  private static Logger logger = LoggerFactory.getLogger(QueueDBUpdateApplication.class);

	  @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(QueueDBUpdateApplication.class);
	    }

	  
	  public static void main(String...args) {
		  
		  ApplicationContext ctx = SpringApplication.run(QueueDBUpdateApplication.class, args);
	 
	    logger.info("Starting  Queue to DB Update application");
	    ConsumerService consmer = ctx.getBean(ConsumerService.class);
	    consmer.start();		
	  }
}

