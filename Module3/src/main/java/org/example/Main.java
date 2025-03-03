package org.example;

import com.google.common.collect.ImmutableList;

public class Main {
    public static void main(String[] args) {
        ImmutableList<String> fruits = ImmutableList.of("Mar", "Banana", "Portocala");
        System.out.println("Fructe: " + fruits);
    }

    public static int add(int a, int b) {
        return a + b;
    }
}