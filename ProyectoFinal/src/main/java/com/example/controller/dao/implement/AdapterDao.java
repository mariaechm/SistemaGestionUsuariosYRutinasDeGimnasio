/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller.dao.implement;

/**
 *
 * @author Grupo6
 */

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Scanner;

import com.example.controller.tda.list.LinkedList;
import com.google.gson.Gson;

public class AdapterDao<T> implements InterfazDao<T> {

    private Class<?> clazz;
    protected Gson g;
    public static String URL = "media/";

    public AdapterDao(Class<?> clazz) {
        this.clazz = clazz;
        g = new Gson();
    }

    public LinkedList<T> listAll() {
        LinkedList<T> list = new LinkedList<>();
        try {
            String data = readFile();
            Type arrayType = Array.newInstance(clazz, 0).getClass();
            T[] matrix = g.fromJson(data,arrayType);
            list.toList(matrix);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public T get(Integer id) throws Exception {
        return listAll().get(id);
    }

    public void persist(T object) throws Exception {
        LinkedList<T> list = listAll();
        list.add(object);
        String info = g.toJson(list.toArray());
        saveFile(info);
    }

    public void merge(T object, Integer index) throws Exception {
        LinkedList<T> list = listAll();
        list.update(object, index);
        String data = g.toJson(list.toArray());
        saveFile(data);
    }

    protected String readFile() throws Exception {
        Scanner in = new Scanner(new FileReader(URL + clazz.getSimpleName() + ".json"));
        StringBuilder sb = new StringBuilder();
        while (in.hasNext()) {
            sb.append(in.next());
        }
        in.close();
        return sb.toString();
    }

    protected void saveFile(String data) throws Exception {
        FileWriter f = new FileWriter(URL + clazz.getSimpleName() + ".json");
        f.write(data);
        f.flush();
        f.close();
    }
}
