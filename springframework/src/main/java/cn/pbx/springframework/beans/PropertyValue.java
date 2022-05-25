package cn.pbx.springframework.beans;

import lombok.ToString;

/**
 * @author BruceXu
 * @date 2022/5/19
 */
@ToString
public class PropertyValue {

    private final String name;
    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
