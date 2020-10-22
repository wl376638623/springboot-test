package wanglu.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wanglu.springboot.exception.UserNotExistException;

import javax.websocket.server.PathParam;
import java.util.Map;

@RestController
public class HelloWorld {

    @RequestMapping("/hello")
    public String hello(@PathParam("user") String user){
        if (user.equals("aaa")){
            throw new UserNotExistException();
        }
        return "hello world";
    }


    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello", "nihao");
        return "haha";
    }
}
