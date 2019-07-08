package com.book.librarymangement.sevice;

import com.book.librarymangement.entity.Book;

import java.util.List;

public interface BookService {
    void addNewBook(Book book);

    void deleteBook(int id);

    List<Book> findByName(String name);

    List<Book> findByType(String type);

    Book findById(int id);
}
