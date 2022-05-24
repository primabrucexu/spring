package cn.pbx.springframework.beans.factory.support;

import cn.pbx.springframework.beans.BeansException;
import cn.pbx.springframework.core.io.Resource;
import cn.pbx.springframework.core.io.ResourceLoader;

/**
 * 读取bean定义信息
 *
 * @author BruceXu
 * @date 2022/5/24
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

    default void loadBeanDefinitions(String[] locations) throws BeansException {
        for (String location : locations) {
            loadBeanDefinitions(location);
        }
    }
}
