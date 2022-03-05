package com.example.save.tool;

public class Decode {
    public static String decode (String str) {
        long toLong,decode;
        try {
            toLong = Long.parseLong(str);
            decode = toLong - 9911252910L;
        }catch (Exception e){
            return str;
        }
        return Long.toString(decode);
    }
}
