package cn.pbx.springframework.core.io;

/**
 * 资源获取器
 *
 * @author BruceXu
 * @date 2022/5/24
 */
public interface ResourceLoader {

    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);

}
