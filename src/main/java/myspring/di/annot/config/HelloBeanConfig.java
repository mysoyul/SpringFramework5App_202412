package myspring.di.annot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//나는 설정클래스 입니다.
@Configuration
//<context:component-scan base-package="myspring.di.annot" />
@ComponentScan(basePackages = {"myspring.di.annot"})
public class HelloBeanConfig {

}
