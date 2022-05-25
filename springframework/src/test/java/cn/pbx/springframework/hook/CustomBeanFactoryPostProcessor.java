package cn.pbx.springframework.hook;

import cn.pbx.springframework.beans.BeansException;
import cn.pbx.springframework.beans.PropertyValue;
import cn.pbx.springframework.beans.PropertyValues;
import cn.pbx.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.pbx.springframework.beans.factory.config.BeanDefinition;
import cn.pbx.springframework.beans.factory.config.BeanFactoryPostProcessor;

/**
 * @author BruceXu
 * @date 2022/5/25
 */
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition personBeanDefinition = beanFactory.getBeanDefinition("person");
        System.out.println("original beanDefinition \n" + personBeanDefinition);
        PropertyValues propertyValues = personBeanDefinition.getPropertyValues();
        //将person的name属性改为ivy
        propertyValues.addPropertyValue(new PropertyValue("name", "ivy"));
    }
}
