package com.celyng.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {


    private MyFirstClass myFirstClass;

    private Environment environment;

    @Autowired
    public void setMyFirstBean( @Qualifier("myFirstBean")MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }

    public String tellAStory(){
        return "The dependency is saying : " + myFirstClass.sayHello();
    }

    public String getJavaVersion(){
        return environment.getProperty("java.version");
    }

    public String getOsName(){
        return environment.getProperty("os.name");
    }

    public String readProperty(){
        return environment.getProperty("my.custom.property");
    }

    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }



}
