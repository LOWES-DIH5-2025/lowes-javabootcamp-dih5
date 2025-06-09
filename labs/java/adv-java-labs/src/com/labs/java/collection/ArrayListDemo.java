package com.labs.java.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        List skills = new ArrayList();

        skills.add("Java");
        skills.add("Python");
        skills.add("JavaScript");

        skills.add(2, "C++"); // Insert C++ at index 2
        skills.remove(1);

        skills.set(2,"Typescript");
        System.out.println("Skills: " + skills);


    }
}
