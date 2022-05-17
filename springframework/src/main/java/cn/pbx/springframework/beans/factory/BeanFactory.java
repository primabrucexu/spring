package cn.pbx.springframework.beans.factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author BruceXu
 * @date 2022/5/17
 */
public class BeanFactory {

    private Map<String, Object> beanMap = new ConcurrentHashMap<>();

    public void registerBean(String name, Object bean) {
        beanMap.put(name, bean);
    }

    public Object getBean(String name) {
        return beanMap.get(name);
    }

}
