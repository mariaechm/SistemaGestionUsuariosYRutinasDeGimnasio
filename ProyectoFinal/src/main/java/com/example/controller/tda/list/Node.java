/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller.tda.list;

/**
 *
 * @author Grupo6
 */

public class Node<E> {
    private E info;
    private Node<E> next;

    public Node(E info) {
        this.info = info;
        this.next = null;
    }

    public Node(E info, Node<E> next) {
        this.info = info;
        this.next = next;
    }

    public E getInfo() {
        return this.info;
    }

    public void setInfo(E info) {
        this.info = info;
    }

    public Node<E> getNext() {
        return this.next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

}
