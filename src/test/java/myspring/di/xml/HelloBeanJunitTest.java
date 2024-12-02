package myspring.di.xml;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloBeanJunitTest {
	
	@Test
	public void helloBean() {
		//1. Container 역할을 GenericXmlApplicationContext 객체생성
		ApplicationContext context = new GenericXmlApplicationContext("classpath:spring-helloBean.xml");
	
	}
}
