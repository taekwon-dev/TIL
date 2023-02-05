package com.youn.message_converter;


/**
 * (기본 생성자 없을 때)
 * InvalidDefinitionException: Cannot construct instance of `com.youn.message_converter.RequestDto`
 */
public class RequestDto {

    private int age;
    private String name;

    protected RequestDto() {
    }

    public RequestDto(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}