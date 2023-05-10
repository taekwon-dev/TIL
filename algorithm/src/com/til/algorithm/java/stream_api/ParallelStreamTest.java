package com.til.algorithm.java.stream_api;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ParallelStreamTest {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of("TK", "SH", "JS"));

        Stream<String> parallelStream = names.parallelStream();
        parallelStream.forEach(name -> {
            System.out.println(name + ": " + Thread.currentThread().getName());
        });
    }
}