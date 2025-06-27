package com.certichain.bff.model;

public class UserData {

    private String Id;
    private String UserID;
    private String UserTypeId;
    private String UserSubTypeId;

    private String Status;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
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
}
