package cn.pbx.springframework.hook;

import cn.pbx.springframework.beans.BeansException;
import cn.pbx.springframework.beans.Car;
import cn.pbx.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author BruceXu
 * @date 2022/5/25
 */
public class CustomerBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("CustomerBeanPostProcessor#postProcessBeforeInitialization");
        System.out.println("original bean :" + bean);
        //换兰博基尼
        if ("car".equals(beanName)) {
            ((Car) bean).setBrand("lamborghini");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("CustomerBeanPostProcessor#postProcessAfterInitialization");
        System.out.println("original bean :" + bean);
        return bean;
    }
}
