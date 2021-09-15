package hu.flowacademy.demo.service;

import org.springframework.stereotype.Service;

//@Service
public class SimpleService implements CommonInterface{
    public SimpleService(String someData) {
        System.out.println("Hello, I'm the simple service! " + someData);
    }

    public String getSimpleMessage() {
        return "hola, i'm a simple message";
    }
}
