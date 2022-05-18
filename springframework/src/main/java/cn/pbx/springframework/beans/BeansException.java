package cn.pbx.springframework.beans;

/**
 * @author BruceXu
 * @date 2022/5/17
 */
public class BeansException extends RuntimeException {

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
