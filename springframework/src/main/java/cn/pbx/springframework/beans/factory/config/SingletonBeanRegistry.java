package cn.pbx.springframework.beans.factory.config;

/**
 * 单例bean注册
 *
 * @author BruceXu
 * @date 2022/5/17
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);

}
