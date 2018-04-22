package com.gyl;

import java.util.Map;

import org.json.JSONException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// RestController=Controller+ResponseBody
@EnableTransactionManagement
@RestController
@SpringBootApplication
public class JxcApplication {

	public static void main(String[] args) {
		SpringApplication.run(JxcApplication.class, args);
	}
	
//	 @Bean
//	    public MessageSource messageSource() {
//	        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//	       // messageSource.setBasename("classpath:messages");
//	        messageSource.setDefaultEncoding("UTF-8");
//	        return messageSource;
//	    }
//
//	    @Bean
//	    public LocalValidatorFactoryBean validator() {
//	        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
//	        bean.setValidationMessageSource(messageSource());
//	        return bean;
//	    }
	
	@RequestMapping("/hello")
	public String hello() {
		return "hello world";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestBody Map<String,Object> reqMap) throws JSONException {
		String rs=reqMap.get("code").toString();
		return rs;
	}
}
