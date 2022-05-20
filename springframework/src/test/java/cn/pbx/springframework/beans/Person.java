package cn.pbx.springframework.beans;

import lombok.Data;

/**
 * @author BruceXu
 * @date 2022/5/19
 */
@Data
public class Person {

    private String name;
    private int age;
    private Car car;

}
