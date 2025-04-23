package mylab.order.di.xml;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderJunitTest {
    
    @Test
    public void testShoppingCart() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        // 빈 가져오기
        ShoppingCart cart = context.getBean("shoppingCart", ShoppingCart.class);
        
        // 검증
        assertNotNull(cart);
        assertEquals(2, cart.getProducts().size());
        assertEquals("노트북", cart.getProducts().get(0).getName());
        assertEquals("스마트폰", cart.getProducts().get(1).getName());
    }
    
    @Test
    public void testOrderService() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        // 빈 가져오기
        OrderService service = context.getBean("orderService", OrderService.class);
        
        // 검증
        assertNotNull(service);
        assertNotNull(service.getShoppingCart());
        assertEquals(2300000.0, service.calculateOrderTotal(), 0.001);
    }
}