package cn.pbx.springframework.beans.factory.config;

import cn.pbx.springframework.beans.BeansException;
import cn.pbx.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * @author BruceXu
 * @date 2022/5/25
 */
public interface BeanFactoryPostProcessor {

    /**
     * 在所有BeanDefintion加载完成后，但在bean实例化之前，提供修改BeanDefinition属性值的机制
     *
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;

}
