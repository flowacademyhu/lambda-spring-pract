package hu.flowacademy.demo.service;

import org.springframework.stereotype.Service;

@Service
public class ComplexService implements CommonInterface{

    @Override
    public String getSimpleMessage() {
        return "hey, I'm a complex service";
    }
}
