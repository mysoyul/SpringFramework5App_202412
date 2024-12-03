package myspring.di.annot.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.jupiter.api.Assertions.*;

import myspring.di.annot.HelloBean;
import myspring.di.annot.HelloBeanCons;
import myspring.di.annot.PrinterBean;

@ExtendWith(SpringExtension.class)
//Spring-Test의 AnnotationConfigContextLoader는 AnnotationConfigApplicationContext 컨테이너를 로드 해주는 역할
@ContextConfiguration(classes = HelloBeanConfig.class, loader = AnnotationConfigContextLoader.class)
public class HelloBeanConfigTest {
	@Autowired
	HelloBean hello;
	
	@Autowired
	HelloBeanCons helloCons;
	
	@Autowired
	PrinterBean printer; 
	
	@Test
	void helloCons() {
		assertEquals("Hello 어노테이션Cons", helloCons.sayHello());
		helloCons.print();
		assertEquals("Hello 어노테이션Cons", printer.toString());
	}
	
	@Test
	void helloConfig() {
		assertEquals("Hello 어노테이션", hello.sayHello());
	}
	
	
}
