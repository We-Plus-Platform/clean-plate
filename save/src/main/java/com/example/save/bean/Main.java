package com.example.save.bean;

public class Main {
    public static void main(String[] args) {
//        String a = "D://temp//evening//";
//        String c = a.replace("//", "/");
//        System.out.println(c);
        MyInfoResult myInfoResult = new MyInfoResult();
        Result result = new Result();
        myInfoResult.setStatus(100);
        System.out.println(result.getStatus());
    }
}
