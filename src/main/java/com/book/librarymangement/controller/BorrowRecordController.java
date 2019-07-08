package com.book.librarymangement.controller;

import com.book.librarymangement.entity.BorrowRecord;
import com.book.librarymangement.sevice.BorrowRecordService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/record")
public class BorrowRecordController {
    @Resource
    private BorrowRecordService borrowRecordService;

    /**
     * 根据时间比较结果 赋值 借阅状态
     * @param list
     * @return
     */
    private List<BorrowRecord> formatList(List<BorrowRecord> list){
        list.forEach(v -> {
            if (compareTime(v.getStartTime(),v.getBorrowTime())){
                v.setStatusName("借阅中");
            }else{
                v.setStatusName("已超期");
            }
        });
        return list;
    }

    /**
     * 比较借阅起始时间 + day 与 当前时间作比较
     * @param date
     * @param day
     * @return
     */
    private boolean compareTime(Date date, int day){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,day);
        return calendar.getTime().getTime() < new Date().getTime();
    }

    @GetMapping("/select/book/{id}")
    @ResponseBody
    public List<BorrowRecord> selectByBookId(@PathVariable int id){
        try {
            return formatList(borrowRecordService.selectRecordByBookId(id));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/select/{studentId}")
    @ResponseBody
    public List<BorrowRecord> selectByStudentId(@PathVariable String studentId){
        try {
            return formatList(borrowRecordService.selectRecordByStudentId(studentId));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 借书
     * @param studentId
     * @param bookId
     * @param day
     * @return
     */
    @GetMapping("/borrow/{studentId}/{bookId}/{day}")
    public boolean borrowBook(@PathVariable String studentId, @PathVariable int bookId, @PathVariable int day){
        try {
            borrowRecordService.borrowBook(studentId, bookId, day);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 还书
     * @param studentId
     * @param bookId
     * @return
     */
    @GetMapping("/return/{studentId}/{bookId}")
    public boolean returnBook(@PathVariable String studentId, @PathVariable int bookId) {
        try {

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
