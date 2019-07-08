package com.book.librarymangement.sevice;

import com.book.librarymangement.entity.Student;

public interface StudentService {
    void addStudent(Student student);

    void updateStudentInfo(Student student);

    void modifyPassword(Student student);

    void deleteStudent(String  id);

    boolean login(Student student);

    Student getStudentInfo(String id);

}
