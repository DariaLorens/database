package com.bisenessmap.app.database.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "BisenessType")
public class BisenessType {
    @Id
    private String id;
    private String name;

    protected BisenessType(){
    }

    public BisenessType(String name){
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{\"name\":\""+name+"\"}";
    }
}
