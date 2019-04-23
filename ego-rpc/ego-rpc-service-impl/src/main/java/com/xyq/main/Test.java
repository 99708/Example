package com.xyq.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext
                ac=new ClassPathXmlApplicationContext(new String[]{
                "application_mapper.xml",
                "application_service.xml",
                "application_dubbo.xml"

        });
        ac.start();
        System.out.println("==========服务发布=============");
        System.in.read();
    }
}
