package com.example.models;

import com.example.controller.tda.list.LinkedList;

public class Prueba {
    public static void main(String[] args) throws Exception {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        System.out.println(list);
        list.delete(0);
        System.out.println(list);
    }
}
