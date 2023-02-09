package com.youn.message_converter.v1;


/**
 *  V1 :
 *  - 기본 생성자 ❌
 *  - (모든 필드 포함) 생성자 ❌
 *  - age, name 중 하나(`age`)만 포함하고 있는 생성자
 *  - getter, setter
 */
public class RequestDtoV1 {

    private int age;
    private String name;

    public RequestDtoV1(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}