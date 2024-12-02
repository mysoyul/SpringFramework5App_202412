package myspring.di.annot;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.Resource;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-helloBean.xml")
public class AnnotatedHelloBeanTest {
	@Autowired
	HelloBean hello;
	
	@Autowired
	PrinterBean printer;
	
	@Autowired
	@Qualifier("printer")
	PrinterBean printer2;
	
	@Resource(name="consolePrinter")
	PrinterBean conPrinter;
	
	@Test
	public void hello_conPrinter() {
		hello.setPrinter(conPrinter);
		hello.print();
		//conPrinter.print(hello.sayHello());
	}
	
	@Test
	public void hello() {
		assertEquals("Hello 어노테이션", hello.sayHello());
		hello.print();
		
		assertEquals("Hello 어노테이션", printer.toString());
		
		assertEquals("Hello 어노테이션", printer2.toString());
	}
}
