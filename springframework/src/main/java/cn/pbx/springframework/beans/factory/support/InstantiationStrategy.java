package cn.pbx.springframework.beans.factory.support;

import cn.pbx.springframework.beans.BeansException;
import cn.pbx.springframework.beans.factory.config.BeanDefinition;

/**
 * bean实例化策略，cglib还是jdk反射
 *
 * @author BruceXu
 * @date 2022/5/19
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition) throws BeansException;

}
