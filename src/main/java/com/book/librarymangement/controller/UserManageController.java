package com.book.librarymangement.controller;

import com.book.librarymangement.entity.User;
import com.book.librarymangement.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manage")
public class UserManageController {
    @Autowired
    private UserService userService;

    /**
     * 修改密码
     * @param id
     * @param password
     * @return
     */
    @PutMapping("{id}/modify/{password}")
    public boolean modifoyPassword(@PathVariable int id,@PathVariable String password){
        try {
            User user = new User();
            user.setId(id);
            user.setPassword(password);
            userService.modifyPassword(user);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @DeleteMapping("delete/{name}")
    public boolean deleteUser(@PathVariable String  name){
        try {
            User user = new User();
            user.setUsername(name);
            userService.deleteUser(user);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 添加新用户
     * @param user
     * @return
     */
    @PostMapping("/add/user")
    public boolean addNewUser(@RequestBody User user){
        try {
            userService.addNewUser(user);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 用户登录校验
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login/{username}/{password}")
    public boolean login(@PathVariable int username, @PathVariable String password){
        try {
            User user = new User();
            user.setId(username);
            user.setPassword(password);
            if (userService.loginUser(user)) {
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
