package myspring.di.annot;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-helloBean.xml")
public class AnnotatedHelloBeanTest {
	@Autowired
	HelloBean hello;
	
	@Test
	public void hello() {
		assertEquals("Hello 어노테이션", hello.sayHello());
	}
}
