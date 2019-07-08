package com.book.librarymangement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"com.book.librarymangement.dao"})
@SpringBootApplication
public class LibraryMangementApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryMangementApplication.class, args);
    }
}
