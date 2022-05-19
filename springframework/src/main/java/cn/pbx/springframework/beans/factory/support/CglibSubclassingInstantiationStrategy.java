package cn.pbx.springframework.beans.factory.support;

import cn.pbx.springframework.beans.BeansException;
import cn.pbx.springframework.beans.factory.config.BeanDefinition;

/**
 * cglib通过字节码动态实例化bean
 *
 * @author BruceXu
 * @date 2022/5/19
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(BeanDefinition beanDefinition) throws BeansException {
        // 暂时跳过，不实现
        throw new BeansException("unsupported Instantiation Strategy CglibSubclassingInstantiationStrategy");
    }
}
