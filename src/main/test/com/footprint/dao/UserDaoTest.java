package com.footprint.dao;

import com.footprint.model.User;
import com.footprint.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:dispatcher-servlet.xml", "classpath:applicationContext.xml"})
public class UserDaoTest {

    @Resource
    private UserService userService;

//    @Resource(name = "userService")
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }

    @Test
    public void testAdd() throws Exception {
        User user = new User();
        user.setName("shu");
        user.setNickname("kongfu zhu");
        user.setSex(2);
        user.setPassword("123456");
        userService.add(user);
    }
}
