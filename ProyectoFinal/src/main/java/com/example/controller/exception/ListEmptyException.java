/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller.exception;


/**
 *
 * @author Grupo6
 */

public class ListEmptyException extends Exception {
    /**
     * Creates a new instance of <code>EmptyException</code> without detail message.
     */
    public ListEmptyException() {
    }

    /**
     * Constructs an instance of <code>EmptyException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public ListEmptyException(String msg) {
        super(msg);
    }
}