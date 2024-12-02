package myspring.di.annot.config;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@ExtendWith(SpringExtension.class)
//Spring-Test의 AnnotationConfigContextLoader는 AnnotationConfigApplicationContext 컨테이너를 로드해주는 역할
@ContextConfiguration(classes = HelloBeanConfig.class, loader = AnnotationConfigContextLoader.class)
public class HelloBeanConfigTest {

}
