package com.example.rent.entity;

public class Manager {
   private Integer managerId;
    private String  pwd;
    private String  name;
    private String managerIcon;
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

    public String getManagerIcon() {
        return managerIcon;
    }

    public void setManagerIcon(String managerIcon) {
        this.managerIcon = managerIcon;
    }

    public Integer getSum() {
        return this.sum;

    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }
    @Override
    public String toString() {
        return "Manager{" +
                "managerId=" + managerId +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", managerIcon='" + managerIcon + '\'' +
                ", sum='" + sum + '\'' +
                '}';
    }

}
