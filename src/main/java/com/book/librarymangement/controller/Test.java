package com.book.librarymangement.controller;

import org.springframework.util.DigestUtils;

public class Test {
    public static void main(String[] args) {
        System.out.println(DigestUtils.md5DigestAsHex("123456".getBytes()));
    }
}
