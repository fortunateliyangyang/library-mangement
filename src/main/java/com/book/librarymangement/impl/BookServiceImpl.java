package com.book.librarymangement.impl;

import com.book.librarymangement.dao.BookDao;
import com.book.librarymangement.entity.Book;
import com.book.librarymangement.entity.BookExample;
import com.book.librarymangement.sevice.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public void addNewBook(Book book) {
        bookDao.insert(book);
    }

    @Override
    public void deleteBook(int id) {
        bookDao.deleteByPrimaryKey(id);
    }

    @Override
    public List<Book> findByName(String name) {
        BookExample bookExample = new BookExample();
        bookExample.createCriteria().andTitleLike(name);
        List<Book> bookList = bookDao.selectByExample(bookExample);
        return bookList;
    }

    @Override
    public Book findById(int id) {
        return bookDao.selectByPrimaryKey(id);
    }

    @Override
    public List<Book> findByType(String type) {
        BookExample bookExample = new BookExample();
        bookExample.createCriteria().andTypeEqualTo(type);
        List<Book> bookList = bookDao.selectByExample(bookExample);
        return bookList;
    }
}
