package cn.pbx.springframework.test;

import cn.hutool.core.io.IoUtil;
import cn.pbx.springframework.beans.Car;
import cn.pbx.springframework.beans.Person;
import cn.pbx.springframework.beans.PropertyValue;
import cn.pbx.springframework.beans.PropertyValues;
import cn.pbx.springframework.beans.factory.config.BeanDefinition;
import cn.pbx.springframework.beans.factory.config.BeanReference;
import cn.pbx.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.pbx.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import cn.pbx.springframework.core.io.DefaultResourceLoader;
import cn.pbx.springframework.core.io.Resource;
import cn.pbx.springframework.hook.CustomBeanFactoryPostProcessor;
import cn.pbx.springframework.hook.CustomerBeanPostProcessor;
import cn.pbx.springframework.service.HelloService;

import java.io.IOException;
import java.io.InputStream;

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

    @org.junit.Test
    public void testResource() throws IOException {
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();

        //加载classpath下的资源
        Resource resource = resourceLoader.getResource("classpath:hello.txt");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);

        //加载文件系统资源
        resource = resourceLoader.getResource("src/test/resources/hello.txt");
        inputStream = resource.getInputStream();
        content = IoUtil.readUtf8(inputStream);
        System.out.println(content);

        //加载url资源
        resource = resourceLoader.getResource("https://www.baidu.com");
        inputStream = resource.getInputStream();
        content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
    }

    @org.junit.Test
    public void testXml() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions("classpath:spring.xml");

        Person person = beanFactory.getBean("person", Person.class);
        System.out.println(person);

        Car car = beanFactory.getBean("car", Car.class);
        System.out.println(car);
    }

    @org.junit.Test
    public void beanHook1() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions("classpath:spring.xml");

        //在所有BeanDefintion加载完成后，但在bean实例化之前，修改BeanDefinition的属性值
        CustomBeanFactoryPostProcessor beanFactoryPostProcessor = new CustomBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

        Person person = (Person) beanFactory.getBean("person");
        System.out.println("===================");
        System.out.println(person);
        // name属性在CustomBeanFactoryPostProcessor中被修改为ivy
    }

    @org.junit.Test
    public void beanHook2() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions("classpath:spring.xml");

        //添加bean实例化后的处理器
        CustomerBeanPostProcessor customerBeanPostProcessor = new CustomerBeanPostProcessor();
        beanFactory.addBeanPostProcessor(customerBeanPostProcessor);

        Car car = (Car) beanFactory.getBean("car");
        System.out.println("===================");
        System.out.println(car);
        //brand属性在CustomerBeanPostProcessor中被修改为lamborghini

    }

}
