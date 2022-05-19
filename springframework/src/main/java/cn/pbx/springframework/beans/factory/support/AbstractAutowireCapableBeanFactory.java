package cn.pbx.springframework.beans.factory.support;

import cn.pbx.springframework.beans.BeansException;
import cn.pbx.springframework.beans.PropertyValue;
import cn.pbx.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Field;

/**
 * @author BruceXu
 * @date 2022/5/17
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        return doCreateBean(beanName, beanDefinition);
    }

    protected Object doCreateBean(String beanName, BeanDefinition beanDefinition) {
        Object bean = null;
        try {
            // 创建bean实例
            bean = createBeanInstance(beanDefinition);
            // 填充bean的属性
            applyPropertyValues(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        addSingleton(beanName, bean);
        return bean;
    }

    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues()) {
            try {
                // 通过反射填充属性
                Class beanClass = beanDefinition.getBeanClass();
                Field field = beanClass.getDeclaredField(propertyValue.getName());
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
                field.set(bean, propertyValue.getValue());
            } catch (Exception e) {
                throw new BeansException("Error setting property values for bean: " + beanName, e);
            }
        }
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition) {
        return getInstantiationStrategy().instantiate(beanDefinition);
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }

}
