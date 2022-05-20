package cn.pbx.springframework.beans.factory.config;

/**
 * bean中引用其他bean
 *
 * @author BruceXu
 * @date 2022/5/20
 */
public class BeanReference {

    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }

}
