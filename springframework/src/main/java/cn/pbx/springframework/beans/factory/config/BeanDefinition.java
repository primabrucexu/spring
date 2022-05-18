package cn.pbx.springframework.beans.factory.config;

/**
 * bean的封装类
 *
 * @author BruceXu
 * @date 2022/5/17
 */
public class BeanDefinition {

    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
