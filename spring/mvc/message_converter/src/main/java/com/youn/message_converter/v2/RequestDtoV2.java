package com.youn.message_converter.v2;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 *  V2 :
 *  - 기본 생성자 ❌
 *  - (모든 필드 포함) 생성자 ❌
 *  - age, name 중 하나(`age`)만 포함하고 있는 생성자 ✚ @JsonCreator
 *  - getter, setter
 */
public class RequestDtoV2 {

    private int age;
    private String name;

    @JsonCreator
    public RequestDtoV2(int age) {
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