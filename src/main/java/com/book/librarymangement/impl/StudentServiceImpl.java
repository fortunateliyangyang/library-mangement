package com.book.librarymangement.impl;

import com.book.librarymangement.dao.StudentDao;
import com.book.librarymangement.entity.Student;
import com.book.librarymangement.sevice.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;

    @Override
    public void addStudent(Student student) {
        studentDao.insert(student);
    }

    @Override
    public void modifyPassword(Student student) {
        student.setPassword(DigestUtils.md5DigestAsHex(student.getPassword().getBytes()));
    }

    @Override
    public void updateStudentInfo(Student student) {
        studentDao.updateByPrimaryKey(student);
    }

    @Override
    public void deleteStudent(String id) {
        studentDao.deleteByPrimaryKey(id);
    }

    @Override
    public Student getStudentInfo(String id) {
        return studentDao.selectByPrimaryKey(id);
    }

    @Override
    public boolean login(Student student) {
        Student old = studentDao.selectByPrimaryKey(student.getId());
        if (old != null) {
            return old.getPassword().equals(DigestUtils.md5DigestAsHex(student.getPassword().getBytes())) ? true : false;
        } else {
            return false;
        }
    }
}
