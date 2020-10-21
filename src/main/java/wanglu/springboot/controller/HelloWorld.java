package wanglu.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloWorld {

    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }


    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello", "nihao");
        return "haha";
    }
}
