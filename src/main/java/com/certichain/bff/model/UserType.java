package com.certichain.bff.model;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class UserType {

    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId Id;
    private String Name;
    private String State;

    public ObjectId getId() {
        return Id;
    }
    public void setId(ObjectId id) {
        Id = id;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getState() {
        return State;
    }
    public void setState(String state) {
        State = state;
    }

}
