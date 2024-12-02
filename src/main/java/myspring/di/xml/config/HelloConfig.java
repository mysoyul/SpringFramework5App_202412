package myspring.di.xml.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import myspring.di.xml.ConsolePrinter;
import myspring.di.xml.Hello;
import myspring.di.xml.Printer;
import myspring.di.xml.StringPrinter;

@Configuration
@PropertySource(value = "classpath:values.properties")
public class HelloConfig {

	@Autowired
	Environment env;
	
	@Bean
	public Printer strPrinter() {
		return new StringPrinter();
	}
	
	@Bean
	public Printer conPrinter() {
		return new ConsolePrinter();
	}
	
	@Bean
	public Hello hello() {
		Hello hello = new Hello();
		//env.getProperty("xmlName1") 스프링
		hello.setName(env.getProperty("xmlName1"));
		hello.setPrinter(strPrinter());
		return hello;
	}
	
	@Bean
	public Hello helloCons() {
		//env.getProperty("xmlName2") 생성자
		return new Hello(env.getProperty("xmlName2"), conPrinter());
	}
	
}
