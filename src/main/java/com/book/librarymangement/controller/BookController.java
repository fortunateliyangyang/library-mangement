package com.book.librarymangement.controller;

import com.book.librarymangement.entity.Book;
import com.book.librarymangement.enums.BookType;
import com.book.librarymangement.sevice.BookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Resource
    private BookService bookService;

    /**
     * 通过名字查找
     * @param
     * @return
     */
    @GetMapping("/find/{key}/{value}")
    @ResponseBody
    public List<Book> getAll(@PathVariable String key, @PathVariable String value){
        if (key.equals("name")) {
            return bookService.findByName(value);
        } else if(key.equals("type")) {
            return bookService.findByType(value);
        } else if (key.equals("id")) {
            List list = new ArrayList();
            list.add(bookService.findById(Integer.parseInt(value)));
            return list;
        } else {
            return null;
        }
    }

//    /**
//     * 通过类型查找
//     * @param type
//     * @return
//     */
//    @GetMapping("/{type}/find")
//    public List<Book> getBookByType(@PathVariable byte type){
//        return bookService.findByType(type);
//    }
//
//    /**
//     * 通过主键查找
//     * @param id
//     * @return
//     */
//    @GetMapping("/find/{id}")
//    public Book getBookById(@PathVariable int id) {
//        return bookService.findById(id);
//    }

    /**
     * 通过id删除书
     * @param id
     * @return
     */
    @DeleteMapping("delete/{id}")
    public boolean deleteBook(@PathVariable int id){
        try {
            bookService.deleteBook(id);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 录入新书
     * @param book
     * @return
     */
    @GetMapping("/add")
    public boolean addNewBook(@RequestBody Book book){
        try {
            bookService.addNewBook(book);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
