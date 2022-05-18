package cn.pbx.springframework.beans.factory.support;

import cn.pbx.springframework.beans.factory.config.BeanDefinition;

/**
 * 注册bean的接口
 *
 * @author BruceXu
 * @date 2022/5/17
 */
public interface BeanDefinitionRegistry {

    /**
     * 向注册表中注BeanDefinition
     *
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

}
