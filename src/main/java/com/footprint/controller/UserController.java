package com.footprint.controller;

import com.footprint.exception.CommonException;
import com.footprint.model.User;
import com.footprint.service.UserService;
import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.portlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

//    private HttpServletRequest request;
//    private HttpServletResponse response;

    @ModelAttribute  //该注解用于在执行请求调用方法前执行
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response){
        Logger logger = LoggerFactory.getLogger(UserController.class);
        logger.error("请求执行--"+request.getRequestURL()+", remote--"+request.getRemoteAddr()+", local--"+request.getLocalAddr());
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addUser() throws Exception{
//        Logger logger = LoggerFactory.getLogger(UserController.class);
//        logger.error("user is null {}", UserService.class.getSimpleName());
        return "user/add";
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@Validated User user, BindingResult result) throws CommonException {
//        System.out.println(user.getBirthday().toString());
        if (result.hasErrors()){
            List<ObjectError> errors = result.getAllErrors();
            for(ObjectError error : errors){
                System.out.println("error--"+error.getDefaultMessage());
            }
            return "user/add";
        }
        userService.add(user);
        return "redirect:/success";//转发，不是重定向
    }

    @RequestMapping(value = "/{id}/delete")
    public String deleteUser(@PathVariable int id) throws Exception{
        userService.delete(id);
//        new ModelAndView();
        return "user/list";
    }

    @RequestMapping(value = "/{id}/update")
    public String updateUser(@PathVariable int id, User user, Model model) throws Exception{
        userService.update(user);
        model.addAttribute("user", user);
        return "user/list";
    }

    @RequestMapping(value = "/{id}")
    public @ResponseBody User getUserById(@PathVariable int id){
        return userService.get(id);
    }
}
