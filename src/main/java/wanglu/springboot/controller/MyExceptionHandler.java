package wanglu.springboot.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import wanglu.springboot.exception.UserNotExistException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {
    @ResponseBody
    @ExceptionHandler(UserNotExistException.class)
    public Map<String, Object> handleException(Exception e){

        Map<String, Object> map = new HashMap<>();
        map.put("code", "user.not exist");
        map.put("message", e.getMessage());
        return map;
    }
}
