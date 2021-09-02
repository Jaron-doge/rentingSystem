package com.example.rent.util;

public class StringUtil {
    public static boolean isEmpty(String str){
        if (str==null||"".equals(str.trim())){
             return true;

        }else{
            return false;
        }
    }
    public  static boolean IntisEmpty(Integer number){
        if(number==null||number==0){
            return true;
        }else{
            return false;
        }
    }
}
