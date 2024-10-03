package com.celyng.example;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {

//    @GetMapping("/hello")
//    public String hello() {
//        return "Hello from my first controller";
//    }


    @GetMapping("/hello-2")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String sayHello2() {
        return "Hello 2 from my first controller";
    }

    @PostMapping("/post")
    public String post(
            @RequestBody String message
    ) {
        return "Request accepted and message is: " + message;
    }


    @PostMapping("/post-order")
    public String post(
            @RequestBody Order order
    ) {
        return "Request accepted and order is: " + order.toString();
    }


    @PostMapping("/post-order-record")
    public String postRecord(
            @RequestBody OrderRecord order
    ) {
        return "Request accepted and order is: " + order.toString();
    }


    // http://localhost:8080/hello/celyng
    @GetMapping("/hello/{user-name}")
    public String pathVar(
            @PathVariable String userName
    ) {
        return "My vlaue = " + userName;
    }

    // http://localhost:8080/hello?param_name=paramvalue&param_name_2=value_2
    @GetMapping("/hello")
    public String pathParam(
            @RequestParam("user-name") String userName,
            @RequestParam("user-lastname") String lastName
    ) {
        return "My vlaue = " + userName + " " + lastName;
    }




}
