package com.book.librarymangement.sevice;

import com.book.librarymangement.entity.User;

public interface UserService {
    void addNewUser(User user);

    void modifyPassword(User user);

    void deleteUser(User user);

    boolean loginUser(User user);
}
