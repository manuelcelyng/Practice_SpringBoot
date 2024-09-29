package com.celyng.example;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

    @Value("${my.custom.property}")
    private String nameProperty;
    @Value("${my.custom.property.int}")
    private int numberProperty;


    private final MyFirstClass myFirstClass;

    public MyFirstService(
            @Qualifier("bean1") MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }


    public String tellAStory(){
        return "The dependency is saying : " + myFirstClass.sayHello();
    }


    public String getNameProperty() {
        return nameProperty;
    }

    public int getNumberProperty() {
        return numberProperty;
    }
}
