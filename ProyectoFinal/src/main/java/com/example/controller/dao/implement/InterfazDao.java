/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller.dao.implement;

/**
 *
 * @author Grupo6
 */

import com.example.controller.tda.list.LinkedList;

public interface InterfazDao <T> {
    public void persist(T object) throws Exception;
    public void merge(T object, Integer index) throws Exception;
    public LinkedList listAll();
    public T get(Integer id) throws Exception;    
}

