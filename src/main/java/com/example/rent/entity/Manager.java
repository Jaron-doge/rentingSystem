package com.example.rent.entity;

public class Manager {
   private Integer managerId;
    private String  pwd;
    private String  name;
    private Integer sum;


    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSum() {
        return this.sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }


}
