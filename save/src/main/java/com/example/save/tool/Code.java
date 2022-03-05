package com.example.save.tool;

public class Code {
    public static String code(String str){
        long toLong, code;
        try {
            toLong = Long.parseLong(str);
            code = toLong + 9911252910L;
        }catch (Exception e){
            System.out.println("wrong school number:" + str);
            return str;
        }

        return Long.toString(code);
    }
}
