package cn.pbx.springframework.beans.factory;

import cn.pbx.springframework.beans.BeansException;

/**
 * @author BruceXu
 * @date 2022/5/17
 */
public interface BeanFactory {

    Object getBean(String name);

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
