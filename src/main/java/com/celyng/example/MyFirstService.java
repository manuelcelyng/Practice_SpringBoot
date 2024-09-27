package com.celyng.example;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Service;

@Service
@PropertySources(
        {
                @PropertySource("classpath:custom.properties"),
                @PropertySource("classpath:custom-2-file.properties")
        }
)
public class MyFirstService {

    @Value("${my.prop}")
    private String customPropertyFromAnotherFile;

    @Value("${my.prop2}")
    private String customPropertyFromAnotherFile2;

    private final MyFirstClass myFirstClass;

    public MyFirstService(
            @Qualifier("myFirstBean") MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }


    public String tellAStory(){
        return "The dependency is saying : " + myFirstClass.sayHello();
    }


    public String getCustomPropertyFromAnotherFile() {
        return customPropertyFromAnotherFile;
    }

    public String getCustomPropertyFromAnotherFile2() {
        return customPropertyFromAnotherFile2;
    }
}
