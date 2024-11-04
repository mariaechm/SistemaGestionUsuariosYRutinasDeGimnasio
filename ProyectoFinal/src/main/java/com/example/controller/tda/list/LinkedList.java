package com.example.controller.tda.list;
import java.lang.reflect.Array;

import com.example.controller.exception.ListEmptyException;

/**
 *
 * @author Grupo6
 */

public class LinkedList<E> {
    private Node<E> header;
    private Node<E> last;
    private Integer size;

    public LinkedList() {
        this.header = null;
        this.last = null;
        this.size = 0;
    }

    public Boolean isEmpty() {
        return (this.header == null || this.size == 0);
    }

    private void addHeader(E dato) {
        Node<E> help;
        if (isEmpty()) {
            help = new Node<>(dato);
            header = help;

        } else {
            Node<E> healpHeader = this.header;
            help = new Node<>(dato, healpHeader);
            this.header = help;
        }
        this.size++;
    }

    private void addLast(E info) {
        Node<E> help;
        if (isEmpty()) {
            addHeader(info);
        } else {
            help = new Node<>(info, null);
            last.setNext(help);
            last = help;
            this.size++;
        }
    }

    public void add(E info) {
        addLast(info);
    }

    private Node<E> getNode(Integer index) throws ListEmptyException, IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new ListEmptyException("Error, List empty");
        } else if (index.intValue() < 0 || index.intValue() >= this.size) {
            throw new IndexOutOfBoundsException("Error, fuera de rango");
        } else if (index.intValue() == 0) {
            return header;
        } else if (index.intValue() == (this.size - 1)) {
            return last;
        } else {
            Node<E> search = header;
            int cont = 0;
            while (cont < index.intValue()) {
                cont++;
                search = search.getNext();
            }
            return search;
        }
    }

    private E getFirst() throws ListEmptyException {
        if (isEmpty()) {
            throw new ListEmptyException("Error, Lista vacía");
        }
        return header.getInfo();
    }

    private E getLast() throws ListEmptyException {
        if (isEmpty()) {
            throw new ListEmptyException("Error, Lista vacía");
        }
        return last.getInfo();
    }

    public E get(Integer index) throws ListEmptyException, IndexOutOfBoundsException {
        if (isEmpty()) {
            throw new ListEmptyException("Error, Lista vacía");
        } else if (index.intValue() < 0 || index.intValue() >= this.size.intValue()) {
            throw new IndexOutOfBoundsException("Error, fuera de rango");
        } else if (index.intValue() == 0) {
            return getFirst();
        } else if (index.intValue() == (this.size - 1)) {
            return getLast();
        } else {
            Node<E> search = header;
            int cont = 0;
            while (cont < index.intValue()) {
                cont++;
                search = search.getNext();
            }
            return search.getInfo();
        }
    }

    public void add(E info, Integer index) throws ListEmptyException, IndexOutOfBoundsException {
        if (isEmpty() || index.intValue() == 0) {
            addHeader(info);
        } else if (index.intValue() == this.size.intValue()) {
            addLast(info);
        } else {
            Node<E> search_preview = getNode(index - 1);
            Node<E> search = getNode(index);
            Node<E> help = new Node<>(info, search);
            search_preview.setNext(help);
            this.size++;
        }
    }

    public void deleteHeader() throws ListEmptyException {
        if(isEmpty()) {
            throw new ListEmptyException("Cannot delete, LinkedList is empty");
        } else {
            Node<E> delete = this.header;
            this.header = delete.getNext();
            delete.setNext(null);
            delete = null;            
            this.size--;
        }
    }

    public void deleteLast() throws ListEmptyException {
        if(isEmpty()) {
            throw new ListEmptyException("Cannot delete, LinkedList is empty");
        } else {
            if(this.last == null) {
                this.deleteHeader();
            } else { 
                Node<E> delete = this.last;
                delete.setNext(null);
                this.last = this.getNode(size-2);
                delete = null;
                this.size--;
            }
        }
    }

    public void delete(Integer index) throws Exception {
        if(isEmpty()) {
            throw new ListEmptyException("Cannot delete, LinkedList is empty");
        } else if(index < 0 || index >= this.size-1) {
            throw new IndexOutOfBoundsException("Cannot delete, index out bounds");
        } else if(index == 0) {
            this.deleteHeader();
        } else if(index == this.size - 1) {
            this.deleteLast();
        } else {
            Node<E> previus = getNode(index-1);
            Node<E> eliminar = previus.getNext();
            previus.setNext(eliminar.getNext());
            eliminar.setNext(null);
            eliminar = null;
            this.size--;
        }
    }

    public void update(E info, Integer index) throws Exception {
        this.getNode(index).setInfo(info);
    }

    /*** END BY POSITION */

    public void reset() {
        this.header = null;
        this.last = null;
        this.size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("List Data \n");
        try {
            Node<E> help = header;
            while (help != null) {
                sb.append(help.getInfo()).append(" -> ");
                help = help.getNext();
            }
        } catch (Exception e) {
            sb.append(e.getMessage());
        }

        return sb.toString();
    }

    public Integer getSize() {
        return this.size;
    }

    public E[] toArray(){
        E[] matrix;
        if (!isEmpty()) {
            Class<?> clazz = header.getInfo().getClass();
            @SuppressWarnings("unchecked")
            E[] matrix1 = (E[]) java.lang.reflect.Array.newInstance(clazz, size);
            matrix = matrix1;
            Node<E> aux = header;
            for(int i=0; i<size; i++){
                matrix[i] = aux.getInfo();
                aux = aux.getNext();
            }
        } else {
            @SuppressWarnings("unchecked")
            E[] matrix1 = (E[])Array.newInstance(this.header.getInfo().getClass(), 0);
            return matrix1;
        }
        return matrix;
    }

    public LinkedList<E> toList(E[] matrix){
        reset();
        for(int i = 0; i < matrix.length; i++){
            this.add(matrix[i]);
        }
        return this;
    }

}

