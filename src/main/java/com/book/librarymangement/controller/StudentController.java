package com.book.librarymangement.controller;

import com.book.librarymangement.entity.Student;
import com.book.librarymangement.sevice.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/info/{id}")
    @ResponseBody
    public Student getStudentInfo(@PathVariable String id) {
        try{
            return studentService.getStudentInfo(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 学生帐号修改密码
     * @param id
     * @param password
     * @return
     */
    @PutMapping("{id}/modify/{password}")
    public boolean modifyPassword(@PathVariable String id, @PathVariable String password) {
        try {
            Student student = new Student();
            student.setId(id);
            student.setPassword(password);
            studentService.modifyPassword(student);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除学生信息
     * @param id
     * @return
     */
    @DeleteMapping("delete/{id}")
    public boolean deleteStudent(@PathVariable String id) {
        try {
            studentService.deleteStudent(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 学生登录校验
     * @param id
     * @param password
     * @return
     */
    @PutMapping("/login/{id}/{password}")
    @ResponseBody
    public boolean login(@PathVariable String id, @PathVariable String password) {
        try {
            Student student = new Student();
            student.setId(id);
            student.setPassword(password);
            boolean bool = studentService.login(student);
            return bool;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 更新学生信息
     * @param student
     * @return
     */
    @PutMapping("/update/info")
    public boolean updateStudentInfo(@RequestBody Student student){
        try {
            studentService.updateStudentInfo(student);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @GetMapping("/add")
    public boolean addNewStudent(@RequestBody Student student){
        try{
            studentService.addStudent(student);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
