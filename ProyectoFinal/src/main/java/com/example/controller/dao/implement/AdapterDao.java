/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller.dao.implement;

import java.io.BufferedReader;

/**
 *
 * @author Grupo6
 */

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.HashMap;

import com.example.controller.tda.list.LinkedList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class AdapterDao<T> implements InterfazDao<T> {

    private Class<?> modelClass;
    protected Gson g;
    public static String URL = "media/";
    protected Integer currentId;

    public AdapterDao(Class<?> modelClass) {
        this.modelClass = modelClass;
        g = new Gson();
    }

    public AdapterDao(Class<?> modelClass,Integer contadorId) throws Exception {
        this(modelClass);   
        this.currentId = readContador(contadorId);
    }

    protected abstract Integer getIndexToOperate(Integer id) throws Exception;
    protected abstract JsonData<T> readFileAsJsonData() throws Exception;  

    private Integer readContador(Integer initialId) throws Exception {
        Integer contador_Id;
        try {
            if(readFileAsJsonData().getCurrentId() == null) {
                @SuppressWarnings("unchecked")
                T[] array = (T[])Array.newInstance(modelClass, 0);
                saveFile(array,initialId);
            }
            contador_Id = readFileAsJsonData().getCurrentId();
        } catch (Exception e) {
            @SuppressWarnings("unchecked")
                T[] array = (T[])Array.newInstance(modelClass, 0);
            saveFile(array,initialId);
            contador_Id = readFileAsJsonData().getCurrentId();
        }
        return contador_Id;
    }

    public LinkedList<T> listAll() {
        LinkedList<T> list = new LinkedList<>();
        try {
            T[] matrix = readFileAsJsonData().getObjects();
            list.toList(matrix);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public T get(Integer id) throws Exception {
        return listAll().get(getIndexToOperate(id));
    }

    public void persist(T object) throws Exception {
        LinkedList<T> list = listAll();
        list.add(object);
        saveFile(list.toArray(),this.currentId);
    }

    public void merge(T object, Integer id) throws Exception {
        LinkedList<T> list = listAll();
        list.update(object, getIndexToOperate(id));
        saveFile(list.toArray(),this.currentId);
    }

    public void remove(Integer id) throws Exception {
        LinkedList<T> list = listAll();
        list.delete(getIndexToOperate(id));
        saveFile(list.toArray(),this.currentId);
    }

    protected  String readFile() throws Exception {
        StringBuilder sb = new StringBuilder();
        try(BufferedReader bf = new BufferedReader(
            new FileReader(URL + modelClass.getSimpleName() + ".json")) )
        {
            String line;
            while((line = bf.readLine()) != null) {
                sb.append(line).append("\n");
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();    
        }
        return null;
    }

    protected void saveFile(T[] objects, Integer currentId) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        HashMap<String,Object> dataMap = new HashMap<>();
        dataMap.put("className",modelClass.getSimpleName());
        dataMap.put("currentId",currentId);
        dataMap.put("objects",objects);

        try(FileWriter f = new FileWriter(URL + modelClass.getSimpleName() + ".json")) {
                f.write(gson.toJson(dataMap));
                f.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void saveFile(T[] objects) {
        saveFile(objects,this.currentId);
    } 
}
