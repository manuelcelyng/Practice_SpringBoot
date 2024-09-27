package com.celyng.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

    @Autowired
    @Qualifier("myThirdBean")
    private  MyFirstClass myFirstClass;



    public String tellAStory(){
        return "The dependency is saying : " + myFirstClass.sayHello();
    }
}
