package com.youn.message_converter.v3;

/**
 *  V3 :
 *  - 기본 생성자 ❌
 *  - (모든 필드 포함) 생성자 ❌
 *  - age, name, email 중 (`age`, `name`)만 포함하고 있는 생성자
 *  - getter
 *  - setter for `email` field
 */
public class RequestDtoV3 {

    private int age;
    private String name;
    private String email;

    public RequestDtoV3(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}