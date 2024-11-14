package com.example.controller.dao.implement;

public class JsonData<T> {
    private Integer currentId;
    private String className;
    private T[] objects;

    public JsonData() {}

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getCurrentId() {
        return currentId;
    }

    public void setCurrentId(Integer currentId) {
        this.currentId = currentId;
    }

    public T[] getObjects() {
        return objects;
    }

    public void setObjects(T[] objects) {
        this.objects = objects;
    }  
    
    @Override 
    public String toString() {
        return "{currentId=" + this.currentId.toString() 
        + ", className=" + this.className + ", objects=" + this.objects.toString() + "}";
    }
}
