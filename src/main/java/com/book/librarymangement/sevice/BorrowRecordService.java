package com.book.librarymangement.sevice;

import com.book.librarymangement.entity.BorrowRecord;

import java.util.List;

public interface BorrowRecordService {

    void addNewRecord(BorrowRecord record);

    void deleteRecord(int id);

    List<BorrowRecord> selectRecordByStudentId(String studentId);

    List<BorrowRecord> selectRecordByBookId(int id);

    boolean borrowBook(String studentId, int bookId, int day);

    void returnBook(String studentId, int bookId);
}
