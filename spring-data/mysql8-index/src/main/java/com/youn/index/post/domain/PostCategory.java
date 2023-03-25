package com.youn.index.post.domain;

import java.util.Arrays;

public enum PostCategory {

    FREE_THREAD("free-thread"),
    WORRIES_HUGS("worries-hugs"),
    TECH("tech"),
    BUSINESS("business"),
    LAW("law"),
    MED_HEALTH("med-health"),
    HUMANITIES("humanities"),
    SOCIAL_SCIENCES("social-sciences"),
    NATURAL_SCIENCES("natural-sciences"),
    ARTS("arts"),
    EVENTS("events"),
    CAMPUS("campus");

    private final String name;

    PostCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static PostCategory of(String name) {
        return Arrays.stream(values())
                .filter(category -> category.name.equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow();
    }
}