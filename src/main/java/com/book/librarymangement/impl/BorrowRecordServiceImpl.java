package com.book.librarymangement.impl;

import com.book.librarymangement.dao.BookDao;
import com.book.librarymangement.dao.BorrowRecordDao;
import com.book.librarymangement.entity.Book;
import com.book.librarymangement.entity.BorrowRecord;
import com.book.librarymangement.entity.BorrowRecordExample;
import com.book.librarymangement.sevice.BorrowRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class BorrowRecordServiceImpl implements BorrowRecordService {
    @Resource
    BorrowRecordDao borrowRecordDao;
    @Resource
    BookDao bookDao;

    @Override
    public void addNewRecord(BorrowRecord record) {
        borrowRecordDao.insert(record);
    }

    @Override
    public List<BorrowRecord> selectRecordByStudentId(String studentId) {
        BorrowRecordExample borrowRecordExample = new BorrowRecordExample();
        borrowRecordExample.createCriteria().andUserIdEqualTo(studentId);
        return borrowRecordDao.selectByExample(borrowRecordExample);
    }

    @Override
    public void returnBook(String studentId, int bookId) {
        Book book = bookDao.selectByPrimaryKey(bookId);
        book.setStatus(0);
        bookDao.updateByPrimaryKey(book);
    }

    @Override
    public boolean borrowBook(String studentId, int bookId, int day) {
        Book book = bookDao.selectByPrimaryKey(bookId);
        book.setStatus(1);
        bookDao.updateByPrimaryKey(book);
        BorrowRecord borrowRecord = new BorrowRecord();
        borrowRecord.setBookId(bookId);
        borrowRecord.setUserId(studentId);
        borrowRecord.setBorrowTime(day);
        borrowRecord.setStartTime(new Date());
        borrowRecordDao.insert(borrowRecord);
        return true;
    }

    @Override
    public List<BorrowRecord> selectRecordByBookId(int id) {
        BorrowRecordExample borrowRecordExample = new BorrowRecordExample();
        borrowRecordExample.createCriteria().andBookIdEqualTo(id);
        return borrowRecordDao.selectByExample(borrowRecordExample);
    }

    @Override
    public void deleteRecord(int id) {
        borrowRecordDao.deleteByPrimaryKey(id);
    }
}
