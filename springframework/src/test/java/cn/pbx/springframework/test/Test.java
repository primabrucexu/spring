package cn.pbx.springframework.test;

import cn.pbx.springframework.beans.factory.config.BeanDefinition;
import cn.pbx.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.pbx.springframework.service.HelloService;

/**
 * @author BruceXu
 * @date 2022/5/18
 */
public class Test {

    @org.junit.Test
    public void testBeanFactory() throws Exception {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(HelloService.class);
        beanFactory.registerBeanDefinition("helloService", beanDefinition);

        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
        helloService.sayHello();

        HelloService helloService2 = (HelloService) beanFactory.getBean("helloService");
        helloService2.sayHello();

        // 单例模式下，这两个bean应该是同一个
        System.out.println(helloService == helloService2);
    }

}
