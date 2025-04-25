package myspring.di.xml;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-user-di.xml")
public class HelloBeanSpringTest {
	@Autowired
	Hello hello;

	@Autowired
	@Qualifier("helloC")
	Hello hello2;
	
	@Resource(name = "helloC")
	Hello hello3;
	
	@Test
	void hello() {
		System.out.println("@Autowird id=hello Bean " + hello.sayHello());
		System.out.println("@Autowird id=helloC Bean " + hello2.sayHello());
		System.out.println("@Resource id=helloC Bean " + hello3.sayHello());
		
		hello3.print();
	}
	
}
