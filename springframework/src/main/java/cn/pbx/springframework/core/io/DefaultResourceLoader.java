package cn.pbx.springframework.core.io;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author BruceXu
 * @date 2022/5/24
 */
public class DefaultResourceLoader implements ResourceLoader {
    @Override
    public Resource getResource(String location) {
        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            //classpath下的资源
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        } else {
            try {
                //尝试当成url来处理
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException ex) {
                //当成文件系统下的资源处理
                return new FileSystemResource(location);
            }
        }
    }
}
