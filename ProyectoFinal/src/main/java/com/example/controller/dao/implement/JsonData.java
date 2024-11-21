package com.example.controller.dao.implement;

public class JsonData<K> {
    private Integer currentId;
    private String className;
    private K[] objects;

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

    public K[] getObjects() {
        return objects;
    }

    public void setObjects(K[] objects) {
        this.objects = objects;
    }  
    
    @Override 
    public String toString() {
        return "{currentId=" + this.currentId.toString() 
        + ", className=" + this.className + ", objects=" + this.objects.toString() + "}";
    }
}
