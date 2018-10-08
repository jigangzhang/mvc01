package com.footprint.service;

import com.footprint.dao.UserDao;
import com.footprint.exception.CommonException;
import com.footprint.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserService implements IService<User> {

    private UserDao userDao;

    @Resource
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(User user) throws CommonException {
        if (userDao.findUserByName(user.getName()) == null)
            userDao.add(user);
        else
            throw new CommonException("用户存在");
    }

    public void delete(int id) {
        userDao.delete(id);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public User get(int id) {
        return userDao.get(id);
    }

    public List<User> getAll() {
        return userDao.getAll();
    }
}
