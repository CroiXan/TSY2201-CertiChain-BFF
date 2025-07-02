package com.certichain.bff.model;

import org.bson.types.ObjectId;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class UserData {

    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    private String UserID;
    private String name;
    private String UserTypeId;
    private String UserSubTypeId;
    private String Status;

    public ObjectId getId() {
        return this.id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getUserTypeId() {
        return UserTypeId;
    }

    public void setUserTypeId(String userTypeId) {
        UserTypeId = userTypeId;
    }

    public String getUserSubTypeId() {
        return UserSubTypeId;
    }

    public void setUserSubTypeId(String userSubTypeId) {
        UserSubTypeId = userSubTypeId;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
