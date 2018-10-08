package com.footprint.controller;

import com.footprint.exception.CommonException;
import com.footprint.model.User;
import com.footprint.service.UserService;
import org.apache.commons.logging.Log;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.logging.Logger;

@Controller
public class HelloController {
    @Resource
    private UserService userService;

    @RequestMapping(value = {"/hello", "/"}, method = RequestMethod.GET)
    public String hello(User user) throws CommonException {
        System.out.println("test--"+user);
        if (user != null)
            throw new CommonException("common test");
        return "hello";
    }
    @RequestMapping("/success")
    public String success(){
        org.slf4j.Logger logger = LoggerFactory.getLogger(HelloController.class);
        logger.error("request -- success");
        return "success";
    }

    /*@RequestMapping("/error")
    public String error(){
        org.slf4j.Logger logger = LoggerFactory.getLogger(HelloController.class);
        logger.error("request -- error");
        return "error";
    }*/
}
