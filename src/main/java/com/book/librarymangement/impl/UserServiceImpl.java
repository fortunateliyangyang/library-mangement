package com.book.librarymangement.impl;

import com.book.librarymangement.dao.UserDao;
import com.book.librarymangement.entity.User;
import com.book.librarymangement.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public void addNewUser(User user) {
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        userDao.insert(user);
    }

    @Override
    public void modifyPassword(User user) {
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        userDao.updateByPrimaryKey(user);
    }

    @Override
    public void deleteUser(User user) {
        userDao.deleteByPrimaryKey(user.getId());
    }

    @Override
    public boolean loginUser(User user) {
        User old = userDao.selectByPrimaryKey(user.getId());
        if (old != null) {
            return old.getPassword().equals(DigestUtils.md5DigestAsHex(user.getPassword().getBytes())) ? true : false;
        } else {
            return false;
        }
    }
}
