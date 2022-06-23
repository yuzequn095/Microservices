package com.zequn.springboot.restfulwebservices.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// Controller
@RestController
public class HelloWorldController {
    // GET
    // URL - /hello-world
    // method - return "Hello World"
    // @RequestMapping(method= RequestMethod.GET, path="/hello-word")
    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    // hello-world-bean
    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
    }

    // hello world path variable
    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }
}
