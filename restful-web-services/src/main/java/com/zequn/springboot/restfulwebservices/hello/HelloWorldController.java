package com.zequn.springboot.restfulwebservices.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

// Controller
@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

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

    // hello world for internationalized
    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized(
            @RequestHeader(name="Accept-Language", required=false) Locale locale
    ){
        return messageSource.getMessage("good.morning.message", null, "Default message", locale);
        // or replace locale with LocaleContextHolder.getLocale() to enable internationalized

        // Configure different locale
        // en = Hello World
        // fr = Bonjour
    }
}
