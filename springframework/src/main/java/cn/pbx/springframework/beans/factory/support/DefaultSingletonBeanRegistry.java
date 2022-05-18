package cn.pbx.springframework.beans.factory.support;

import cn.pbx.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 默认的单例注册实现
 *
 * @author BruceXu
 * @date 2022/5/17
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, Object> singletonBeanMap = new ConcurrentHashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonBeanMap.get(beanName);
    }

    protected void addSingleton(String beanName, Object singletonObject) {
        singletonBeanMap.put(beanName, singletonObject);
    }

}
