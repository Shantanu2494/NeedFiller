package com.example.needfiller;

public class Data {
    public String name;
    public String type;
    public String desc;
    public String phone;
    public String location;

    public Data() {
        // Default constructor required for calls to DataSnapshot.getValue(Data.class)
    }

    public Data(String name, String type, String desc, String phone, String location) {
        this.name = name;
        this.type = type;
        this.desc = desc;
        this.phone = phone;
        this.location = location;
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
}
