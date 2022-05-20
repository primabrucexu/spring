package cn.pbx.springframework.test;

import cn.pbx.springframework.beans.Car;
import cn.pbx.springframework.beans.Person;
import cn.pbx.springframework.beans.PropertyValue;
import cn.pbx.springframework.beans.PropertyValues;
import cn.pbx.springframework.beans.factory.config.BeanDefinition;
import cn.pbx.springframework.beans.factory.config.BeanReference;
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

    @org.junit.Test
    public void testBeanProperties() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("name", "张三"));
        propertyValues.addPropertyValue(new PropertyValue("age", 2));
        BeanDefinition beanDefinition = new BeanDefinition(Person.class, propertyValues);
        beanFactory.registerBeanDefinition("person", beanDefinition);

        Person person = (Person) beanFactory.getBean("person");
        System.out.println(person);
    }

    @org.junit.Test
    public void testPopulateBeanWithBean() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 注册Car实例
        PropertyValues propertyValuesForCar = new PropertyValues();
        propertyValuesForCar.addPropertyValue(new PropertyValue("brand", "porsche"));
        BeanDefinition carBeanDefinition = new BeanDefinition(Car.class, propertyValuesForCar);
        beanFactory.registerBeanDefinition("car", carBeanDefinition);

        // 注册Person实例
        PropertyValues propertyValuesForPerson = new PropertyValues();
        propertyValuesForPerson.addPropertyValue(new PropertyValue("name", "张三"));
        propertyValuesForPerson.addPropertyValue(new PropertyValue("age", 18));

        // Person实例依赖Car实例
        propertyValuesForPerson.addPropertyValue(new PropertyValue("car", new BeanReference("car")));
        BeanDefinition beanDefinition = new BeanDefinition(Person.class, propertyValuesForPerson);
        beanFactory.registerBeanDefinition("person", beanDefinition);

        Person person = (Person) beanFactory.getBean("person");
        System.out.println(person);

    }

}
