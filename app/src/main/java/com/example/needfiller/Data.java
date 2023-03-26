package com.example.needfiller;

public class Data {
    public String name;
    public String type;
    public String desc;
    public String phone;
    public String location;
    public String uid;

    public String id;
    public Data() {
        // Default constructor required for calls to DataSnapshot.getValue(Data.class)
    }

    public Data(String name, String type, String desc, String phone, String location, String uid) {
        this.name = name;
        this.type = type;
        this.desc = desc;
        this.phone = phone;
        this.location = location;
        this.uid = uid;
    }

    public Data(String name, String type, String desc, String phone, String location, String uid, String id) {
        this.name = name;
        this.type = type;
        this.desc = desc;
        this.phone = phone;
        this.location = location;
        this.uid = uid;
        this.id = id;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
