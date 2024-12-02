package myspring.di.xml.config;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = HelloConfig.class)
public class HelloConfigTest {
	@Autowired
	Hello hello;
	
	@Autowired
	Printer strPrinter;
	
	@Autowired
	@Qualifier("helloCons")
	Hello hello2;
	
	
	@Test
	void helloCons() {
		System.out.println(hello2.sayHello());
		hello2.print();
	}
	
	@Test @Disabled
	void helloConfig() {
		System.out.println(hello.sayHello());
		hello.print();
		System.out.println(strPrinter.toString());
	}
	
	
}
