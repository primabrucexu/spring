package cn.pbx.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 统一资源接口
 *
 * @author BruceXu
 * @date 2022/5/24
 */
public interface Resource {

    InputStream getInputStream() throws IOException;

}
