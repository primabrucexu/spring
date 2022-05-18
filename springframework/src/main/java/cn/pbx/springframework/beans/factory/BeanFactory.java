package cn.pbx.springframework.beans.factory;

/**
 * @author BruceXu
 * @date 2022/5/17
 */
public interface BeanFactory {

    Object getBean(String name);

}
