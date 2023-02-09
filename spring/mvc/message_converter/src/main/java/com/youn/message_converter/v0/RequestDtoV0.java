package com.youn.message_converter.v0;

/**
 *  V0 :
 *  - 기본 생성자 ❌
 *  - (모든 필드 포함) 생성자
 *  - getter, setter
 */
public class RequestDtoV0 {

    private int age;
    private String name;

    public RequestDtoV0(int age, String name) {
        this.age = age;
        this.name = name;
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