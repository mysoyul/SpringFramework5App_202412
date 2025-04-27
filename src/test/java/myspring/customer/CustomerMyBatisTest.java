package myspring.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import mylab.customer.dao.mapper.CustomerMapper;
import mylab.customer.service.CustomerService;
import mylab.customer.vo.CustomerVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:spring-beans.xml","classpath:mylab-customer-mybatis.xml"})
public class CustomerMyBatisTest {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	CustomerMapper customerMapper;
	
	@Autowired
	CustomerService customerService;
	
	@Test
	public void dataSourceTest(){
		System.out.println(dataSource.getClass().getName());
	}

	@Test
	public void sqlSessionFactoryTest(){
		System.out.println(sqlSessionFactory.getClass().getName());
		System.out.println(sqlSessionFactory.getConfiguration());
	}
	
	@Test @Disabled
	public void insert() {
		customerService.insertCustomer(
				new CustomerVO("spring@aa.com", "스프링", 15));
		customerService.insertCustomer(
				new CustomerVO("spring2@aa.com", "스프링2", 20));
	}
	
	
	@Test  @Disabled
	public void sqlSessionTest(){
		System.out.println(sqlSession.getClass().getName());
		List<CustomerVO> list = 
				sqlSession.selectList("myspring.customer.dao.mapper.CustomerMapper.selectAllCustomer");
		System.out.println("sqlSessionTest : "+list);
	}
	
	@Test //@Disabled
	public void customerMapperTest(){
		CustomerVO customer = 
				customerMapper.selectCustomerByEmail("spring@aa.com");
		System.out.println(customer);
		assertEquals("스프링", customer.getName());
	}
	
	@Test //@Disabled
	public void customerServiceTest(){
		List<CustomerVO> list = customerService.getAllCustomerList();
		list.forEach(customer -> System.out.println(customer));
	}
}
