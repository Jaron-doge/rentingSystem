package com.example.rent.entity;

public class Category {
    static String ccity="不限";
    static String cprice="不限";
    static String ctype_bedroom="不限";
    static String chouseToward="不限";

    public static void setCcity(String ccity) {
        Category.ccity = ccity;
    }

    public static void setCprice(String cprice) {
        Category.cprice = cprice;
    }

    public static void setCtype_bedroom(String ctype_bedroom) {
        Category.ctype_bedroom = ctype_bedroom;
    }

    public static void setChouseToward(String chouseToward) {
        Category.chouseToward = chouseToward;
    }

    public static String getCcity() {
        return ccity;
    }

    public static String getCprice() {
        return cprice;
    }

    public static String getCtype_bedroom() {
        return ctype_bedroom;
    }

    public static String getChouseToward() {
        return chouseToward;
    }

    public Category() {
    }
}
