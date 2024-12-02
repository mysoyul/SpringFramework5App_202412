package myspring.di.xml;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

//static import
import static org.junit.jupiter.api.Assertions.*;

public class HelloBeanJunitTest {
	
	@Test
	public void helloBean() {
		//1. Container 역할을 GenericXmlApplicationContext 객체생성
		ApplicationContext context = new GenericXmlApplicationContext("classpath:spring-helloBean.xml");
		//2. Container 객체에 HelloBean을 요청하기 - Bean의 name
		Hello hello = (Hello)context.getBean("hello");
		//2-1. Container 객체에 HelloBean을 요청하기 - Bean의 name과  type
		Hello hello2 = context.getBean("hello", Hello.class);
		
		//Singleton Object 여부 확인하기 위해서 assertSame()로 주소 비교하기
		assertSame(hello, hello2);
		
	}
}
